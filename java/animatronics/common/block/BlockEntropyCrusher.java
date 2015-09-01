package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEntropyCrusher extends BlockContainerBase implements InformationProvider {

	public BlockEntropyCrusher() {
		super("blockEntropyCrusher", Animatronics.MOD_ID, Material.rock, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityEntropyCrusher();
	}
	
	public int getRenderType() {
		return LibRenderIDs.idEntropyCrusher;
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
		list.add("WIP");
	}

}
