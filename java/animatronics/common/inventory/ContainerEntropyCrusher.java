package animatronics.common.inventory;

import animatronics.common.inventory.elements.SlotLocked;
import animatronics.common.tile.TileEntityEntropyCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerEntropyCrusher extends Container {
	
	public TileEntityEntropyCrusher entropyCrusher;
	
	public ContainerEntropyCrusher(InventoryPlayer inventory, TileEntityEntropyCrusher tile) {
		entropyCrusher = tile;
		addSlotToContainer(new Slot(tile, 0, 44, 44));
		addSlotToContainer(new SlotLocked(tile, 1, 114, 44));
		addSlotToContainer(new SlotLocked(tile, 2, 136, 44));
		bindPlayerInventory(inventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entropyCrusher.isUseableByPlayer(player);
	}
	
	public void bindPlayerInventory(InventoryPlayer inventoryPlayer){
		for(int i = 0; i < 3; i++){
			for(int k = 0; k < 9; k++){
				addSlotToContainer(new Slot(inventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		for(int j = 0; j < 9; j++){
			addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18, 142));
		}
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
