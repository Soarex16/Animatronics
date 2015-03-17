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
import animatronica.utils.helper.InformationProvider;

public class BlockTest extends BlockContainerBase implements InformationProvider{
	
	public BlockTest(String unlocalizedName, String modId, Material material){
		super(unlocalizedName, modId, material, null);
		setCreativeTab(Animatronica.creativeTabAnimatronica);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName(unlocalizedName);
		setBlockBounds(0,0,0,1,1,1);
		setBlockBounds(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
	}	
	
	public int getRenderType(){
		return 0;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) {
		lst.add(EnumChatFormatting.GOLD + "Fuck");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityTest();
	}

}
