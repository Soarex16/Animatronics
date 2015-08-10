package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntitySunCollector;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.misc.InformationProvider;
import animatronics.utils.misc.ItemUtils;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockSunCollector extends BlockContainerBase implements InformationProvider {

	public BlockSunCollector(String unlocalizedName, String modId, Material material, Class itemBlockClass) {
		super(unlocalizedName, modId, material, itemBlockClass);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySunCollector();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
	}

}
