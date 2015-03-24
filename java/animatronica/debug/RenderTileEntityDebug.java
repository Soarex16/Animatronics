package animatronica.debug;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;

public class RenderTileEntityDebug extends TileEntitySpecialRenderer{

	public final static ResourceLocation textureModelBlockDebug = new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelBlockDebug.png");
	public final static ModelBlockDebug modelBlockDebug = new ModelBlockDebug();	
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		bindTexture(textureModelBlockDebug);
			GL11.glPushMatrix();
			modelBlockDebug.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();		
		
	}
}
