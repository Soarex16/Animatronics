package animatronica.utils.misc;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityUtils{

	/** 
	 * Returns true if the mob is angry. 
	 */
	public static boolean isHostileEntity(EntityLivingBase entity){
		return entity instanceof IMob;
	}

	/** 
	 * Returns true if the mob is arthropod. 
	 */
	public static boolean isArthropodEntity(EntityLivingBase entity){
		return isHostileEntity(entity) ? entity.getCreatureAttribute().equals(EnumCreatureAttribute.ARTHROPOD) : false;
	}

	/** 
	 * Returns true if the mob is undead. 
	 */
	public static boolean isUndeadEntity(EntityLivingBase entity){
		return isHostileEntity(entity) ? entity.getCreatureAttribute().equals(EnumCreatureAttribute.UNDEAD) : false;
	}

	/** 
	 * Returns true if the entity is in motion.
	 */
	public static boolean isEntityMoving(Entity entity){
		return (entity != null && (entity.motionX != 0 || entity.motionY != 0 || entity.motionZ != 0));
	}

	/** 
	 * Returns true if the mob was killed by player.
	 */
	public static boolean wasEntityKilledByPlayer(DamageSource source) {
		if(source.getDamageType().equals("player")){
			return true;
		}
		if(source.getSourceOfDamage() instanceof EntityArrow){
			if(((EntityArrow)source.getSourceOfDamage()).shootingEntity != null){
				if(((EntityArrow)source.getSourceOfDamage()).shootingEntity instanceof EntityPlayer){
					return true;	
				}
			}
		}
		return false;
	}

	public static ChunkPosition getPlayerLookingAtBlock(EntityPlayerMP player, float reach){
		Vec3 vec3d = Vec3.createVectorHelper(player.posX, (player.posY + 1.6200000000000001D) - player.yOffset, player.posZ);
		Vec3 vec3d1 = player.getLookVec();
		Vec3 vec3d2 = vec3d.addVector(vec3d1.xCoord * reach, vec3d1.yCoord * reach, vec3d1.zCoord * reach);
		MovingObjectPosition hit = player.worldObj.rayTraceBlocks(vec3d, vec3d2);
		if(hit == null || hit.typeOfHit != MovingObjectType.BLOCK){
			return null;
		}
		return new ChunkPosition(hit.blockX, hit.blockY, hit.blockZ);
	}

	public static Entity getPlayerLookingAtEntity(EntityPlayer player, float reach){
		Vec3 vec3d = Vec3.createVectorHelper(player.posX, (player.posY + 1.6200000000000001D) - player.yOffset, player.posZ);
		Vec3 vec3d1 = player.getLookVec();
		Vec3 vec3d2 = vec3d.addVector(vec3d1.xCoord * reach, vec3d1.yCoord * reach, vec3d1.zCoord * reach);
		MovingObjectPosition hit = player.worldObj.rayTraceBlocks(vec3d, vec3d2);
		if(hit == null || hit.typeOfHit != MovingObjectType.ENTITY){
			return null;
		}
		return hit.entityHit;
	}

	public static MovingObjectPosition getPlayerLookObject(EntityPlayer player){
		float f = 1.0F;
		float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
		float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
		double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
		double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
		double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
		return player.worldObj.func_147447_a(vec3d, vec3d1, false, true, false); //rayTraceBlocks_do_do
	}
	
	public void setSize(Entity entity, float width, float height){
		float prevWidth;
		if(width != entity.width || height != entity.height){
			prevWidth = entity.width;
			entity.width = width;
			entity.height = height;
			entity.boundingBox.maxX = entity.boundingBox.minX + (double)entity.width;
			entity.boundingBox.maxZ = entity.boundingBox.minZ + (double)entity.width;
			entity.boundingBox.maxY = entity.boundingBox.minY + (double)entity.height;

			if(entity.width > prevWidth && !entity.worldObj.isRemote){
				entity.moveEntity((double)(prevWidth - entity.width), 0.0D, (double)(prevWidth - entity.width));
			}
		}
		prevWidth = width % 2.0F;
		if((double)prevWidth < 0.375D){
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_1;
		}else if ((double)prevWidth < 0.75D){
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_2;
		}else if ((double)prevWidth < 1.0D){
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_3;
		}else if ((double)prevWidth < 1.375D){
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_4;
		}else if ((double)prevWidth < 1.75D){
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_5;
		}else{
			entity.myEntitySize = Entity.EnumEntitySize.SIZE_6;
		}
	}
	
	public static void registerEntity(Class<? extends EntityLivingBase> entityClass, String name){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		int seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() ^ 0x06;
		int secondaryColor = rand.nextInt() ^ 0x06;
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityEggInfo(entityID, primaryColor, secondaryColor));
	}
}
