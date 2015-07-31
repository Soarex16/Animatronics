package animatronics.client.gui.element;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;

public class ElementTextField extends ElementGeneric {
	
	public String content;
	public int textColor;
	public boolean isShade;
		
	public ElementTextField(int xPosition, int yPosition, String text, int color, boolean shade) {
		super(xPosition, yPosition);
		content = text;
		textColor = color;
		isShade = shade;
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
		Minecraft.getMinecraft().fontRenderer.drawString(content, posX, posY, textColor, isShade);
	}

}
