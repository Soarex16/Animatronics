package animatronics.common.inventory;

import animatronics.common.tile.TileEntityHeatCollapser;
import animatronics.common.tile.TileEntitySunCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerSunCollector extends Container {
	
	public TileEntitySunCollector sunCollector;
	
	public ContainerSunCollector(InventoryPlayer inventory, TileEntitySunCollector tile) {
		sunCollector = tile;
		bindPlayerInventory(inventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return sunCollector.isUseableByPlayer(player);
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