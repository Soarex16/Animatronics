package animatronics.utils.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import cpw.mods.fml.common.network.IGuiHandler;

public class AGuiHandler implements IGuiHandler{

	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if(tileEntity instanceof ITileEntityHasGUI){
			ITileEntityHasGUI tileWithGui = (ITileEntityHasGUI)tileEntity;
			return tileWithGui.getContainer(player);
		}
		return null;
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if(tileEntity instanceof ITileEntityHasGUI){
			ITileEntityHasGUI tileWithGui = (ITileEntityHasGUI)tileEntity;
			return tileWithGui.getGui(player);
		}
		return null;
	}
}
