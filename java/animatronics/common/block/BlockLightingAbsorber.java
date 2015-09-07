package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.common.tile.TileEntityLightingAbsorber;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLightingAbsorber extends BlockContainerBase implements InformationProvider {

	public BlockLightingAbsorber() {
		super("blockLightingAbsorber", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.125F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLightingAbsorber();
	}
	
	public int getRenderType() {
		return LibRenderIDs.idLightingAbsorber;
	}
	
	public boolean isFullCube() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {		
	}

}
