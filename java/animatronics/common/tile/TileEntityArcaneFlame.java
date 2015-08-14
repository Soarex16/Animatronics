package animatronics.common.tile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import animatronics.Animatronics;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.utils.misc.EnergyUtils;
import animatronics.utils.misc.Tinklerable;

public class TileEntityArcaneFlame extends TileEntityPrimary implements ITERequiresEntropy, Tinklerable {
	
	private float rng;
	private boolean tinklered = false;
	
	public TileEntityArcaneFlame() {
		super();
		this.setSlotsNum(0);
		this.setMaxEntropy(1000);
		rng = 5;
		tinklered = false;
	}
	
	public boolean canUpdate() {
		return true;
	}

	public void updateEntity() {
		
		super.updateEntity();
		EnergyUtils.manage(this, 0.5F, 0.5F, 0.5F);
        if (this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(9 - Animatronics.proxy.particleCount(2)) == 0) {
            	Animatronics.proxy.wispFX3(this.worldObj, this.xCoord + 0.5f, this.yCoord + 0.5f, this.zCoord + 0.5f, this.xCoord + 0.3f + this.worldObj.rand.nextFloat() * 0.4f, this.yCoord + 0.5f, this.zCoord + 0.3f + this.worldObj.rand.nextFloat() * 0.4f, 0.5f, 0, true, -0.025f);
            }
            if (this.worldObj.rand.nextInt(15 - Animatronics.proxy.particleCount(4)) == 0) {
            	Animatronics.proxy.wispFX3(this.worldObj, this.xCoord + 0.5f, this.yCoord + 0.5f, this.zCoord + 0.5f, this.xCoord + 0.4f + this.worldObj.rand.nextFloat() * 0.2f, this.yCoord + 0.5f, this.zCoord + 0.4f + this.worldObj.rand.nextFloat() * 0.2f, 0.25f, 0, true, entropy > 0? -0.12f: -0.02f);
            }
        }
        if(entropy > 0){
        try{
        	for(Object living: worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord-rng, yCoord-rng, zCoord-rng, xCoord+rng, yCoord+rng, zCoord+rng))){
        		EntityLivingBase e = (EntityLivingBase) living;
            		if(worldObj.getWorldTime()%5 == 0){
            			if(e != null){
            				if(!tinklered){
            					e.setFire(20);
            					if(e instanceof EntityVillager){
            						EntityWitch w = new EntityWitch(worldObj);
            						w.setPosition(e.posX, e.posY, e.posZ);
            						e.setDead();
            						
            						worldObj.spawnEntityInWorld(w);
            					}
            					if(e instanceof EntityPig){
            						EntityPigZombie w = new EntityPigZombie(worldObj);
            						w.setPosition(e.posX, e.posY, e.posZ);
            						e.setDead();
            						
            						worldObj.spawnEntityInWorld(w);
            					}
            				}else{
            					e.extinguish();
            					if(e instanceof EntityWitch){
            						EntityVillager w = new EntityVillager(worldObj);
            						w.setPosition(e.posX, e.posY, e.posZ);
            						e.setDead();
            						if(!worldObj.isRemote)
            						worldObj.spawnEntityInWorld(w);
            					}
            					if(e instanceof EntityPigZombie){
            						EntityPig w = new EntityPig(worldObj);
            						w.setPosition(e.posX, e.posY, e.posZ);
            						e.setDead();
            						if(!worldObj.isRemote)
            						worldObj.spawnEntityInWorld(w);
            					}
            				}
    	        		entropy --;
            			}
            		}
            	}
            }catch(Exception e){}
        }
        
	}

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

	@Override
	public void writeToNBT(NBTTagCompound i) {
		i.setBoolean("tinklered", tinklered);
		super.writeToNBT(i);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound i) {
		tinklered = i.getBoolean("tinklered");
		super.readFromNBT(i);
	}
	@Override
	public void onClicked(EntityPlayer player) {
		tinklered = !tinklered;
		if(worldObj.isRemote) System.out.println("cl " + tinklered);
		if(!worldObj.isRemote) System.out.println("sv " + tinklered);
		player.addChatComponentMessage(new ChatComponentText(tinklered? "The flame's energy soothes nearby elements...": "The flame's energy exterminates everything living around...").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.AQUA)));
		
	}
}
