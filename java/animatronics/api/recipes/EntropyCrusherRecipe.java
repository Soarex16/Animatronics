package animatronics.api.recipes;

import net.minecraft.item.ItemStack;

public class EntropyCrusherRecipe {
	
	private final ItemStack input;
    private final ItemStack result;
    private final ItemStack secondResult;
    private final int energy;
    private final float expirince;
    private final float percent;
    private final float time;
    
    public EntropyCrusherRecipe(ItemStack input, ItemStack result, ItemStack secondResult, int energy, float percent, float time, float expirince) {
    	this.input = input;
    	this.result = result;
    	this.secondResult = secondResult;
    	this.energy = energy;
    	this.percent = percent;
    	this.time = time;
    	this.expirince = expirince;
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

    public float getExpirince() {
    	return expirince > 0 ? expirince : 0;
    }
    
    public float getTime() {
    	return time > 0 ? time : 0;
    }

    public float getPercent() {
    	return percent < 100 ? percent : 100;
    }

}
