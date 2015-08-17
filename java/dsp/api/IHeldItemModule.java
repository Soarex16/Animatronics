package dsp.api;

import java.util.List;

import net.minecraft.item.ItemStack;

public interface IHeldItemModule extends IModule{
	public void addItemInfo(ItemStack itemstack, List<String> left, List<String> right, String pagename);
}
