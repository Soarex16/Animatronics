package animatronics.common.block;

import java.util.List;

import javax.swing.Icon;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.common.tile.TileEntityHeatCollapser;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
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

public class BlockHeatCollapser extends BlockContainerBase implements InformationProvider {

	public IIcon[] icons = new IIcon[6];
	
	public BlockHeatCollapser() {
		super("blockHeatCollapser", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setHardness(1.0F);
		setResistance(10.0F);
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityHeatCollapser();
	}

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_WIP));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		icons[0] = reg.registerIcon("animatronics:gen_base");
		icons[1] = reg.registerIcon("animatronics:heatCollapser_1");
		icons[2] = reg.registerIcon("animatronics:heatCollapser_2");
		icons[3] = reg.registerIcon("animatronics:heatCollapser_2");
		icons[4] = reg.registerIcon("animatronics:heatCollapser_2");
		icons[5] = reg.registerIcon("animatronics:heatCollapser_2");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}

}
