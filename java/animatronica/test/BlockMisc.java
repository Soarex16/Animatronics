package animatronica.test;

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

public class BlockMisc extends BlockContainerBase implements InformationProvider{

	public BlockMisc(String unlocalizedName, String modId, Material material, Class<ItemBlockAnimatronica> class1){
		super(unlocalizedName, modId, material, class1);
		this.setCreativeTab(Animatronica.creativeTabAnimatronica);
	}	

	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) {
		lst.add(EnumChatFormatting.GOLD + "Fuck");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return null;
	}

}
