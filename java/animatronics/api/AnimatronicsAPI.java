package animatronics.api;

import java.util.HashMap;

import animatronics.api.crafting.SimpleEntropyRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AnimatronicsAPI {
	
	//Several maps for advanced mechanisms (based on subtile) I don't know how to do(
	
	
	//Recipes
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
