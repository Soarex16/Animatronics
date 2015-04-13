package animatronica.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import animatronica.Animatronica;

public class GuiPatterns extends GuiContainer {
	
	public GuiPatterns(Container container) {
		super(container);
	}

	public void renderSlot(Slot slot) {
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        ResourceLocation slotTex = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		this.drawTexturedModalRect(x+slot.xDisplayPosition-1, y+slot.yDisplayPosition-1, 0, 0, 18, 18);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY) {		
	}

}
