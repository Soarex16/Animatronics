package animatronics.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityGatewayMirror extends TileEntity {
	
	public static double move;
	public static double back;
	
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
			if(move < 1) move+=0.01; 
			else if(back == 1) {
				move = 0;
				back = 0;
			} else back+=0.1;
		}
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }

}
