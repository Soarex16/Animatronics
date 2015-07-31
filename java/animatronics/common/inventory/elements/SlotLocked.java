package animatronics.common.inventory.elements;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLocked extends Slot{

	public SlotLocked(IInventory inv, int id, int x, int y){
		super(inv, id, x, y);
	}

	public boolean isItemValid(ItemStack iStack){
        return false;
    }
}
