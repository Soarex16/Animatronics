package animatronics.client.fx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import org.lwjgl.opengl.GL11;

import animatronics.utils.misc.Vector3;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FXRenderingHandler {
	
	private static final ResourceLocation outsideResource = new ResourceLocation(FXHelper.MISC_WISP_LARGE);
	private static final ResourceLocation insideResource = new ResourceLocation(FXHelper.MISC_WISP_SMALL);

	static double interpPosX;
	static double interpPosY;
	static double interpPosZ;

	private static Vector3 getRelativeViewVector(Vector3 pos) {
		Entity renderEntity = Minecraft.getMinecraft().renderViewEntity;
		return new Vector3((float) renderEntity.posX - pos.x, (float) renderEntity.posY + renderEntity.getEyeHeight() - pos.y, (float) renderEntity.posZ - pos.z);
	}

	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent event) {
		Profiler profiler = Minecraft.getMinecraft().mcProfiler;

		profiler.startSection("animatronics-particles");
		FXHelper.dispatch();

		float frame = event.partialTicks;
		Entity entity = Minecraft.getMinecraft().thePlayer;
		TextureManager render = Minecraft.getMinecraft().renderEngine;

		interpPosX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * frame;
		interpPosY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * frame;
		interpPosZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * frame;

		GL11.glPushMatrix();
		GL11.glTranslated(-interpPosX, -interpPosY, -interpPosZ);

		Tessellator tessellator = Tessellator.instance;

		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		render.bindTexture(outsideResource);
		tessellator.startDrawingQuads();
		tessellator.setBrightness(0xF000F0);
		tessellator.draw();

		render.bindTexture(insideResource);
		tessellator.startDrawingQuads();
		tessellator.setBrightness(0xF000F0);
		tessellator.draw();

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);

		GL11.glTranslated(interpPosX, interpPosY, interpPosZ);
		GL11.glPopMatrix();

		profiler.endSection();
		profiler.endSection();

	}

}