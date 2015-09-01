package animatronics.client.gui;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.element.ElementEntropyStorage;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiEntropyCrusher extends GuiBase {

	public GuiEntropyCrusher(Container container, TileEntity tile) {
		super(container, tile);
		elementList.add(new ElementEntropyStorage(7, 6, (ITEHasEntropy)tile));
	}
}
