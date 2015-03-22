package animatronica.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.debug.BlockDebug;
import animatronica.debug.RenderBlockDebug;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlocksAnimatronica implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if (block instanceof BlockDebug){
			GL11.glPushMatrix();
	        GL11.glTranslatef(0F,-0.5F,0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(RenderBlockDebug.texture);
	        RenderBlockDebug renderBlockDebug = new RenderBlockDebug();
	        renderBlockDebug.doRender();
	        GL11.glPopMatrix();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if (block instanceof BlockDebug){
			GL11.glPushMatrix();
	        GL11.glTranslatef(0F,-0.5F,0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(RenderBlockDebug.texture);
	        RenderBlockDebug renderBlockDebug = new RenderBlockDebug();
	        renderBlockDebug.doRender();
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
		return 240925565;
	}

}
