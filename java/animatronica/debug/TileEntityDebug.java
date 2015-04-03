package animatronica.debug;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.common.util.ForgeDirection;
import animatronica.Animatronica;
import animatronica.common.tile.TileAnimatronica;

public class TileEntityDebug extends TileAnimatronica {
	
	public boolean canUpdate(){
		return true;
	}
	
	public double rotate;
	
	@Override
	public void updateEntity() {
		rotate+=0.9;
		
		boolean redstone = false;
		for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			int redstoneSide = worldObj.getIndirectPowerLevelTo(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ, dir.ordinal());
			if(redstoneSide > 0)
				redstone = true;
		}
		
		Animatronica.proxy.wispFX(worldObj, xCoord+0.5, yCoord+0.4, zCoord+0.5, (float)(Math.random()*0.15), 1F, (float)(Math.random()*0.15), (float)(Math.random()*0.4-0.1), -0.01F, 1F);
		Animatronica.proxy.sparkleFX(worldObj, xCoord+0.5, yCoord+0.7, zCoord+0.5, (float)(Math.random()*0.15), 1F, (float)(Math.random()*0.15), (float)(Math.random()*0.75), 25);
		/*
		if(redstone)
			int iter = 2;
			for(int i = 0; i < iter; i++) {
				double x = xCoord + 0.5 + (Math.random() - 0.5);
				double y = yCoord + 1.0;
				double z = zCoord + 0.5 + (Math.random() - 0.5);

				float w = 0.6F;
				float c = 1F - w;

				float r = (float) Math.random();
				float g = (float) Math.random();
				float b = (float) Math.random();

				float s = 2F + (float) Math.random();
				int m = 30;

				Animatronica.proxy.sparkleFX(worldObj, x, y, z, r, g, b, s, m);
			*/
	}
}
