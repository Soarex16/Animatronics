package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.common.tile.TileEntityFabricatorOfEverything;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.ItemUtils;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockFabricatorOfEverything extends BlockContainerBase implements InformationProvider {

	public BlockFabricatorOfEverything() {
		super("blockFabricatorOfEverything", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}
	
	public int getRenderType(){
		return LibRenderIDs.id;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFabricatorOfEverything();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
	}
}
