package animatronica.debug;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.client.render.LibRenderIDs;
import animatronica.utils.block.BlockContainerBase;
import animatronica.utils.block.ItemBlockAnimatronica;
import animatronica.utils.helper.ICoordClickable;
import animatronica.utils.helper.InformationProvider;

public class BlockDebug extends BlockContainerBase implements InformationProvider {
	
	public BlockDebug(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronica> class1){
		super(unlocalizedName, modId, material, class1);
		setCreativeTab(Animatronica.creativeTabAnimatronica);
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
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			player.openGui(Animatronica.instance, 2, world, x, y, z);
			return true;
		}
		return true;
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
