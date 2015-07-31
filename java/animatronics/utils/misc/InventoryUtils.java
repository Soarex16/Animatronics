package animatronics.utils.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class InventoryUtils{

	public static boolean isItemStackInHotBar(EntityPlayer player, ItemStack item){
		for(int i = 0; i < player.inventory.getHotbarSize(); i++){
			if(player.inventory.getStackInSlot(i) != null){
				if(ItemStack.areItemStacksEqual(player.inventory.getStackInSlot(i), item)){
					return true;
				}
			}
		}
		return false;
	}

	public static void dropInventoryContents(World world, int x, int y, int z){
		TileEntity tile = world.getTileEntity(x, y, z);
		if(!(tile instanceof IInventory)){
			return;
		}
		IInventory inventory = (IInventory)tile;
		for(int slot = 0; slot < inventory.getSizeInventory(); slot++){
			ItemStack iStack = inventory.getStackInSlot(slot);
			if(iStack != null){
				WorldUtils.dropItemInRandomCoords(world, iStack, x, y, z);
			}
		}
	}

	/**
	 * @author King Lemming 
	 * 
	 * Copy an entire inventory. Best to avoid doing this often.
	 */
	public static ItemStack[] cloneInventory(ItemStack[] inventory){

		ItemStack[] inventoryCopy = new ItemStack[inventory.length];
		for(int i = 0; i < inventory.length; i++){
			inventoryCopy[i] = inventory[i] == null ? null : inventory[i].copy();
		}
		return inventoryCopy;
	}

	/**
	 * @author SanAndreasP
	 * 
	 * Add ItemStack to inventory.
	 */
	public static ItemStack addItemStackToInventory(ItemStack iStack, IInventory inventory){
        int invSize = inventory.getSizeInventory() - (inventory instanceof InventoryPlayer ? 4 : 0);
        for(int i = 0; i < invSize && iStack != null; i++){
            ItemStack inventoryStack = inventory.getStackInSlot(i);
            if(inventoryStack != null && iStack.isItemEqual(inventoryStack)){
                int combinedCount = iStack.stackSize + inventoryStack.stackSize;
                int maxStack = Math.min(inventoryStack.getMaxStackSize(), inventory.getInventoryStackLimit());
                if(combinedCount <= maxStack){
                    inventoryStack.stackSize = combinedCount;
                    inventory.setInventorySlotContents(i, inventoryStack.copy());
                    iStack = null;
                    break;
                }else{
                    int rest = combinedCount - maxStack;
                    inventoryStack.stackSize = maxStack;
                    inventory.setInventorySlotContents(i, inventoryStack.copy());
                    iStack.stackSize = rest;
                }
            }
        }
        /** If the given stack is not empty yet, search for an empty slot and put it there. */
        for(int c = 0; c < invSize && iStack != null; c++){
            ItemStack inventoryStack = inventory.getStackInSlot(c);
            if(inventoryStack == null && inventory.isItemValidForSlot(c, iStack)){
                if(iStack.stackSize <= inventory.getInventoryStackLimit()){
                    inventory.setInventorySlotContents(c, iStack.copy());
                    iStack = null;
                    break;
                }else{
                    int rest = iStack.stackSize - inventory.getInventoryStackLimit();
                    iStack.stackSize = inventory.getInventoryStackLimit();
                    inventory.setInventorySlotContents(c, iStack.copy());
                    iStack.stackSize = rest;
                }
            }
        }
        return iStack;
    }

	/** 
	 * @author King Lemming 
	 */
	public static ItemStack extractItemStackFromInventory(IInventory theInventory, int side){
		ItemStack retStack = null;
		if(theInventory instanceof ISidedInventory){
			ISidedInventory sidedInv = (ISidedInventory) theInventory;
			int slots[] = sidedInv.getAccessibleSlotsFromSide(side);
			for(int i = 0; i < slots.length && retStack == null; i++){
				if(sidedInv.getStackInSlot(i) != null && sidedInv.canExtractItem(i, sidedInv.getStackInSlot(i), side)){
					retStack = sidedInv.getStackInSlot(i).copy();
					sidedInv.setInventorySlotContents(i, null);
				}
			}
		}else{
			for(int i = 0; i < theInventory.getSizeInventory() && retStack == null; i++){
				if(theInventory.getStackInSlot(i) != null){
					retStack = theInventory.getStackInSlot(i).copy();
					theInventory.setInventorySlotContents(i, null);
				}
			}
		}
		if(retStack != null){
			theInventory.markDirty();
		}
		return retStack;
	}
	
	/** 
	 * @author King Lemming 
	 */
	public static ItemStack insertItemStackIntoSidedInventory(IInventory theInventory, ItemStack stack, int side){
		if(stack == null){
			return null;
		}
		int stackSize = stack.stackSize;
		if(theInventory instanceof ISidedInventory){
			ISidedInventory sidedInv = (ISidedInventory)theInventory;
			int slots[] = sidedInv.getAccessibleSlotsFromSide(side);
			if(slots == null){
				return stack;
			}
			for(int i = 0; i < slots.length && stack != null; i++){
				if(sidedInv.canInsertItem(slots[i], stack, side) && ItemUtils.itemsEqualWithMetadata(stack, theInventory.getStackInSlot(slots[i]), true)){
					stack = addToOccupiedInventorySlot(sidedInv, slots[i], stack);
				}
			}
			for(int i = 0; i < slots.length && stack != null; i++){
				if(sidedInv.canInsertItem(slots[i], stack, side) && theInventory.getStackInSlot(slots[i]) == null){
					stack = addToEmptyInventorySlot(sidedInv, slots[i], stack);
				}
			}
		}else{
			int invSize = theInventory.getSizeInventory();
			for(int i = 0; i < invSize && stack != null; i++){
				if(ItemUtils.itemsEqualWithMetadata(stack, theInventory.getStackInSlot(i), true)){
					stack = addToOccupiedInventorySlot(theInventory, i, stack);
				}
			}
			for(int i = 0; i < invSize && stack != null; i++){
				if(theInventory.getStackInSlot(i) == null){
					stack = addToEmptyInventorySlot(theInventory, i, stack);
				}
			}
		}
		if(stack == null || stack.stackSize != stackSize){
			theInventory.markDirty();
		}
		return stack;
	}

	/** 
	 * @author King Lemming 
	 */
	public static ItemStack addToEmptyInventorySlot(IInventory theInventory, int slot, ItemStack stack) {
		if(!theInventory.isItemValidForSlot(slot, stack)){
			return stack;
		}
		int stackLimit = theInventory.getInventoryStackLimit();
		theInventory.setInventorySlotContents(slot, ItemUtils.cloneStack(stack, Math.min(stack.stackSize, stackLimit)));
		return stackLimit >= stack.stackSize ? null : stack.splitStack(stack.stackSize - stackLimit);
	}

	/** 
	 * @author King Lemming 
	 */
	public static ItemStack addToOccupiedInventorySlot(IInventory theInventory, int slot, ItemStack stack) {
		ItemStack stackInSlot = theInventory.getStackInSlot(slot);
		int stackLimit = Math.min(theInventory.getInventoryStackLimit(), stackInSlot.getMaxStackSize());
		if(stack.stackSize + stackInSlot.stackSize > stackLimit){
			int stackDiff = stackLimit - stackInSlot.stackSize;
			stackInSlot.stackSize = stackLimit;
			stack.stackSize -= stackDiff;
			theInventory.setInventorySlotContents(slot, stackInSlot);
			return stack;
		}
		stackInSlot.stackSize += Math.min(stack.stackSize, stackLimit);
		theInventory.setInventorySlotContents(slot, stackInSlot);
		return stackLimit >= stack.stackSize ? null : stack.splitStack(stack.stackSize - stackLimit);
	}

	public static boolean isInventory(TileEntity theTile){
		return theTile instanceof IInventory;
	}
}