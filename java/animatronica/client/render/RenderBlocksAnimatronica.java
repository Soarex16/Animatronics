package animatronica.client.render;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.debug.BlockDebug;
import animatronica.debug.ModelBlockDebug;
import animatronica.network.proxy.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlocksAnimatronica implements ISimpleBlockRenderingHandler {
	
	public final static ResourceLocation textureModelBlockDebug = new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelBlockDebug.png");
	public final static ModelBlockDebug modelBlockDebug = new ModelBlockDebug();	
	
	//Maybe, I need to use tesselator?
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if (block instanceof BlockDebug){
			GL11.glPushMatrix();
			GL11.glScaled(0.85D, 0.85D, 0.85D);
	        GL11.glTranslatef(0F,-0.5F,0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textureModelBlockDebug);
	        this.modelBlockDebug.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        //modelBlockDebug.renderModel(0.0625F);
	        GL11.glPopMatrix();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if (block instanceof BlockDebug){
			GL11.glPushMatrix();
	        GL11.glTranslatef(0F,-0.5F,0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textureModelBlockDebug);
	        modelBlockDebug.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        this.modelBlockDebug.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        //modelBlockDebug.renderModel(0.0625F);
	        GL11.glPopMatrix();
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.renderID;
	}

}
