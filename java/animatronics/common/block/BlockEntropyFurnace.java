package animatronics.common.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.common.tile.TileEntityEntropyFurnace;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.ItemUtils;

public class BlockEntropyFurnace extends BlockContainerBase implements InformationProvider{

	public BlockEntropyFurnace() {
		super("blockEntropyFurnace", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World w, int i) {
		return new TileEntityEntropyFurnace();
	}
 
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
	}

}
