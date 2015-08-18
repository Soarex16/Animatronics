package animatronics.client.render.tile;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.model.ModelCrystal;
import animatronics.client.model.ModelLens;
import animatronics.common.tile.TileEntityMoonPrism;
import net.minecraft.client.Minecraft;
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
		TileEntityMoonPrism tileMoonPrism = new TileEntityMoonPrism();
		GL11.glPushMatrix();
			GL11.glPushMatrix();
				bindTexture(textureModelLens);
				GL11.glRotated(Math.sin(tileMoonPrism.rotation) * 3, 0, 1, 0);
				modelLens.renderModel(0.03125F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				bindTexture(textureModelLens);
				GL11.glRotated(-Math.sin(tileMoonPrism.rotation) * 3, 0, 1, 0);
				modelLens.renderModel(0.015625F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				bindTexture(textureModelCrystal);
				modelCrystal.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	public static void renderInInventory(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(textureModelLens);
			GL11.glPushMatrix();
			modelLens.renderModel(0.03125F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();	
	}
}
