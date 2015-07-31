package animatronics.debug;

import animatronics.common.inventory.elements.SlotLocked;
import animatronics.utils.inventory.container.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDebug extends ContainerBase{

	public TileEntityDebug debug;

	public ContainerDebug(InventoryPlayer inventoryPlayer, TileEntityDebug tile){
		debug = tile;
		addSlotToContainer(new SlotLocked(tile, 0, 80, 44));
		bindPlayerInventory(inventoryPlayer);
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		return debug.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slot){
		ItemStack iStack = null;
		Slot slotObject = (Slot)inventorySlots.get(slot);
		if(slotObject != null && slotObject.getHasStack()){
			ItemStack stackInSlot = slotObject.getStack();
			iStack = stackInSlot.copy();
			if(slot == 0){
				if(!mergeItemStack(stackInSlot, 1, 37, true)){
					return null;
				}
			}else if(slot >= 28 && slot <= 37 && !mergeItemStack(stackInSlot, 1, 28, false)){
				return null;
			}else if(slot >= 0 && slot <= 27 && !mergeItemStack(stackInSlot, 28, 37, false)){
				return null;
			}
			if(stackInSlot.stackSize == 0){
				slotObject.putStack(null);
			}else{
				slotObject.onSlotChanged();
			}
			if(stackInSlot.stackSize == iStack.stackSize){
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return iStack;
	}
}