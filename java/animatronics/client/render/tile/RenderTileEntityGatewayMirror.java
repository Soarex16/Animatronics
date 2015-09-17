package animatronics.client.render.tile;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.api.misc.Vector3;
import animatronics.client.render.BlockOutlineRender;
import animatronics.client.render.IBlockOutlineRenderingRequester;
import animatronics.common.tile.TileEntityGatewayMirror;
import animatronics.utils.handler.ClientTickHandler;
import animatronics.utils.misc.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderTileEntityGatewayMirror extends TileEntitySpecialRenderer{
	
	public final static ResourceLocation textureGatewayMirror = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/GatewayMirror.png");
	private static final IModelCustom modelGatewayMirror = AdvancedModelLoader.loadModel(new ResourceLocation(Animatronics.MOD_ID + ":" + "models/GatewayMirror.obj") );
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		/*TileEntityGatewayMirror t = (TileEntityGatewayMirror)tile;
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
			GL11.glScaled(0.5, 0.5, 0.5);
			GL11.glPushMatrix();
				GL11.glRotated(180, 0, 1, 0);
				GL11.glTranslated(t.move, 0, 0);
				GL11.glTranslated(-t.back, 0, 0);
				bindTexture(textureGatewayMirror);
				modelGatewayMirror.renderAll();
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				GL11.glTranslated(t.move, 0, 0);
				GL11.glTranslated(-t.back, 0, 0);
				bindTexture(textureGatewayMirror);
				modelGatewayMirror.renderAll();
			GL11.glPopMatrix();
		GL11.glPopMatrix();
		*/
		// JUST FOR TEST. TO BE REMOVED! 
		//BlockOutlineRender.renderBlockOutlineAtBlock(Vector3.fromTileEntity(tile), 0xffffff);
		BlockOutlineRender.addRenderingRequsetToQueue((IBlockOutlineRenderingRequester)tile);
	}
	
}
