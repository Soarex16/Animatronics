package animatronics.client.gui;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.element.ElementEntropyStorage;
import animatronics.client.gui.element.ElementTextField;
import animatronics.common.tile.TileEntityHeatCollapser;

public class GuiEntropyFurnace extends GuiBase{
	
	public GuiEntropyFurnace(Container container, TileEntity tile) {
		super(container, tile);
	}
}
