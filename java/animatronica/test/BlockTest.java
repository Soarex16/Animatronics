package animatronica.test;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.utils.block.BlockContainerBase;

public class BlockTest extends BlockContainerBase {
	
	public BlockTest(String unlocalizedName, String modId, Material material){
		super(unlocalizedName, modId, material);
		setCreativeTab(Animatronica.creativeTabAnimatronica);
		setHardness(1.0F);
		setResistance(10.0F);
		setBlockTextureName(unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityTest();
	}

}
