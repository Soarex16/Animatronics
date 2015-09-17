package animatronics.client.render;

import java.awt.Color;
import java.util.LinkedList;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import org.lwjgl.opengl.GL11;

import animatronics.api.IItemBlockOutline;
import animatronics.api.misc.Vector3;
import animatronics.utils.handler.ClientTickHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BlockOutlineRender {
	
	public static LinkedList<IBlockOutlineRenderingRequester> queuedRenders = new LinkedList<IBlockOutlineRenderingRequester>();
	
	@SubscribeEvent
	public void onWorldRenderLast(RenderWorldLastEvent event) {
		drawByIItemBlockOutline();		
		for(IBlockOutlineRenderingRequester req : queuedRenders){
			drawWithCustomBounds(req.getPosition(), req.getColor(), req.getThickness(), req.getAABB());
		}
		
		queuedRenders.clear();
	}
	
	private static void drawByIItemBlockOutline(){
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
				renderBlockOutlineAtBlock(coords, color);
		}
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	public static void drawWithBlockBounds(Vector3 vec, int color){
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		
		Tessellator.renderingWorldRenderer = false;
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		renderBlockOutlineAtBlock(vec, color);

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		
	}
	
	public static void drawWithCustomBounds(Vector3 vec, int color, float thickness, AxisAlignedBB aabb){
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		renderBlockOutlineCustomBounds(vec, color, thickness,aabb);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	public static void renderBlockOutlineAtBlock(Vector3 pos, int color) {
		renderBlockOutlineAt(pos, color, 1F);
	}
	
	public static void renderBlockOutlineCustomBounds(Vector3 pos, int color, float thickness, AxisAlignedBB aabb) {
		RenderHelper.disableStandardItemLighting();
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		Tessellator.renderingWorldRenderer = false;
		renderBlockOutlineAt(pos, color, thickness, aabb);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
	
	private static void renderBlockOutlineAt(Vector3 pos, int color, float thickness) {
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
	
	private static void renderBlockOutlineAt(Vector3 pos, int color, float thickness, AxisAlignedBB axis) {
		GL11.glPushMatrix();
		GL11.glTranslated(pos.x - RenderManager.renderPosX, pos.y - RenderManager.renderPosY, pos.z - RenderManager.renderPosZ + 1);
		Color colorRGB = new Color(color);
		GL11.glColor4ub((byte) colorRGB.getRed(), (byte) colorRGB.getGreen(), (byte) colorRGB.getBlue(), (byte) 255);
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
		GL11.glPopMatrix();
	}

	private static void renderBlockOutline(AxisAlignedBB aabb) {
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
	
	public static void addRenderingRequsetToQueue(IBlockOutlineRenderingRequester iborr){
		queuedRenders.add(iborr);
	}
}
