package animatronics.client.gui.element;

import java.util.Arrays;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.utils.misc.MiscUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElementEntropyStorage extends GuiElement {
	
	public ResourceLocation entropy = new ResourceLocation("animatronics", "textures/gui/elements/Capacitor.png");
	public ResourceLocation	bar = new ResourceLocation("animatronics", "textures/gui/elements/entropy.png");
	public int x;
	public int y;
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
		/* It is necessary to it as something to put here
		int xx = x - (width-xSize)/2, yy = y - (height - ySize)/2;
		if(xx >= 6 && xx <= 24 && yy >= 6 && yy <= 78){
			drawHoveringText(Arrays.asList(new String[]{"Entropy: " + tile.getEntropy() + "/" + tile.getMaxEntropy(), (tile.getEntropy()*100/tile.getMaxEntropy()) + "%"}), xx, yy, Minecraft.getMinecraft().fontRenderer);
		}*/
		
		this.drawTexturedModalRect(posX, posY, 0, 0, 18, 72);
		int percentageScaled = MiscUtils.pixelatedTextureSize(tile.getEntropy(), tile.getMaxEntropy(), 32);
		Minecraft.getMinecraft().getTextureManager().bindTexture(bar);	
		drawTexturedModalRect(posX+1, posY-1+(74-percentageScaled), 0, 0, 16, percentageScaled-2);
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
