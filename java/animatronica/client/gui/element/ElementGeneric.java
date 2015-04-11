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
		this.drawTexturedModalRect(posX, posY, 0, 0, 17, 18);
		this.drawTexturedModalRect(posX+17, posY, 1, 0, 16, 18);
		this.drawTexturedModalRect(posX+17+16, posY, 1, 0, 16, 18);
		this.drawTexturedModalRect(posX+17+32, posY, 1, 0, 16, 18);
		this.drawTexturedModalRect(posX+17+48, posY, 1, 0, 17, 18);
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