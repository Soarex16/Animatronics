package animatronica.client.gui;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import animatronica.Animatronica;
 
public class GuiPatterns {
	
	public static ResourceLocation guiBackgroundSmall = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base.png");
	public static ResourceLocation guiBackgroundBig = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base_big.png");
	
	public static void renderSlot(GuiContainer cont, Slot slot, int x, int y) {
        ResourceLocation slotTex = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		cont.drawTexturedModalRect(x+slot.xDisplayPosition-1, y+slot.yDisplayPosition-1, 0, 0, 18, 18);
	}
 
}