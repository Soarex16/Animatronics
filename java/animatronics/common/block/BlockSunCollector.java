package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntitySunCollector;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.misc.InformationProvider;
import animatronics.utils.misc.ItemUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSunCollector extends BlockContainerBase implements InformationProvider {

	public IIcon[] icons = new IIcon[6];
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		icons[0] = reg.registerIcon("animatronics:sunCollector_0");
		icons[1] = reg.registerIcon("animatronics:sunCollector_1");
		icons[2] = reg.registerIcon("animatronics:sunCollector_2");
		icons[3] = reg.registerIcon("animatronics:sunCollector_2");
		icons[4] = reg.registerIcon("animatronics:sunCollector_2");
		icons[5] = reg.registerIcon("animatronics:sunCollector_2");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}

}
