package animatronics.api.recipes;

import net.minecraft.item.ItemStack;

public class EntropyCrusherRecipe {
	
	private final ItemStack input;
    private final ItemStack result;
    private final ItemStack secondResult;
    private final int energy;
    private final int time;
    private final float percent;
    
    public EntropyCrusherRecipe(ItemStack input, ItemStack result, ItemStack secondResult, int energy, int time, float percent) {
    	this.input = input;
    	this.result = result;
    	this.secondResult = secondResult;
    	this.energy = energy;
    	this.percent = percent;
    	this.time = time;
    }

    public ItemStack getInput() {
    	return input;
    }

    public ItemStack getResult() {
    	return result;
    }

    public ItemStack getSecondResult() {
    	return secondResult;
    }

    public int getEnergy() {
    	return energy > 0 ? energy : 0;
    }
    
    public float getTime() {
    	return time > 0 ? time : 0;
    }

    public float getPercent() {
    	return percent < 100 ? percent : 100;
    }

}
