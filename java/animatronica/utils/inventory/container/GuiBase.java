package animatronica.utils.inventory.container;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.client.gui.element.GuiElement;
import animatronica.utils.block.tileentity.TileEntityInventoryBase;

public class GuiBase extends GuiContainer{
	
	
	//TODO : Use me in GUI *O*
	public List<GuiElement> elementList = new ArrayList();
	public TileEntityInventoryBase genericTile;

	public GuiBase(Container container) {
		super(container);
	}
	
	public GuiBase(Container container, TileEntity tile) {
		this(container);
		genericTile = (TileEntityInventoryBase) tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        ResourceLocation guiTex = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(guiTex);
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		for(int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i)
		{
			Slot slot = (Slot) this.inventorySlots.inventorySlots.get(i);
			renderSlot(slot);
			GL11.glColor3f(1, 1, 1);
		}
		for(int i = 0; i < this.elementList.size(); ++i)
		{
			GuiElement element = elementList.get(i);
			Minecraft.getMinecraft().renderEngine.bindTexture(element.getElementTexture());
			element.draw(x+element.getX(),y+element.getY());
			GL11.glColor3f(1, 1, 1);
		}
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		String name = genericTile.hasCustomInventoryName() ? genericTile.getInventoryName() : I18n.format(genericTile.getInventoryName(), ArrayUtils.EMPTY_OBJECT_ARRAY);
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, ySize/30, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory", ArrayUtils.EMPTY_OBJECT_ARRAY), 8, ySize - 96 + 2, 4210752);
	}
	
	public void renderSlot(Slot slt)
	{
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        ResourceLocation slotTex = new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		this.drawTexturedModalRect(x+slt.xDisplayPosition-1, y+slt.yDisplayPosition-1, 0, 0, 18, 18);
	}
	
	public static void bindTexture(String mod, String texture)
	{
		ResourceLocation loc = new ResourceLocation(mod,texture);
		Minecraft.getMinecraft().getTextureManager().bindTexture(loc);	 
		loc = null;
	}

}
