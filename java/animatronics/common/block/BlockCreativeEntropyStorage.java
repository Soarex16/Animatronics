package animatronics.common.block;

import java.util.List;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntityCreativeEntropyStorage;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.InformationProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockCreativeEntropyStorage  extends BlockContainerBase implements InformationProvider {

	public BlockCreativeEntropyStorage(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronics> itemBlockClass) {
		super(unlocalizedName, modId, material, itemBlockClass);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		setLightLevel(0.25F);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName("blockCreativeEntropyStorage");
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + " [ONLY FOR DEVELOPERS]");
		//list.add(" "+EnumChatFormatting.DARK_RED+""+EnumChatFormatting.OBFUSCATED+"Pasta take over the world!");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityCreativeEntropyStorage();
	}

}
