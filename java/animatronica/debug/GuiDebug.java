package animatronica.debug;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.client.gui.GuiPatterns;

public class GuiDebug extends GuiContainer{

	public TileEntityDebug debug;
	
	public GuiDebug(InventoryPlayer inventoryPlayer, TileEntityDebug tileEntity){
		super(new ContainerDebug(inventoryPlayer, tileEntity));
		debug = tileEntity;
	}

	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		String name = debug.hasCustomInventoryName() ? debug.getInventoryName() : I18n.format(debug.getInventoryName(), ArrayUtils.EMPTY_OBJECT_ARRAY);
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 23, 4210752);
        fontRendererObj.drawString(I18n.format("container.inventory", ArrayUtils.EMPTY_OBJECT_ARRAY), 8, ySize - 96 + 2, 4210752);
   	}

	public void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/storage/Gui_base.png"));
		int srcX = (width - xSize) / 2;
		int srcY = (height - ySize+36) / 2;
		drawTexturedModalRect(srcX, srcY, 0, 0, xSize, ySize);
		for(int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i)
		{
			Slot slot = (Slot) this.inventorySlots.inventorySlots.get(i);
			GuiPatterns.renderSlot(slot);
			GL11.glColor3f(1, 1, 1);
		};
	}
}