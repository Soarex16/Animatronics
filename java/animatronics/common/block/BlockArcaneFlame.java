package animatronics.common.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.common.tile.TileEntityArcaneFlame;
import animatronics.utils.block.BlockContainerBase;

public class BlockArcaneFlame extends BlockContainerBase implements InformationProvider{

	public BlockArcaneFlame() {
		super("blockArcaneFlame", Animatronics.MOD_ID, Material.cloth, ItemBlockArcaneFlame.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(0.2F);
		setBlockBounds(0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
		setStepSound(soundTypeCloth);
		setLightLevel(1.0f);
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
		list.add(EnumChatFormatting.LIGHT_PURPLE + "Witch hammer");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityArcaneFlame();
	}

}
