package animatronics.utils.misc;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import animatronics.Animatronics;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class RecipeUtils{

	/** 
	 * @author Lomeli12 
	 */
	public static Object[] getItemShapedRecipe(ItemStack iStack){
		Object[] finalRecipe = new Object[9];
		if(iStack != null){
			List<IRecipe> possibleRecipe = new ArrayList<IRecipe>();
			for(Object recipe : CraftingManager.getInstance().getRecipeList()){
				if(recipe instanceof IRecipe){
					ItemStack output = ((IRecipe) recipe).getRecipeOutput();
					if(output != null && iStack.getUnlocalizedName().equals(output.getUnlocalizedName()) && iStack.getItemDamage() == output.getItemDamage()){
						possibleRecipe.add((IRecipe) recipe);
					}
				}
			}
			if(!possibleRecipe.isEmpty()){
				IRecipe main = possibleRecipe.get(0);
				try{
					Field[] fields = main.getClass().getDeclaredFields();
					if(main instanceof ShapedRecipes){
						Field inputs = fields[2];
						if(inputs.getType().isArray()){
							for(int i = 0; i < Array.getLength(inputs.get(main)); i++){
								if((Array.get(inputs.get(main), i) instanceof ItemStack) && i < finalRecipe.length){
									finalRecipe[i] = Array.get(inputs.get(main), i);
								}
							}
						}
					}else if(main instanceof ShapelessRecipes){
						Field inputs = fields[1];
						if(List.class.isAssignableFrom(inputs.getType())){
							inputs.setAccessible(true);
							List<ItemStack> items = getField(ShapelessRecipes.class, List.class, main, 1);
							if(items != null){
								for(int i = 0; i < items.size(); i++){
									if(i < finalRecipe.length){
										finalRecipe[i] = items.get(i);
									}
								}
							}
						}
					}else if(main instanceof ShapedOreRecipe || main instanceof ShapelessOreRecipe){
						Object[] inputs = null;
						if(main instanceof ShapedOreRecipe){
							inputs = ((ShapedOreRecipe) main).getInput();
						}else{
							inputs = ((ShapelessOreRecipe) main).getInput().toArray();
						}
						for(int i = 0; i < inputs.length; i++){
							Object obj = inputs[i];
							if(obj instanceof ArrayList<?>){
								finalRecipe[i] = ((ArrayList<?>) obj).get(0);
							}else{
								finalRecipe[i] = obj;
							}
						}
					}else if(Loader.isModLoaded("IC2")){
						if(Class.forName("ic2.core.AdvRecipe").isAssignableFrom(main.getClass()) || Class.forName("ic2.core.AdvShapelessRecipe").isAssignableFrom(main.getClass())){
							Field inputs = fields[2];
							if(inputs.getType().isArray()){
								for(int i = 0; i < Array.getLength(inputs.get(main)); i++){
									if(i < finalRecipe.length){
										finalRecipe[i] = Array.get(inputs.get(main), i);
									}
								}
							}
						}
					}
				}catch(Exception e){
					Animatronics.logger.error("An error occurred when part of the recipe " + iStack.getDisplayName() + ".", e);
				}
			}
		}
		return finalRecipe;
	}
	
	public static <T> T getField(Class<?> class1, Class<T> fieldType, Object instance, int fieldPosition){
		try{
			Field[] fields = class1.getDeclaredFields();
			Field field = fields[fieldPosition];
			field.setAccessible(true);
			return (T)field.get(instance);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
