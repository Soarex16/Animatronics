package animatronica.client.render;

import java.awt.Color;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.utils.handler.ClientTickHandler;

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
	
	public static void spawnFlame(World worldObj, double x, double y, double z, int color, float chance) {

		if(Math.random() < chance) {

			float v = 0.1F;

			float r = (float) (color >> 16 & 0xFF) / 0xFF + (float) (Math.random() - 0.5) * v;
			float g = (float) (color >> 8 & 0xFF) / 0xFF + (float) (Math.random() - 0.5) * v;
			float b = (float) (color & 0xFF) / 0xFF + (float) (Math.random() - 0.5) * v;

			float w = 0.15F;
			float h = 0.05F;
			double xF = x + (Math.random() - 0.5) * w;
			double yF = y + (Math.random() - 0.5) * h;
			double zF = z + (Math.random() - 0.5) * w;

			float s = 0.2F + (float) Math.random() * 0.1F;
			float m = 0.005F + (float) Math.random() * 0.015F;

			Animatronica.proxy.wispFX(worldObj, xF, yF, zF, r, g, b, s, -m);
		}
	}

	public static void renderStack(World worldObj, ItemStack stack, TileEntity tile, double xOffset, double yOffset, double zOffset, double xScale, double yScale, double zScale, boolean fancy, float speed , boolean clockwise){
			ItemStack toRender;
			RenderItem renderItems = new RenderItem();
			if(stack != null){
			toRender = stack.copy();
			toRender.stackSize = 1;
			EntityItem entityItem = new EntityItem(worldObj, tile.xCoord, tile.yCoord, tile.zCoord, toRender);
			entityItem.hoverStart = 0f;
			if(fancy){
				GL11.glPushMatrix();
				float rotational = (Minecraft.getSystemTime()) / (3000.0F) * 300.0F;
				GL11.glPushMatrix();
				GL11.glTranslated(xOffset, yOffset, zOffset);
				GL11.glScaled(xScale, yScale, zScale);
				GL11.glRotatef(180, 1, 0, 0);
				if(clockwise) GL11.glRotatef(-rotational / speed, 0F, 1.0F, 0F);
				else GL11.glRotatef(rotational / speed, 0F, 1.0F, 0F);	
				RenderManager.instance.renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}else{
				GL11.glPushMatrix();
				GL11.glTranslated(xOffset, yOffset, zOffset);
				GL11.glScaled(xScale, yScale, zScale);
				RenderItem.renderInFrame = true;
				GL11.glRotatef(180, 0, 1, 1);
				RenderManager.instance.renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
				RenderItem.renderInFrame = false;
				GL11.glPopMatrix();	
			}
		}
	}
	
	//ShaderGroups IDs - 
			//0 - Pixelated
			//1 -  Smooth
			//2 - Bright, Highly blured
			//3 - High contrast, Pixel outline
			//4 - Bright, Medium blured
			//5 - Bright, Black&white only, Pixel Outline
			//6 - Default, ++Colors
			//7 - 3D anaglyph
			//8 - Upside-down
			//9 - Inverted Colors
			//10 - Television Screen
			//11 - Small pixel outline, Small blur
			//12 - Moving image overlay
			//13 - Default, Television screen overlay
			//14 - Pixel outline, White-Black colors inverted, other stay the same
			//15 - Highly pixelated
			//16 - Default, --Colors
			//17 - Television Screen, Green vision, Highly pixelated
			//18 - Blured vision
			//19 - Drugs
			//20 - Pixels highly smoothened
			//21 - Small blur
			//22 - List Index End
	public static final ResourceLocation[] defaultShaders = new ResourceLocation[] {new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json")};
}
