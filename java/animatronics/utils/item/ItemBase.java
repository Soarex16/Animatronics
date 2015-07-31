package animatronics.utils.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemBase extends Item{
	
	private final String modId;
	
	public ItemBase(String unlocalizedName, String mod){
		super();
		setUnlocalizedName(unlocalizedName);
		modId = mod;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}
	
	public String getModId(){
		return modId.toLowerCase();
	}
	
	public ItemBase setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
}
