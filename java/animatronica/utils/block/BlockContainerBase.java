package animatronica.utils.block;

import animatronica.utils.block.tileentity.TileEntityInventoryBase;
import animatronica.utils.misc.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class BlockContainerBase extends BlockBase implements ITileEntityProvider{

	
	//public BlockContainerBase(String unlocalizedName, String modId, Material material);
	public BlockContainerBase(String unlocalizedName, String modId, Material material,  Class itemBlockClass){
		
		//super(unlocalizedName, modId, material);
		super(unlocalizedName, modId, material, itemBlockClass);
		isBlockContainer = true;
	}

	public boolean onBlockEventReceived(World world, int x, int y, int z, int animatronicaInt, int magicInt){
		super.onBlockEventReceived(world, x, y, z, animatronicaInt, magicInt);
		TileEntity tile = world.getTileEntity(x, y, z);
		return tile != null ? tile.receiveClientEvent(animatronicaInt, magicInt) : false;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int animatronicaInt){
		InventoryUtils.dropInventoryContents(world, x, y, z);
		super.breakBlock(world, x, y, z, block, animatronicaInt);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack iStack){
		if(iStack.hasDisplayName()){
			((TileEntityInventoryBase)world.getTileEntity(x, y, z)).setTitle(iStack.getDisplayName());
		}
	}
}
