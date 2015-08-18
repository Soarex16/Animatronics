package animatronics.common.tile;

import java.util.Calendar;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiMoonPrism;
import animatronics.common.inventory.ContainerMoonPrism;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;

public class TileEntityMoonPrism extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI {
	
	public boolean isWorking = false;
	public float entropyGenerated;
	public int range = 4;
	
	public TileEntityMoonPrism() {
		super();
		this.setSlotsNum(0);
		this.setMaxEntropy(500);
		entropyGenerated = 4;
	}
	
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(Math.random() < 0.05) {
			if(worldObj.canBlockSeeTheSky(xCoord, yCoord+1, zCoord) && !worldObj.isRaining() && !worldObj.isDaytime()) {
				Calendar calendar = Calendar.getInstance();
				if(calendar.get(calendar.MONTH) == calendar.APRIL && calendar.get(calendar.DAY_OF_MONTH) == 1) {
					for(Object e: worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord-range, yCoord-range, zCoord-range, xCoord+range, yCoord+range, zCoord+range))){
						((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 72000, 10));
					}
				}
				int moonPhase = this.worldObj.provider.getMoonPhase(this.worldObj.getWorldTime());
				float moonFactor = 1.0F;
				switch(moonPhase)
				{
					case 0:
						moonFactor = 1.0F;
						break;					
					case 1:
						moonFactor = 0.75F;
						break;
					case 7:
						moonFactor = 0.75F;
						break;
					case 2:
						moonFactor = 0.5F;
						break;
					case 6:
						moonFactor = 0.5F;
						break;
					case 3:
						moonFactor = 0.25F;
						break;
					case 5:
						moonFactor = 0.25F;
						break;
					case 4:
						moonFactor = 0.0F;
						break;
				}
				entropyGenerated*=moonFactor;
				float heightFactor = 1.0F;
				if(yCoord > 80)
					heightFactor = 0F;
				else
				{
					heightFactor = 1.0F - (float)((float)yCoord/80F);
					entropyGenerated *= heightFactor;
				}
				if(entropyGenerated > 0) {
					isWorking = true;
					setEntropy((int)(getEntropy()+entropyGenerated));
					if(getEntropy() > getMaxEntropy())
						setEntropy(getMaxEntropy());
				}
			}
		}	
	}

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

	@Override
	public Container getContainer(EntityPlayer player) {
		return new ContainerMoonPrism(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player) {
		return new GuiMoonPrism(getContainer(player), this);
	}

}
