package animatronica.debug;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;
import animatronica.client.gui.element.ElementTextField;
import animatronica.utils.inventory.container.GuiBase;

public class GuiDebug extends GuiBase{

	public GuiDebug(Container container, TileEntity tile) {
		super(container, tile);
		this.elementList.add(new ElementTextField(35, 15, "GREAT COOKIIE FORGE", 0x00CCFF));
	} 
	
	
	/*extends GuiContainer{

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
		mc.renderEngine.bindTexture(new ResourceLocation(Animatronica.MOD_ID.toLowerCase(), "textures/gui/storage/Storage1.png"));
		int srcX = (width - xSize) / 2;
		int srcY = (height - ySize+36) / 2;
		drawTexturedModalRect(srcX, srcY, 0, 0, xSize, ySize);
	}*/
}