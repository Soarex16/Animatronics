package animatronics.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import animatronics.common.tile.TileEntityHeatCollapser;

public class ContainerHeatCollapser extends Container {
	
	public TileEntityHeatCollapser heatCollapsor;

	public ContainerHeatCollapser(InventoryPlayer inventory, TileEntityHeatCollapser tile) {
		heatCollapsor = tile;
		addSlotToContainer(new SlotFurnace(inventory.player, tile, 0, 80, 44));
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
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		// TODO Auto-generated method stub
		return super.transferStackInSlot(p_82846_1_, p_82846_2_);
	}
	
	@Override
	public ItemStack slotClick(int p_75144_1_, int p_75144_2_, int p_75144_3_,
			EntityPlayer p_75144_4_) {
		// TODO Fix shiftclick issues.
		return null;
	}
}
