package animatronics.api;

import animatronics.utils.misc.Vector3;
import net.minecraft.item.ItemStack;

public interface IItemBlockOutline {
	
	public Vector3 getBindingCoordinates(ItemStack stack);

}
