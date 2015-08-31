package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.common.tile.TileEntityNothing;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockNothing extends BlockContainerBase implements InformationProvider {

	public BlockNothing() {
		super("blockNothing", Animatronics.MOD_ID, Material.cloth, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
	}
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(final World w, final int i, final int j, final int k) {
        return AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return LibRenderIDs.idNothing;
    }
    
    public boolean hasTileEntity(int metadata) {
        return metadata == 1;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return (meta == 1) ? new TileEntityNothing() : null;
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add("Nothing!!!");
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (isBlockExposed(world, x, y, z)) {
            world.setBlockMetadataWithNotify(x, y, z, 1, 3);
        }
        else {
            world.setBlockMetadataWithNotify(x, y, z, 0, 3);
        }
        super.onNeighborBlockChange(world, x, y, z, block);
    }
    
    public static boolean isBlockExposed(World world, int x, int y, int z) {
        return !world.getBlock(x, y, z + 1).isOpaqueCube() || !world.getBlock(x, y, z - 1).isOpaqueCube() || !world.getBlock(x + 1, y, z).isOpaqueCube() || !world.getBlock(x - 1, y, z).isOpaqueCube() || !world.getBlock(x, y + 1, z).isOpaqueCube() || !world.getBlock(x, y - 1, z).isOpaqueCube();
    }

}
