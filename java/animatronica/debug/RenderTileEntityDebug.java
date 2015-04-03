package animatronica.debug;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.client.render.RenderPatterns;
import animatronica.common.tile.TileAnimatronica;
import animatronica.utils.event.ClientTickHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
				GL11.glPushMatrix();
					//GL11.glTranslated(0.0F, 0.25F , -0.75F);
					//GL11.glRotated(45, 1F, 0F, 0F);
					GL11.glRotated(tileDebug.rotate, 0, 1, 0);
					modelBlockDebug.renderModel(0.0625F);
				GL11.glPopMatrix();
				GL11.glTranslated(0,1,0);
				//RenderPatterns.renderStar(0x00CC00, 0x00CC00, 75, 30F, 0.01F, 0.01F, 0.01F, 999L);
				float radius = 1.5F;
				double rads = ClientTickHandler.ticksInGame * 2 * Math.PI / 180;
				double starX = Math.cos(rads) * radius;
				double starZ = Math.sin(rads) * radius;
			GL11.glPushMatrix();
				GL11.glTranslated(starX, starZ, 0);
				//RenderPatterns.renderStar(0x000099, 0x0000FF, 75, 50F, 0.01F, 0.01F, 0.01F, 999L);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				GL11.glTranslated(starX, 0, starZ);
				//RenderPatterns.renderStar(0xFF0000, 0xFF0000, 75, 50F, 0.01F, 0.01F, 0.01F, 999L);
			GL11.glPopMatrix();
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
