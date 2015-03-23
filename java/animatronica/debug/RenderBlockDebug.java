/*
package animatronica.debug;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;

public class RenderBlockDebug {

	public final static ResourceLocation texture = new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelBlockDebug.png");
	public final static ModelBlockDebug model = new ModelBlockDebug();
	
	public void doRender(){
		GL11.glPushMatrix();
		GL11.glTranslated(0.5F, -0.25F, 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
			GL11.glPushMatrix();
				model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();	
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		this.doRender();
	}
}
*/