package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.common.tile.TileEntityGatewayMirror;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.ItemUtils;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockGatewayMirror extends BlockContainerBase implements InformationProvider {

	public BlockGatewayMirror() {
		super("blockGatewayMirror", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}
	
	public int getRenderType(){
		return LibRenderIDs.idGatewayMirror;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

	public boolean isFullCube()
	{
		return false;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGatewayMirror();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
	}
}
