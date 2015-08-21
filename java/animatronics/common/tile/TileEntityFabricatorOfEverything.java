package animatronics.common.tile;

import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.client.render.RenderPatterns;
import animatronics.common.block.BlockCreativeEntropyStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;

public class TileEntityFabricatorOfEverything extends TileEntityPrimary implements ITERequiresEntropy{

	public int outlineTime = 200;
	public int size = 2;
	
	public TileEntityFabricatorOfEverything() {
		super();
		setMaxEntropy(10000);
		setSlotsNum(5); //I don't know :D
	}
	
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		if(outlineTime != 0) {
			if(outlineTime % 20 == 0) {
				if(worldObj.isRemote) {
					EntityPlayer player = Minecraft.getMinecraft().thePlayer;
					player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("building.start") + " " + outlineTime/20));
				}
			}
			--outlineTime;
		}
	}	
	
	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
}
