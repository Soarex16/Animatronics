package animatronics.client.gui.element;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.utils.event.EventHookContainer;
import animatronics.utils.misc.MiscUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class ElementEntropyStorage extends GuiElement {
	
	public ResourceLocation entropy = new ResourceLocation("animatronics", "textures/gui/elements/Capacitor.png");
	public ResourceLocation		bar = new ResourceLocation("animatronics", "textures/gui/elements/entropy.png");
	public int x;
	public int y;
	public ITEHasEntropy tile;
	public static IIcon icon;	
	
	public ElementEntropyStorage(int i, int j, ITEHasEntropy t) {
		x = i;
		y = j;
		tile = t;
		icon = EventHookContainer.entropy;
	}
	
	@Override
	public ResourceLocation getElementTexture() {
		return entropy;
	}

	@Override
	public void draw(int posX, int posY) {
		this.drawTexturedModalRect(posX, posY, 0, 0, 18, 72);
		int percentageScaled = MiscUtils.pixelatedTextureSize(tile.getEntropy(), tile.getMaxEntropy(), 72);
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
