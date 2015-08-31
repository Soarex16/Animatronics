package animatronics.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public abstract class ARecipes {

	public final boolean checkInputOreDictoary(ItemStack input, ItemStack recepies) {
        int[] input_ids = OreDictionary.getOreIDs(input);
        int[] recepies_ids = OreDictionary.getOreIDs(recepies);
        for (int iid : input_ids) {
            for (int rid : recepies_ids) {
                if (iid == rid) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean compare(ItemStack input, ItemStack recipe) {
        boolean check_item = input.getItem() == recipe.getItem() && (input.getItemDamage() == recipe.getItemDamage() || recipe.getItemDamage() == 32767);
        boolean check_oredict = checkInputOreDictoary(input, recipe);
        boolean chesk_size =input.stackSize >= recipe.stackSize;
        return (check_item || check_oredict) && chesk_size;
    }
	
}
