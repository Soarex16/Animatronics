package animatronica.client.gui;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import animatronica.Animatronica;
import animatronica.common.block.AnimatronicaBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAnimatronica extends CreativeTabs {
	
	public CreativeTabAnimatronica() {
		super(Animatronica.MOD_ID);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(AnimatronicaBlocks.blockDebug);
	}
	
    public String getTranslatedTabLabel()
    {
        return getTabLabel();
    } 
}
