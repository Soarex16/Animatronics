package animatronics.api.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SimpleItemStack {

	private Item item;
	private int meta;
	
	public SimpleItemStack(Item items, int metas) {
		item = items;
		meta = metas;
	}
	
	public SimpleItemStack(ItemStack stack){
		item = stack.getItem();
		meta = stack.getItemDamage();
	}
	
	public boolean mathces(ItemStack stack){
		return (stack != null && stack.getItem().equals(item) && stack.getItemDamage() == meta);
	}

	public Item getItem() {
		return item;
	}

	public int getMeta() {
		return meta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleItemStack other = (SimpleItemStack) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (meta != other.meta || meta != OreDictionary.WILDCARD_VALUE)
			return false;
		return true;
	}
	
	

}
