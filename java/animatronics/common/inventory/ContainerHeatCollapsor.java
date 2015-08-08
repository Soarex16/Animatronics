package animatronics.common.inventory;

import animatronics.common.tile.TileEntityHeatCollapsor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerHeatCollapsor extends Container {

	public ContainerHeatCollapsor(InventoryPlayer inventory, TileEntityHeatCollapsor tileEntityHeatCollapsor) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return false;
	}

}
