package animatronics.api.crafting;

import net.minecraft.item.ItemStack;

public class SimpleEntropyRecipe {
	/**
	 * Entropy required to finish crafting at some tile.
	 */
	private final int entropyRequired;
	
	/**
	 * Time required to finish crafting at some tile. Must be in ticks (1 tick - 1/20 of one second)
	 */
	private final int timeRequired;
	
	/**
	 * Output stack.
	 */
	private final ItemStack result; 
	
	public SimpleEntropyRecipe(int entropy, int time, ItemStack output) {
		entropyRequired = entropy;
		timeRequired = time;
		result = output;
	}

	public int getEntropyRequired() {
		return entropyRequired;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public ItemStack getResult() {
		return result;
	}
 
}
