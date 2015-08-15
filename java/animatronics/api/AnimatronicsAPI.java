package animatronics.api;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import animatronics.api.crafting.SimpleEntropyRecipe;

public class AnimatronicsAPI {

	private static HashMap<String, SimpleEntropyRecipe> recipesFurnace = new HashMap<String, SimpleEntropyRecipe>();
	
	
	public static HashMap<String, SimpleEntropyRecipe> getFurnaceRecipeList(){
		return recipesFurnace;
	}
	
	public static void addRecipeToEntropyFurnace(Item in, int entropy, int time, ItemStack out){
		recipesFurnace.put(in.getUnlocalizedName(), new SimpleEntropyRecipe(entropy, time, out));
		System.out.println("put");
		System.out.println(recipesFurnace.keySet().toString());
	}
}
