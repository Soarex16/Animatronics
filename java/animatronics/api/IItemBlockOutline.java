package animatronics.api;

import net.minecraft.item.ItemStack;

public interface IItemBlockOutline {
	/** 
	 * @param stack Stack the player holds.
	 * @return Outline draw coordinates.
	 */
	public Vector3 getBindingCoordinates(ItemStack stack);

}
