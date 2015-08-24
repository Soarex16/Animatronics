package animatronics.debug;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.misc.InformationProvider;
import animatronics.client.render.LibRenderIDs;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.ItemUtils;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockDebug extends BlockContainerBase implements InformationProvider {
	
	public BlockDebug(){
		super("blockDebug", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setLightLevel(0.25F);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName("BlockDebug");
	}	
	
	public int getRenderType(){
		return LibRenderIDs.idBlockDebug;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + ItemUtils.getInfoProviderTag(ItemUtils.INFO_TAG_DEV));
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityDebug();
	}

}
