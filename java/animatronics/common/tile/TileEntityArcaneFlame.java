package animatronics.common.tile;

import animatronics.Animatronics;
import animatronics.api.energy.ITETransfersEntropy;
import animatronics.utils.misc.EnergyUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class TileEntityArcaneFlame extends TileEntityPrimary implements ITETransfersEntropy {
	
	public TileEntityArcaneFlame() {
		super();
		this.setSlotsNum(0);
		this.setMaxEntropy(1000);
	}
	
	public boolean canUpdate() {
		return true;
	}

	public void updateEntity() {
		super.updateEntity();
		EnergyUtils.manage(this, 0.5F, 0.5F, 0.5F);
        if (this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(9 - Animatronics.proxy.particleCount(2)) == 0) {
            	Animatronics.proxy.wispFX3(this.worldObj, this.xCoord + 0.5f, this.yCoord + 0.5f, this.zCoord + 0.5f, this.xCoord + 0.3f + this.worldObj.rand.nextFloat() * 0.4f, this.yCoord + 0.5f, this.zCoord + 0.3f + this.worldObj.rand.nextFloat() * 0.4f, 0.5f, 6, true, -0.025f);
            }
            if (this.worldObj.rand.nextInt(15 - Animatronics.proxy.particleCount(4)) == 0) {
            	Animatronics.proxy.wispFX3(this.worldObj, this.xCoord + 0.5f, this.yCoord + 0.5f, this.zCoord + 0.5f, this.xCoord + 0.4f + this.worldObj.rand.nextFloat() * 0.2f, this.yCoord + 0.5f, this.zCoord + 0.4f + this.worldObj.rand.nextFloat() * 0.2f, 0.25f, 6, true, -0.02f);
            }
            EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			Animatronics.proxy.wispFX4(this.getWorldObj(), xCoord+0.5, yCoord+0.5, zCoord+0.5, player, 4, true, 0);
        }
	}

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
}
