package animatronica.debug;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderBlockDebug implements ISimpleBlockRenderingHandler {

	private ModelBlockDebug model;

	public RenderBlockDebug(){
		model = new ModelBlockDebug(); 
	}
	
	public void renderModel(){
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, -0.25F, 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelBlockDebug.png"));
			GL11.glPushMatrix();
				model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();	
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if (block instanceof BlockDebug) {
			renderModel();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TileEntity tile = world.getTileEntity(x,y,z);
		if (tile instanceof TileEntityDebug) {	
			renderModel();
		}	
			return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderingRegistry.getNextAvailableRenderId();
	}

}