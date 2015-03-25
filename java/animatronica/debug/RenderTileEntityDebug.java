package animatronica.debug;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import animatronica.Animatronica;
import animatronica.client.render.RenderShapePatterns;

@SideOnly(Side.CLIENT)
public class RenderTileEntityDebug extends TileEntitySpecialRenderer{

	public final static ResourceLocation textureModelBlockDebug = new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelBlockDebug.png");
	public final static ModelBlockDebug modelBlockDebug = new ModelBlockDebug();	
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		TileEntityDebug tileDebug = (TileEntityDebug) tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		bindTexture(textureModelBlockDebug);
			GL11.glPushMatrix();
			modelBlockDebug.renderModel(0.0625F);
			GL11.glTranslated(0,1,0);
			GL11.glRotated(tileDebug.rotate, 1, 1, 1);
			RenderShapePatterns.renderStar(0x00CC00, 0x00CC00, 75, 75F, 0.01F, 0.01F, 0.01F, 432L);
			GL11.glPopMatrix();
		GL11.glPopMatrix();		
	}
	
	public static void renderInInventory(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(textureModelBlockDebug);
			GL11.glPushMatrix();
			modelBlockDebug.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();	
	}
}
