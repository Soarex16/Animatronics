package animatronica.utils.helper;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface InformationProvider {
	
	public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held);

}
