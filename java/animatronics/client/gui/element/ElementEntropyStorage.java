package animatronics.client.gui.element;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.GuiBase;
import animatronics.client.gui.GuiPatterns;
import animatronics.utils.event.EventHookContainer;
import animatronics.utils.misc.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElementEntropyStorage extends GuiElement {
	
	public ResourceLocation entropy = new ResourceLocation("animatronics", "textures/gui/elements/Capacitor.png");
	public int x, y;
	public ITEHasEntropy tile;
	
	public ElementEntropyStorage(int i, int j, ITEHasEntropy t) {
		x = i;
		y = j;
		tile = t;
	}
	
	@Override
	public ResourceLocation getElementTexture() {
		return entropy;
	}

	@Override
	public void draw(int posX, int posY) {
		this.drawTexturedModalRect(posX, posY, 0, 0, 18, 72);
		int percentageScaled = MiscUtils.pixelatedTextureSize(tile.getEntropy(), tile.getMaxEntropy(), 72);
		MiscUtils.drawTexture(posX+1, posY-1+(74-percentageScaled), EventHookContainer.entropy, 16, percentageScaled-2, 0);
		int xx = GuiBase.mX - (GuiBase.gW-GuiBase.gXS)/2, yy = GuiBase.mY - (GuiBase.gH - GuiBase.gYS)/2;
		if(xx >= x && xx <= x+18 && yy >= y && yy <= y+72){
			GuiPatterns.drawToolTip(Arrays.asList(new String[]{"Entropy: " + tile.getEntropy() + "/" + tile.getMaxEntropy(), (tile.getEntropy()*100/tile.getMaxEntropy()) + "%"}), xx, yy);
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
