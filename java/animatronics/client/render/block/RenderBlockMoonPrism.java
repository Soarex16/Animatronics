package animatronics.client.render.block;

import org.lwjgl.opengl.GL11;

import animatronics.client.render.LibRenderIDs;
import animatronics.client.render.tile.RenderTileEntityMoonPrism;
import animatronics.common.tile.TileEntityMoonPrism;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockMoonPrism implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			RenderTileEntityMoonPrism.renderInInventory(new TileEntityMoonPrism(), 0D, 0D, 0D, 0F);
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
		return LibRenderIDs.idblockMoonPrism;
	}

}
