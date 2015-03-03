package animatronica.utils.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.commons.lang3.StringUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import animatronica.utils.item.ItemBase;

public class ItemFoodBase extends ItemFood{

	private final String modId;
	
	public ItemFoodBase(String unlocalizedName, String mod, int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat){
		super(healAmount, saturationModifier, isWolfsFavoriteMeat);
		setUnlocalizedName(unlocalizedName);
		modId = mod;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}
	
	public String getModId(){
		return modId.toLowerCase();
	}
	
	public ItemFoodBase setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
}