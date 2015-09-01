package animatronics.common.block;

import animatronics.Animatronics;
import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.api.recipes.EntropyCrusherRecipe;
import animatronics.api.recipes.EntropyCrusherRecipes;
import animatronics.client.gui.GuiEntropyCrusher;
import animatronics.common.inventory.ContainerEntropyCrusher;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import animatronics.utils.misc.EnergyUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class TileEntityEntropyCrusher extends TileEntityPrimary implements ITERequiresEntropy, ITileEntityHasGUI {
	
	public EntropyCrusherRecipe currentRecipe;
	public int time;
	
	public TileEntityEntropyCrusher() {
		super();
		setSlotsNum(3);
		maxEntropy = 10000;
	}
	
	public void updateEntity() {
		super.updateEntity();
		EnergyUtils.manage(this, 0.5F, 0.5F, 0.5F);
		EntropyCrusherRecipe rec = EntropyCrusherRecipes.getRecipe(getStackInSlot(0));
	}
	
	public boolean canFunction(EntropyCrusherRecipe recipe) {
		if(getStackInSlot(1) == null && getStackInSlot(2) == null) {
			return true;
		} else { 
			if(getStackInSlot(1).isItemEqual(recipe.getResult()) && getStackInSlot(2).isItemEqual(recipe.getSecondResult())) {
				if(getStackInSlot(1).stackSize+recipe.getResult().stackSize <= getInventoryStackLimit() && getStackInSlot(2).stackSize+recipe.getSecondResult().stackSize <= getInventoryStackLimit() && getStackInSlot(1).stackSize+recipe.getResult().stackSize <= this.getStackInSlot(1).getMaxStackSize() && getStackInSlot(2).stackSize+recipe.getSecondResult().stackSize <= this.getStackInSlot(2).getMaxStackSize()) {
					return true;
				}
			}	
		}
		return false;
	}
	
	public void craft() {
		if(canFunction(currentRecipe)) {
			ItemStack result = currentRecipe.getResult().copy();
			ItemStack secondResult = currentRecipe.getSecondResult().copy();
			if(getStackInSlot(1) == null && getStackInSlot(2) == null) {
				setInventorySlotContents(1, result.copy());
				setInventorySlotContents(2, secondResult.copy());
			} else if(getStackInSlot(1) == null && getStackInSlot(2) != null) {
				setInventorySlotContents(1, result.copy());
				setInventorySlotContents(2, new ItemStack(secondResult.getItem(), secondResult.stackSize+getStackInSlot(2).stackSize, secondResult.getItemDamage()));
			} else if(getStackInSlot(1) != null && getStackInSlot(2) == null) {
				setInventorySlotContents(2, secondResult.copy());
				setInventorySlotContents(1, new ItemStack(result.getItem(), result.stackSize+getStackInSlot(1).stackSize, result.getItemDamage()));
			} else if(getStackInSlot(1) != null && getStackInSlot(2) != null) {
				setInventorySlotContents(1, new ItemStack(result.getItem(), result.stackSize+getStackInSlot(1).stackSize, result.getItemDamage()));
				setInventorySlotContents(2, new ItemStack(secondResult.getItem(), secondResult.stackSize+getStackInSlot(2).stackSize, secondResult.getItemDamage()));
			}
			decrStackSize(0, 1);
		}
	}
	
	public void animation() {
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.62F, yCoord+0.58F, zCoord+0.6F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.62F, yCoord+0.58F, zCoord+0.38F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.38F, yCoord+0.58F, zCoord+0.6F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.38F, yCoord+0.58F, zCoord+0.38F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
	}

	@Override
	public int[] getOutputSlots() {
		return new int[]{1,2};
	}

	@Override
	public Container getContainer(EntityPlayer player) {
		return new ContainerEntropyCrusher(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player) {
		return new GuiEntropyCrusher(getContainer(player), this);
	}

}
