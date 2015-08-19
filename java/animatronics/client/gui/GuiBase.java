package animatronics.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import animatronics.Animatronics;
import animatronics.api.TileEntityPrimary;
import animatronics.client.gui.element.ElementEntropyStorage;
import animatronics.client.gui.element.GuiElement;


public class GuiBase extends GuiContainer{

	public List<GuiElement> elementList = new ArrayList();
	public TileEntityPrimary genericTile;
	
	public static int mX, mY, gW, gH, gXS, gYS;

	public GuiBase(Container container) {
		super(container);
	}
	
	public GuiBase(Container container, TileEntity tile) {
		this(container);
		genericTile = (TileEntityPrimary) tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mX = mouseX;
		mY = mouseY;
		gW = width;
		gH = height;
		gXS = xSize;
		gYS = ySize;
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        ResourceLocation guiTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(guiTex);
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		for(Object slot : inventorySlots.inventorySlots){
			renderSlot((Slot)slot);
			GL11.glColor3f(1, 1, 1);
		}
		for(GuiElement element : elementList){
			Minecraft.getMinecraft().renderEngine.bindTexture(element.getElementTexture());
			element.draw(x+element.getX(),y+element.getY());
			GL11.glColor3f(1, 1, 1);
		}
		if(genericTile.hasCustomInventoryName()) {
			String name = I18n.format(genericTile.getInventoryName(), ArrayUtils.EMPTY_OBJECT_ARRAY);
			fontRendererObj.drawString(name, x + fontRendererObj.getStringWidth(name)/2, y+6, 4210752);
			fontRendererObj.drawString(I18n.format("container.inventory", ArrayUtils.EMPTY_OBJECT_ARRAY), x+8, y+72, 4210752);
		}
	}
	
	public void renderSlot(Slot slt)
	{
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        ResourceLocation slotTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		this.drawTexturedModalRect(x+slt.xDisplayPosition-1, y+slt.yDisplayPosition-1, 0, 0, 18, 18);
	}
	
	public static void bindTexture(String mod, String texture)
	{
		ResourceLocation location = new ResourceLocation(mod,texture);
		Minecraft.getMinecraft().getTextureManager().bindTexture(location);	 
		location = null;
	}
}	
