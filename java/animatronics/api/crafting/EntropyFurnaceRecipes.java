package animatronics.api.crafting;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntropyFurnaceRecipes {

	private static SimpleItemStack[] stacks;
	private static SimpleEntropyRecipe[] recipes;
	
	private static int find(ItemStack stack){
		int i = 0;
		while(!stacks[i].mathces(stack)){
			if(i == stacks.length - 1) return -1;
			i++;
		}
		return i;
	}
	
	public static SimpleEntropyRecipe get(ItemStack stack){
		if(find(stack) == -1) return null;
		return recipes[find(stack)];
	}
	
	public static void registerRecipe(ItemStack in, int entropy, int time, ItemStack out){
		stacks[stacks.length] = new SimpleItemStack(in);
		recipes[recipes.length] = new SimpleEntropyRecipe(entropy, time, out);
	}
}
