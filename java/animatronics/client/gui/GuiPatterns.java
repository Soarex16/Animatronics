package animatronics.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import animatronics.Animatronics;

public class GuiPatterns{
	
	public static final int TEXT_COLOR = 4210752;
	
	public static void renderSlot(GuiContainer container, Slot slot, int x, int y) {
        ResourceLocation slotTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		container.drawTexturedModalRect(x + slot.xDisplayPosition - 1, y + slot.yDisplayPosition - 1, 0, 0, 18, 18);
	}
}
