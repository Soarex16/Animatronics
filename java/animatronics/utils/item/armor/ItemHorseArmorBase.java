package animatronics.utils.item.armor;

import animatronics.utils.item.ItemBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;

public class ItemHorseArmorBase extends ItemBase{

	private int value;
	private String texture;

	public ItemHorseArmorBase(String unlocalizedName, String modId, int armorValue, String armorTexture){
		super(unlocalizedName, modId);
		value = armorValue;
		texture = armorTexture;
	}

	public int getArmorValue(EntityHorse horse, ItemStack stack){
		return value;
	}

	public String getArmorTexture(EntityHorse horse, ItemStack stack){
		return texture;
	}
}
