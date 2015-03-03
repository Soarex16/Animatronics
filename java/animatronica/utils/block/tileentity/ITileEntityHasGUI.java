package animatronica.utils.block.tileentity;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public interface ITileEntityHasGUI{

	public Container getContainer(EntityPlayer player);
	
	public GuiContainer getGui(EntityPlayer player);
}
