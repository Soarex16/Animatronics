package animatronica.debug;

import net.minecraft.tileentity.TileEntity;
import animatronica.Animatronica;

public class TileEntityDebug extends TileEntity {
	
	public boolean canUpdate(){
		return true;
	}
	
	public double rotate;
	
	@Override
	public void updateEntity() {
		rotate+=0.9;
		

			double radius = 512;
			int iter = 2;
			for(int i = 0; i < iter; i++) {
				double x = xCoord + 0.5;
				double y = yCoord + 0.5;
				double z = zCoord + 0.5;

				float w = 0.6F;
				float c = 1F - w;

				float r = w + (float) Math.random() * c;
				float g = w + (float) Math.random() * c;
				float b = w + (float) Math.random() * c;

				float s = 20F + (float) Math.random() * 20F;
				int m = 50;

				Animatronica.proxy.sparkleFX(worldObj, x, y, z, r, g, b, s, m);
			}
		}
	
}
