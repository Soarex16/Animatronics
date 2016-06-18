package com.soarex.animatronics.client.gui;

import com.soarex.animatronics.Animatronics;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by soarex on 17.06.16.
 */
public class CreativeTabAnimatronics extends CreativeTabs {

    public CreativeTabAnimatronics() {
        super(Animatronics.MODID);
        setBackgroundImageName("cc_gui.png");
    }

    @Override
    public Item getTabIconItem() {
        return null;//Item.getItemFromBlock();
    }
}
