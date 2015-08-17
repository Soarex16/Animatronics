package animatronics.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import animatronics.common.tile.TileEntityMoonPrism;

public class ContainerMoonPrism extends Container {
	
	public TileEntityMoonPrism moonPrism;

	public ContainerMoonPrism(InventoryPlayer inventory, TileEntityMoonPrism tile) {
		moonPrism = tile;
		bindPlayerInventory(inventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return moonPrism.isUseableByPlayer(player);
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
