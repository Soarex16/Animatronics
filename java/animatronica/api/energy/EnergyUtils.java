package animatronica.api.energy;

import animatronica.common.tile.TileEntityPrimary;
import animatronica.utils.helper.Coord3D;
import animatronica.utils.helper.DistanceHelper;
import animatronica.utils.helper.Vector3;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;

public class EnergyUtils {
	
	public static final float GENERATOR_MAXIMUN_ENTROPY_GLOBAL = 1000000F;
	public static final float CONSUMER_MAXIMUM_ENTROPY_GLOBAL = 100000F;
	
	public static void saveEntropyState(ITEHasEntropy tile, NBTTagCompound saveTag)
	{
		
		saveTag.setFloat("entropy", tile.getEntropy());
		saveTag.setFloat("maxEntropy", tile.getMaxEntropy());
		saveTag.setString("uuid", tile.getUUID().toString());
	}
	
	public static void loadEntropyState(ITEHasEntropy tile, NBTTagCompound loadTag)
	{
		tile.setEntropy((int) loadTag.getFloat("entropy"));
		tile.setMaxEntropy(loadTag.getFloat("maxEntopry"));
	}
	
	public static void saveCoord(TileEntityPrimary tile, NBTTagCompound saveTag)
	{
		saveTag.setDouble("coordX", tile.storageCoord.x);
		saveTag.setDouble("coordY", tile.storageCoord.y);
		saveTag.setDouble("coordZ", tile.storageCoord.z);
	}
	
	public static void loadCoord(TileEntityPrimary tile, NBTTagCompound loadTag)
	{
		tile.storageCoord.x = loadTag.getDouble("coordX");
		tile.storageCoord.y = loadTag.getDouble("coordY");
		tile.storageCoord.z = loadTag.getDouble("coordZ");
	}
	
	public static void entropyIn(TileEntity tile)
	{
			TileEntityPrimary entropyt = (TileEntityPrimary) tile;
			ItemStack s;
			float[] coord = {(float) entropyt.storageCoord.x, (float) entropyt.storageCoord.y, (float) entropyt.storageCoord.z};
			
			if(tile.getWorldObj().getTileEntity((int)coord[0], (int)coord[1], (int)coord[2]) != null && tile.getWorldObj().getTileEntity((int)coord[0], (int)coord[1], (int)coord[2]) instanceof ITEHasEntropy)
			{
				ITEHasEntropy t = (ITEHasEntropy) tile.getWorldObj().getTileEntity((int)coord[0], (int)coord[1], (int)coord[2]);
				if(t != tile && t != null && !tile.getWorldObj().isRemote)
				{
					if(entropyt.getEntropy() < entropyt.getMaxEntropy())
					{
						int entropy = t.getEntropy();
						if(entropy > entropyt.getMaxEntropy() - entropyt.getEntropy())
						{
							t.setEntropy(entropy-(entropyt.getMaxEntropy() - entropyt.getEntropy()));
							entropyt.setEntropy(entropyt.getMaxEntropy());
						}else
						{
							t.setEntropy(0);
							entropyt.setEntropy(entropyt.getEntropy()+entropy);
	    				}
					}
				}
			}
			if(entropyt.getEntropy() < 0)
				entropyt.setEntropy(0);
	}
	
	public static void manage(TileEntity tile)
	{
		entropyIn(tile);
		//spawnParticles(tile);
	}
	
	//TODO: when I made energy for items, I need made this public static void entropyIn(TileEntity tile, int slotNum){}@@ - checking for entropy energy in the items in tile inventory
}
