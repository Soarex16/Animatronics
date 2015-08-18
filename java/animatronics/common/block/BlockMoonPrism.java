package animatronics.common.block;

import java.util.Calendar;
import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.common.tile.TileEntityMoonPrism;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class BlockMoonPrism extends BlockContainerBase implements InformationProvider {

	public BlockMoonPrism() {
		super("blockMoonPrism", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMoonPrism();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(calendar.MONTH) == calendar.APRIL && calendar.get(calendar.DAY_OF_MONTH) == 1)
		list.add(StatCollector.translateToLocal("tile.blockMoonPrism.easterEgg"));
	}

}
