package animatronics.client.gui;

import animatronics.Animatronics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiPatterns extends GuiContainer {
	
	public static final int TEXT_COLOR = 4210752;
	
	public GuiPatterns(Container container) {
		super(container);
	}

	public static void renderSlot(GuiContainer container, Slot slot, int x, int y) {
        ResourceLocation slotTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		container.drawTexturedModalRect(x + slot.xDisplayPosition - 1, y + slot.yDisplayPosition - 1, 0, 0, 18, 18);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY) {		
	}

}
