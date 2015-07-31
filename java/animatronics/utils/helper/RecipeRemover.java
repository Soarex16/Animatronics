package animatronics.utils.helper;

import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;

import com.google.common.collect.Lists;

import animatronics.Animatronics;
import animatronics.utils.inventory.container.ContainerBase;
import animatronics.utils.misc.ItemUtils;

public class RecipeRemover{

	public static void removeRecipe(ItemStack toRemove){
		Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();
		while(iterator.hasNext()){
			IRecipe recipe = iterator.next();
			if(recipe == null){
				continue;
			}
			ItemStack output = recipe.getRecipeOutput();
			if(output != null && ItemStack.areItemStacksEqual(output, toRemove)){
				iterator.remove();
			}
		}
	}

	public static void removeRecipe(Object... components){
		Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();
		while(iterator.hasNext()){
			IRecipe recipe = iterator.next();
			InventoryCrafting dummyInventory = new InventoryCrafting(new ContainerBase(), 3, 3); 
			for(int i = 0; i < components.length; i++){
				dummyInventory.setInventorySlotContents(i, ItemUtils.getItemStack(components[i]));
			}
			if(recipe.matches(dummyInventory, null)){
				iterator.remove();
				Animatronics.logger.info("Remove recipe for " + recipe.getRecipeOutput().getDisplayName() + ".");
			}
		}
	}
}
