package animatronics.client.gui.element;

import animatronics.utils.misc.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

public class ElementMoonPhases extends GuiElement {
	
	public ResourceLocation moonTex = new ResourceLocation("animatronics", "textures/gui/elements/MoonPhases.png");
	public int x;
	public int y;
	
	public ElementMoonPhases(int i, int j) {
		x = i;
		y = j;
	}

	@Override
	public ResourceLocation getElementTexture() {
		return moonTex;
	}

	@Override
	public void draw(int posX, int posY) {
		this.drawTexturedModalRect(posX, posY, 0, 0, 18, 18);
		Minecraft.getMinecraft().getTextureManager().bindTexture(moonTex);
		int moonPhase = Minecraft.getMinecraft().theWorld.getMoonPhase();
		this.drawTexturedModalRect(posX+1, posY+1, 16*moonPhase, 0, 16, 16);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
