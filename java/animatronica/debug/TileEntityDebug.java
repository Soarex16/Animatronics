package animatronica.debug;

import net.minecraft.tileentity.TileEntity;

public class TileEntityDebug extends TileEntity {
	
	public boolean canUpdate(){
		return true;
	}
	
	@Override
	public void updateEntity(){
		worldObj.spawnParticle("reddust", 0, 0, 0, 0, 0, 0);
	}

}
