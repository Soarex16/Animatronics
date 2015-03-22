package animatronica.debug;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.utils.block.BlockContainerBase;
import animatronica.utils.block.ItemBlockAnimatronica;
import animatronica.utils.helper.InformationProvider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class BlockDebug extends BlockContainerBase implements InformationProvider{
	
	public BlockDebug(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronica> class1){
		super(unlocalizedName, modId, material, class1);
		setCreativeTab(Animatronica.creativeTabAnimatronica);
		setHardness(1.0F);
		setResistance(10.0F);
	}	
	
	public int getRenderType(){
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) {
		lst.add(EnumChatFormatting.RED + " [ONLY FOR DEVELOPERS]");
		lst.add(EnumChatFormatting.OBFUSCATED + "can cause crashes");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityDebug();
	}

}
