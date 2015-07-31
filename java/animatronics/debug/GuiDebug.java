package animatronics.debug;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.gui.GuiPatterns;

public class GuiDebug extends GuiContainer{

	public TileEntityDebug debug;
	
	public GuiDebug(InventoryPlayer inventoryPlayer, TileEntityDebug tileEntity){
		super(new ContainerDebug(inventoryPlayer, tileEntity));
		debug = tileEntity;
	}

	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		
   	}

	public void drawGuiContainerBackgroundLayer(float magicFloat, int mouseX, int mouseY){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Gui_base.png"));
		int srcX = (width - xSize) / 2;
		int srcY = (height - ySize) / 2;
		drawTexturedModalRect(srcX, srcY, 0, 0, xSize, ySize);
		for(int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i)
		{
			Slot slot = (Slot) this.inventorySlots.inventorySlots.get(i);
			GuiPatterns.renderSlot(this, slot, srcX, srcY);
			GL11.glColor3f(1, 1, 1);
		}
	}
}