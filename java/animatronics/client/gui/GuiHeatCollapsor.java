package animatronics.client.gui;

import animatronics.Animatronics;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiHeatCollapsor extends GuiBase {

	public GuiHeatCollapsor(Container container, TileEntity tile) {
		super(container, tile);
	}
	
	public void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY) {
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
		mc.renderEngine.bindTexture(new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base.png"));
		this.drawTexturedModalRect(k, l, 0, 24, this.xSize, this.ySize);
	}
}
