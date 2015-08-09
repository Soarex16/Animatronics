package animatronics.common.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronics.Animatronics;
import animatronics.common.tile.TileEntityHeatCollapser;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.InformationProvider;
import animatronics.utils.misc.ItemUtils;

public class BlockHeatCollapser  extends BlockContainerBase implements InformationProvider {

	public BlockHeatCollapser(String unlocalizedName, String modId, Material iron, Class<ItemBlockAnimatronics> itemBlockClass) {
		super(unlocalizedName, modId, iron, itemBlockClass);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName("blockHeatCollapsor");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHeatCollapser();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
	//	list.add(EnumChatFormatting.GOLD + " Creates" );
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
		list.add("TODO: Fix shiftclick |abcdmult");

	}

}
