package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntityHeatCollapsor;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronica;
import animatronics.utils.misc.InformationProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockHeatCollapsor  extends BlockContainerBase implements InformationProvider {

	public BlockHeatCollapsor(String unlocalizedName, String modId, Material iron, Class<ItemBlockAnimatronica> itemBlockClass) {
		super(unlocalizedName, modId, iron, itemBlockClass);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName("blockHeatCollapsor");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHeatCollapsor();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + " Creates" );
	}

}
