package animatronics.common.inventory;

import animatronics.common.tile.TileEntityHeatCollapsor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerHeatCollapsor extends Container {
	
	public TileEntityHeatCollapsor heatCollapsor;

	public ContainerHeatCollapsor(InventoryPlayer inventory, TileEntityHeatCollapsor tileEntityHeatCollapsor) {
		heatCollapsor = tileEntityHeatCollapsor;
		addSlotToContainer(new Slot(heatCollapsor, 0, 80, 44));
		bindPlayerInventory(inventory);
	}
	
	public boolean canInteractWith(EntityPlayer player) {
		return heatCollapsor.isUseableByPlayer(player);
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
}
