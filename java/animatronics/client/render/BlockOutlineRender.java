package animatronics.client.render;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import org.lwjgl.opengl.GL11;

import animatronics.api.IItemBlockOutline;
import animatronics.utils.handler.ClientTickHandler;
import animatronics.utils.misc.Vector3;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BlockOutlineRender {
	
	@SubscribeEvent
	public void onWorldRenderLast(RenderWorldLastEvent event) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);

		Tessellator.renderingWorldRenderer = false;
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack stack = player.getCurrentEquippedItem();
		int color = Color.HSBtoRGB(ClientTickHandler.ticksInGame % 200 / 40F, 0.6F, 1F);
		if(stack != null && stack.getItem() instanceof IItemBlockOutline) {
			Vector3 coords = ((IItemBlockOutline)stack.getItem()).getBindingCoordinates(stack);
			if(coords != null)
				renderBlockOutlineAt(coords, color);
		}
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	private void renderBlockOutlineAt(Vector3 pos, int color) {
		renderBlockOutlineAt(pos, color, 1F);
	}
	
	private void renderBlockOutlineAt(Vector3 pos, int color, float thickness) {
		GL11.glPushMatrix();
		GL11.glTranslated(pos.x - RenderManager.renderPosX, pos.y - RenderManager.renderPosY, pos.z - RenderManager.renderPosZ + 1);
		Color colorRGB = new Color(color);
		GL11.glColor4ub((byte) colorRGB.getRed(), (byte) colorRGB.getGreen(), (byte) colorRGB.getBlue(), (byte) 255);

		World world = Minecraft.getMinecraft().theWorld;
		Block block = world.getBlock((int)pos.x, (int)pos.y, (int)pos.z);
		drawWireframe : {
			if(block != null) {
				AxisAlignedBB axis = block.getSelectedBoundingBoxFromPool(world, (int)pos.x, (int)pos.y, (int)pos.z);
				if(axis == null)
					break drawWireframe;

				axis.minX -= pos.x;
				axis.maxX -= pos.x;
				axis.minY -= pos.y;
				axis.maxY -= pos.y;
				axis.minZ -= pos.z + 1;
				axis.maxZ -= pos.z + 1;

				GL11.glScalef(1F, 1F, 1F);

				GL11.glLineWidth(thickness);
				renderBlockOutline(axis);

				GL11.glLineWidth(thickness + 3F);
				GL11.glColor4ub((byte) colorRGB.getRed(), (byte) colorRGB.getGreen(), (byte) colorRGB.getBlue(), (byte) 64);
				renderBlockOutline(axis);
			}
		}

		GL11.glPopMatrix();
	}

	private void renderBlockOutline(AxisAlignedBB aabb) {
		Tessellator tessellator = Tessellator.instance;

		double ix = aabb.minX;
		double iy = aabb.minY;
		double iz = aabb.minZ;
		double ax = aabb.maxX;
		double ay = aabb.maxY;
		double az = aabb.maxZ;

		tessellator.startDrawing(GL11.GL_LINES);
		tessellator.addVertex(ix, iy, iz);
		tessellator.addVertex(ix, ay, iz);

		tessellator.addVertex(ix, ay, iz);
		tessellator.addVertex(ax, ay, iz);

		tessellator.addVertex(ax, ay, iz);
		tessellator.addVertex(ax, iy, iz);

		tessellator.addVertex(ax, iy, iz);
		tessellator.addVertex(ix, iy, iz);

		tessellator.addVertex(ix, iy, az);
		tessellator.addVertex(ix, ay, az);

		tessellator.addVertex(ix, iy, az);
		tessellator.addVertex(ax, iy, az);

		tessellator.addVertex(ax, iy, az);
		tessellator.addVertex(ax, ay, az);

		tessellator.addVertex(ix, ay, az);
		tessellator.addVertex(ax, ay, az);

		tessellator.addVertex(ix, iy, iz);
		tessellator.addVertex(ix, iy, az);

		tessellator.addVertex(ix, ay, iz);
		tessellator.addVertex(ix, ay, az);

		tessellator.addVertex(ax, iy, iz);
		tessellator.addVertex(ax, iy, az);

		tessellator.addVertex(ax, ay, iz);
		tessellator.addVertex(ax, ay, az);

		tessellator.draw();
	}
}
