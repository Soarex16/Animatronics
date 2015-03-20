package animatronica.api.energy;

import net.minecraft.nbt.NBTTagCompound;

public class EnergyUtils {
	
	public static final float GENERATOR_MAXIMUN_ENTROPY_GLOBAL = 1000000F;
	public static final float CONSUMER_MAXIMUM_ENTROPY_GLOBAL = 100000F;
	
	public static void saveMRUState(ITEHasEntropy tile, NBTTagCompound saveTag)
	{
		
		saveTag.setFloat("entropy", tile.getEntropy());
		saveTag.setFloat("maxEntropy", tile.getMaxEntropy());
		saveTag.setString("uuid", tile.getUUID().toString());
	}
	
	public static void loadMRUState(ITEHasEntropy tile, NBTTagCompound loadTag)
	{
		tile.setEntropy((int) loadTag.getFloat("mru"));
		tile.setMaxEntropy(loadTag.getFloat("maxEntopry"));
	}
	
	//TODO: when I made enrgy for items, I need made this @@public static void entropyIn(TileEntity tile, int slotNum){}@@ - checking for entropy energy in the items in tile inventory
}
