package animatronica.client.render;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import animatronica.utils.block.tileentity.TileEntityInventoryBase;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.event.ClientTickHandler;

public class RenderPatterns {
	
	public static void renderStar(int color, int color2, int alfa, float density, float xScale, float yScale, float zScale, long seed) {
		Tessellator tessellator = Tessellator.instance;

		int ticks = ClientTickHandler.ticksInGame % 2000000000;//gameTick % 200;
		if (ticks-1 >= 200)
			ticks = 200 - ticks - 1;

		float f1 = ticks / 200F;
		float f2 = 0F;/*
		if (f1 > 0.7F)
			f2 = (f1 - 0.7F) / 0.2F;*/
		Random random = new Random(seed);

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 1);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glScalef(xScale, yScale, zScale);

		for (int i = 0; i < 90F; i++){//int i = 0; i < (f1 + f1 * f1) / 2F * 90F + density; i++
			GL11.glRotatef(random.nextFloat() * 360F, 1F, 0F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 1F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 0F, 1F);
			GL11.glRotatef(random.nextFloat() * 360F, 1F, 0F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 1F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F + f1 * 90F, 0F, 0F, 1F);
			tessellator.startDrawing(GL11.GL_TRIANGLE_FAN);
			float f3 = random.nextFloat() * 20F + 5F + f2 * 10F;
			float f4 = random.nextFloat() * 2F + 1F + f2 * 2F;
			tessellator.setColorRGBA_I(color, alfa);
			tessellator.addVertex(0, 0, 0);
			tessellator.setColorRGBA_I(color2, alfa);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0, f3, 1F * f4);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.draw();
		}

		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glPopMatrix();
	}

	public static void renderStackInSlot(TileEntity tile, double x, double y, double z, double xScale, double yScale, double zScale, int slot, boolean fancy, float speed , boolean clockwise){
		if(tile instanceof TileEntityInventoryBase) {
			ItemStack toRender;
			RenderItem renderItems = new RenderItem();
			if(((TileEntityInventoryBase) tile).getStackInSlot(slot) != null){
			toRender = ((TileEntityInventoryBase) tile).getStackInSlot(slot).copy();
			toRender.stackSize = 1;
			EntityItem entityItem = new EntityItem(tile.getWorldObj(), x, y, z, toRender);
			entityItem.hoverStart = 0f;
			if(fancy){
				GL11.glPushMatrix();
				float rotational = (Minecraft.getSystemTime()) / (3000.0F) * 300.0F;
				GL11.glPushMatrix();
				GL11.glTranslated(1, 1.75, 1);
				GL11.glScaled(xScale, yScale, zScale);
				GL11.glRotatef(180, 1, 0, 0);
				if(clockwise) GL11.glRotatef(-rotational / speed, 0F, 1.0F, 0F);
				else GL11.glRotatef(rotational / speed, 0F, 1.0F, 0F);	
				RenderManager.instance.renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}else{
				GL11.glPushMatrix();
				GL11.glTranslated(1, 1.6, 0.85);
				GL11.glScaled(xScale, yScale, zScale);
				RenderItem.renderInFrame = true;
				GL11.glRotatef(180, 0, 1, 1);
				RenderManager.instance.renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();	
				}
			}
		}
	}
}
