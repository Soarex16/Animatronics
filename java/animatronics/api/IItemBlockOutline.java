package animatronics.api;

import animatronics.api.misc.Vector3;
import net.minecraft.item.ItemStack;

public interface IItemBlockOutline {
	/** 
	 * @param stack Stack the player holds.
	 * @return Outline draw coordinates.
	 */
	public Vector3 getBindingCoordinates(ItemStack stack);

}
