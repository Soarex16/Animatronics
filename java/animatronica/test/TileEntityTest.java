package animatronica.test;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityTest extends TileEntity {
	
	public float renderIndex;
	
	float balance = 1.6F;
	
	public boolean canUpdate(){
	    return true;
	}   
	
	public float getBalanse(){
		return balance;
	}

	public void onUpdate(TileEntity tile){
		TileEntityTest test = (TileEntityTest)tile;
		
		renderIndex += 0.001F*test.getBalanse();
    	if(renderIndex>=1F)renderIndex=0F;
	}
	
/*	
	@Override
	public void updateEntity() {
		
		int meta = getBlockMetadata();
		if(!worldObj.isRemote) {
			int newMeta = worldObj.isDaytime() ? 0 : 1;
			if(newMeta != meta) {
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, newMeta, 1 | 2);
				meta = newMeta;
			}
		}

		if(meta == 1) { 
			
		
			double radius = 512;
			int iter = 2;
			for(int i = 0; i < iter; i++) {
				double x = xCoord; //+ 0.5 + (Math.random() - 0.5) * radius;
				double y = yCoord + 256;
				double z = zCoord; //+ 0.5 + (Math.random() - 0.5) * radius;

				float w = 0.6F;
				float c = 1F - w;

				float r = w + (float) Math.random() * c;
				float g = w + (float) Math.random() * c;
				float b = w + (float) Math.random() * c;

				float size = 20F + (float) Math.random() * 20F;
				int m = 50;

				Animatronica.proxy.sparkleFX(worldObj, x, y, z, r, g, b, size, m);
			}
		}
	}
*/
}
