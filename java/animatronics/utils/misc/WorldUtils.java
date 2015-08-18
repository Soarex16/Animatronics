package animatronics.utils.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import animatronics.api.Vector3;

import com.google.common.collect.Lists;

public class WorldUtils{

	public static BiomeGenBase[] biomesWithout(BiomeGenBase... biomesWithout){
		ArrayList<BiomeGenBase> biomes = Lists.newArrayList();
		for(BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()){
			if(biome != null){
				biomes.add(biome);
			}
		}
		if(biomesWithout.length != 0){
			biomes.removeAll(Arrays.asList(biomesWithout));
		}
		return biomes.toArray(new BiomeGenBase[biomes.size()]);
	}

	/** 
	 * Rotates the relative coordinates accordingly to the given direction.
	 */
	public static int[] rotationXZByDirection(int x, int y, int z, int direction){
		switch(direction){
		case 0:
			return new int[]{x, y, z};
		case 1:
			return new int[]{-z, y, x};
		case 2:
			return new int[]{-x, y, -z};
		default:
			return new int[]{z, y, -x};
		}
	}

	public static BiomeGenBase[] biomesWithoutArray(BiomeGenBase[]... biomesWithout){
		ArrayList<BiomeGenBase> biomes = Lists.newArrayList();
		for(BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()){
			if(biome != null){
				biomes.add(biome);
			}
		}
		for(BiomeGenBase[] biomesArray : biomesWithout){
			biomes.removeAll(Arrays.asList(biomesWithout));
		}
		return biomes.toArray(new BiomeGenBase[biomes.size()]);
	}

	public static boolean checkBlockRange(World world, int x, int y, int z, Block blockToCheck, boolean checkDown){
		return world.getBlock(x, y + 1, z) == blockToCheck && world.getBlock(x + 1, y, z) == blockToCheck && world.getBlock(x - 1, y, z) == blockToCheck && world.getBlock(x, y, z + 1) == blockToCheck && world.getBlock(x, y, z - 1) == blockToCheck && checkDown ? world.getBlock(x, y - 1, z) == blockToCheck : true;
	}

	public static void dropItemInRandomCoords(World world, ItemStack iStack, double x, double y, double z){
		float randPos = world.rand.nextFloat() * 0.8F + 0.1F;
		EntityItem entityitem = new EntityItem(world, x + randPos, y + randPos, z + randPos, iStack);
		if(iStack.hasTagCompound()){
			entityitem.getEntityItem().setTagCompound((NBTTagCompound)iStack.getTagCompound().copy());
		}
		entityitem.motionX = world.rand.nextGaussian() * 0.05F;
		entityitem.motionY = world.rand.nextGaussian() * 0.05F + 0.2F;
		entityitem.motionZ = world.rand.nextGaussian() * 0.05F;
		world.spawnEntityInWorld(entityitem);
	}
	
	public static boolean checkBlockAt(World w, Vector3 vec){
		return w.getBlock((int)vec.x, (int)vec.y, (int)vec.z) != null;
	}
	
	public static boolean checkBlockAt(World w, Vector3 vec, Block block){
		return w.getBlock((int)vec.x, (int)vec.y, (int)vec.z) == block;
	}
	
	public static boolean checkTileEntityAt(World w, Vector3 vec){
		return w.getTileEntity((int)vec.x, (int)vec.y, (int)vec.z) != null;
	}
	
	public static boolean checkTileEntityAt(World w, Vector3 vec, Class inst){
		return tileAt(w, vec) != null && tileAt(w,vec).getClass().isInstance(inst);
	}
	
	public static TileEntity tileAt(World w, Vector3 vec){
		return w.getTileEntity((int)vec.x, (int)vec.y, (int)vec.z);
	}
	
	public static List<Object> getEntitiesInRange(World world, Vector3 startingPoint, float range, Class<? extends Entity> clazz){
		return world.getEntitiesWithinAABB(clazz, AxisAlignedBB.getBoundingBox(startingPoint.x-range, startingPoint.y-range, startingPoint.z-range, startingPoint.x+range, startingPoint.y+range, startingPoint.z+range));
	}
}
