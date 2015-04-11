package animatronica.client.gui.element;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;

public class ElementTextField extends ElementGeneric {
	
	public String content;
	public int textColor;
	
	public ElementTextField(int xPosition, int yPosition, String text, int color) {
		super(xPosition, yPosition);
		content = text;
		textColor = color;
	}
	
	@Override
	public ResourceLocation getElementTexture() {
		return super.getElementTexture();
	}

	@Override
	public void draw(int posX, int posY) {
		super.draw(posX, posY);
	}

	@Override
	public int getX() {
		return super.getX();
	}

	@Override
	public int getY() {
		return super.getY();
	}

	@Override
	public void drawElement(int posX, int posY) {
		Minecraft.getMinecraft().fontRenderer.drawString(content, posX, posY, textColor, false);
	}

}
