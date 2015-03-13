package animatronica.test;

import net.minecraft.block.material.Material;
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
		setBlockBounds(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
	}	
	
	public int getRenderType(){
		return 666;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int metadata){
		return new TileEntityTest();
	}

}
