package animatronica.debug;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import animatronica.client.render.LibRenderIDs;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockDebug implements ISimpleBlockRenderingHandler {
	
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			RenderTileEntityDebug.renderInInventory(new TileEntityDebug(), 0D, 0D, 0D, 0F);
			//TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityDebug(), 0.0D, 0.0D, 0.0D, 0.0F);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return LibRenderIDs.idBlockDebug;
	}

}
