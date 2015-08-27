package animatronics.client.gui;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import animatronics.Animatronics;
import animatronics.common.block.AnimatronicsBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAnimatronics extends CreativeTabs {
	
	public CreativeTabAnimatronics() {
		super(Animatronics.MOD_ID);
		setBackgroundImageName("cc_gui.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(AnimatronicsBlocks.blockDebug);
	}
	
    public String getTranslatedTabLabel()
    {
        return getTabLabel();
    } 
}
