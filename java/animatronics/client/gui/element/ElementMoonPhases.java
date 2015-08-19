package animatronics.client.gui.element;

import animatronics.utils.misc.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

public class ElementMoonPhases extends GuiElement {
	
	public ResourceLocation moonTex = new ResourceLocation("animatronics", "textures/gui/elements/Moon_phases.png");
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
		switch(moonPhase) { 
			case 0:
				drawTexturedModalRect(posX, posY, 0, 0, 32, 32); 
				break;
			case 1:
				drawTexturedModalRect(posX, posY, 32, 0, 32, 32);
				break;
			case 2:
				drawTexturedModalRect(posX, posY, 64, 0, 32, 32);
				break;
			case 3:
				drawTexturedModalRect(posX, posY, 96, 0, 32, 32);
				break;
			case 4:
				drawTexturedModalRect(posX, posY, 0, 32, 32, 32);
				break;
			case 5:
				drawTexturedModalRect(posX, posY, 32, 32, 32, 32); 
				break;
			case 6:
				drawTexturedModalRect(posX, posY, 64, 32, 32, 32);
				break;
			case 7:
				drawTexturedModalRect(posX, posY, 96, 32, 32, 32);
				break;
		}
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
