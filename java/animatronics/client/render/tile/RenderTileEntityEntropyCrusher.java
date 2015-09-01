package animatronics.client.render.tile;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.model.ModelEntropyCrusher;
import animatronics.client.render.RenderPatterns;
import animatronics.common.block.TileEntityEntropyCrusher;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityEntropyCrusher extends TileEntitySpecialRenderer {

	public final static ResourceLocation textureEntropyCrusher = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/modelEntropyCrusher.png");
	public final static ModelEntropyCrusher modelEntropyCrusher = new ModelEntropyCrusher();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z,float f) {
		TileEntityEntropyCrusher crusher = new TileEntityEntropyCrusher();
		GL11.glPushMatrix();
			GL11.glTranslated(x+0.5, y+1.5, z+0.5);
			GL11.glRotated(180, 0, 0, 1);
			RenderHelper.disableStandardItemLighting();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor4f(1, 1, 1, 1F);
        	GL11.glEnable(GL11.GL_BLEND);
        	OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        		GL11.glPushMatrix();
        			bindTexture(textureEntropyCrusher);
        			modelEntropyCrusher.renderModel(0.0625F);
        		GL11.glPopMatrix();
        		GL11.glPushMatrix();
        			RenderPatterns.renderStack(crusher.getWorldObj(), crusher.getStackInSlot(0), crusher, 0.5, 0.25, 0.5, 0.5, 0.5, 0.5, true, 1.0F, true);
        		GL11.glPopMatrix();
        	GL11.glEnable(GL11.GL_LIGHTING);
        	RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}

}
