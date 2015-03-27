package animatronica.client.gui;


import animatronica.Animatronica;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAnimatronica extends CreativeTabs {

	public CreativeTabAnimatronica(String lable) {
		super(lable);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Animatronica.blockDebug);
	}
	
    public String getTranslatedTabLabel()
    {
        return getTabLabel();
    } 
}
