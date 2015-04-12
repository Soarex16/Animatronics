package animatronica.client.gui.element;

import animatronica.Animatronica;
import net.minecraft.util.ResourceLocation;

public abstract class ElementGeneric  extends GuiElement{
	
	private ResourceLocation resource = new ResourceLocation(Animatronica.MOD_ID,"textures/gui/Slot_base.png");
	
	public int x;
	public int y;
	
	public ElementGeneric(int xPosition, int yPosition)
	{
		x = xPosition;
		y = yPosition;
	}

	@Override
	public ResourceLocation getElementTexture() {
		return resource;
	}

	@Override
	public void draw(int posX, int posY) {
		drawElement(posX,posY);
	}
	
	public abstract void drawElement(int posX, int posY);

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

}