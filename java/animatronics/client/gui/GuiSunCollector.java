package animatronics.client.gui;

import java.util.Arrays;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.element.ElementEntropyStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class GuiSunCollector extends GuiBase {

	public GuiSunCollector(Container container, TileEntity tile) {
		super(container, tile);
		elementList.add(new ElementEntropyStorage(7, 6, (ITEHasEntropy)tile));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		int xx = x - (width-xSize)/2, yy = y - (height - ySize)/2;
		if(xx >= 6 && xx <= 24 && yy >= 6 && yy <= 78){
			drawHoveringText(Arrays.asList(new String[]{"Entropy: " + genericTile.getEntropy() + "/" + genericTile.getMaxEntropy(), (genericTile.getEntropy()*100/genericTile.getMaxEntropy()) + "%"}), xx, yy, Minecraft.getMinecraft().fontRenderer);
		}
		super.drawGuiContainerForegroundLayer(x, y);
	}
}
