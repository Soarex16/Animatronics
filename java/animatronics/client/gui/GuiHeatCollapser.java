package animatronics.client.gui;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.element.ElementEntropyStorage;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiHeatCollapser extends GuiBase {

	public GuiHeatCollapser(Container container, TileEntity tile) {
		super(container, tile);
		this.elementList.add(new ElementEntropyStorage(6, 6, (ITEHasEntropy)tile));
	}
}
