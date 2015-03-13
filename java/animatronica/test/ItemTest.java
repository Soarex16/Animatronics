package animatronica.test;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import animatronica.utils.item.ItemContainerBase;

public class ItemTest extends ItemContainerBase {

	public ItemTest(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		this.setCreativeTab(animatronica.Animatronica.creativeTabAnimatronica);
		this.setTextureName(unlocalizedName);
	}
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GREEN+"Only for developers");
		list.add(EnumChatFormatting.RED+"Can cause crashes");
	}

}
