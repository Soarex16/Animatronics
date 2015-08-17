package animatronics.client.gui.element;

import net.minecraft.client.Minecraft;
import animatronics.api.energy.ITEHasEntropy;
import animatronics.client.gui.GuiPatterns;

public class ElementEntropyProcessor extends ElementGeneric {

	private ITEHasEntropy tile;
	
	public ElementEntropyProcessor(int xPosition, int yPosition, ITEHasEntropy tile) {
		super(xPosition, yPosition);
		this.tile = tile;
	}

	@Override
	public void drawElement(int posX, int posY) {
		Minecraft.getMinecraft().fontRenderer.drawString("Entropy: " + tile.getEntropy() + "/" + tile.getMaxEntropy(), posX, posY, GuiPatterns.TEXT_COLOR);
		Minecraft.getMinecraft().fontRenderer.drawString(tile.getEntropy()*100/tile.getMaxEntropy() + "%", posX, posY + 10, GuiPatterns.TEXT_COLOR);
	}

}
