package animatronica.test;

import animatronica.utils.item.ItemContainerBase;

public class ItemTest extends ItemContainerBase {

	public ItemTest(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		this.setCreativeTab(animatronica.Animatronica.creativeTabAnimatronica);
		this.setTextureName(unlocalizedName);
	}

}
