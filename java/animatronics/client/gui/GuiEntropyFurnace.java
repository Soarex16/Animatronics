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
		elementList.add(new ElementEntropyStorage(7, 6, (ITEHasEntropy)tile));
	//	elementList.add(new ElementTextField(78, 34, StatCollector.translateToLocal("tooltip.fuel") + ":", 4210752, false));
	//	elementList.add(new ElementTextField(28, 6, StatCollector.translateToLocal("tile.blockHeatCollapser.name"), 4210752, false));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		int xx = x - (width-xSize)/2, yy = y - (height - ySize)/2;
	//	drawHoveringText(Arrays.asList(new String[]{StatCollector.translateToLocal("tooltip.burn") + ": " +((TileEntityHeatCollapser)genericTile).currentBurnTime + "/" + ((TileEntityHeatCollapser)genericTile).maxBurnTime}), -8, 0, Minecraft.getMinecraft().fontRenderer);
		if(xx >= 6 && xx <= 24 && yy >= 6 && yy <= 78){
			drawHoveringText(Arrays.asList(new String[]{StatCollector.translateToLocal("tooltip.entropy") + ": " + genericTile.getEntropy() + "/" + genericTile.getMaxEntropy(), (genericTile.getEntropy()*100/genericTile.getMaxEntropy()) + "%"}), xx, yy, Minecraft.getMinecraft().fontRenderer);
		}
		super.drawGuiContainerForegroundLayer(x, y);
	}

}
