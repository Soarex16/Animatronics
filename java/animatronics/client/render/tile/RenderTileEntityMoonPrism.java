package animatronics.client.render.tile;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.model.ModelCrystal;
import animatronics.client.model.ModelLens;
import animatronics.common.tile.TileEntityMoonPrism;
import animatronics.utils.handler.ClientTickHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityMoonPrism extends TileEntitySpecialRenderer {
	
	public final static ResourceLocation textureModelLens = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/modelLens.png");
	public final static ResourceLocation textureModelCrystal = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/modelCrystal.png");
	public final static ModelLens modelLens = new ModelLens();
	public final static ModelCrystal modelCrystal = new ModelCrystal();	
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1F);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glPushMatrix();
				GL11.glTranslated(0, -0.15 + Math.cos(tile.getWorldObj().getWorldTime()/50.0)/15, 0);
				bindTexture(textureModelLens);
				GL11.glRotated(ClientTickHandler.ticksInGame, 0, 1, 0);
				modelLens.renderModel(0.03125F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				GL11.glTranslated(0, -0.2 + Math.cos(tile.getWorldObj().getWorldTime()/50.0)/15, 0);
				GL11.glScaled(0.5, 0.5, 0.5);
				bindTexture(textureModelCrystal);
				GL11.glRotatef(ClientTickHandler.ticksInGame, 0, 1, 0);
				modelCrystal.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				GL11.glTranslated(0, -0.55 + Math.cos(tile.getWorldObj().getWorldTime()/25.0)/30, 0);
				GL11.glScaled(0.5, 0.5, 0.5);
				bindTexture(textureModelLens);
				GL11.glRotatef(-ClientTickHandler.ticksInGame / 2, 0, 1, 0);
				modelLens.renderModel(0.03125F);
			GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
	
	public static void renderInInventory(TileEntity tile) {
		GL11.glPushMatrix();
		RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1F);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glRotatef(180, 0F, 0F, 1F);
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(textureModelLens);
			modelLens.renderModel(0.03125F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			//	GL11.glTranslated(0, -0.2 + Math.cos(tile.getWorldObj().getWorldTime()/50.0)/15, 0);
			System.out.println("render");	
			GL11.glScaled(0.5, 0.5, 0.5);
				Minecraft.getMinecraft().renderEngine.bindTexture(textureModelCrystal);
				modelCrystal.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);	
		GL11.glPopMatrix();	
		RenderHelper.enableStandardItemLighting();
	}
}
