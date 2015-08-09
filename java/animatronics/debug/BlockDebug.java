package animatronics.debug;

import java.util.List;

import animatronics.Animatronics;
import animatronics.client.render.LibRenderIDs;
import animatronics.utils.block.BlockContainerBase;
import animatronics.utils.block.ItemBlockAnimatronics;
import animatronics.utils.misc.ICoordClickable;
import animatronics.utils.misc.InformationProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockDebug extends BlockContainerBase implements InformationProvider {
	
	public BlockDebug(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronics> itemBlockClass){
		super(unlocalizedName, modId, material, itemBlockClass);
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
		list.add(EnumChatFormatting.GOLD + " [ONLY FOR DEVELOPERS]");
		//list.add(" "+EnumChatFormatting.DARK_RED+""+EnumChatFormatting.OBFUSCATED+"Pasta take over the world!");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityDebug();
	}

}
