package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntityArcaneFlame;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronica;
import animatronics.utils.misc.InformationProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockArcaneFlame extends BlockContainerBase implements InformationProvider{

	public BlockArcaneFlame(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronica> itemBlockClass) {
		super(unlocalizedName, modId, material, itemBlockClass);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		//setLightLevel(0.75F);
		setHardness(0.2F);
		setBlockBounds(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean isFullCube()
	{
		return false;
	}

	public int getRenderType(){
		return -1;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.LIGHT_PURPLE + "This flame contains magic power");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityArcaneFlame();
	}

}
