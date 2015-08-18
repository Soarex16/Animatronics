package animatronics.common.integration;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import animatronics.api.IItemBlockOutline;
import animatronics.api.Vector3;
import animatronics.api.energy.IItemAllowsSeeingEntropy;
import animatronics.common.item.ItemBindingStaff;
import animatronics.common.tile.TileEntityPrimary;
import animatronics.utils.helper.NBTHelper;
import animatronics.utils.misc.WorldUtils;
import dsp.api.DebugScreenPlusAPI;
import dsp.api.IHeldItemModule;
import dsp.api.IPointedBlockModule;

public class DebugScreenIntegration{

	public static class HeldItem implements IHeldItemModule{

		@Override
		public void addItemInfo(ItemStack itemstack, List<String> left,	List<String> right, String pagename) {
			if(itemstack.getItem() instanceof ItemBindingStaff){
				if(!itemstack.hasTagCompound()){
					NBTHelper.getStackTag(itemstack);
				}
				if(itemstack.stackTagCompound.hasKey("pos")){
					left.add("Bound to tile at: " + Vector3.fromArray(itemstack.stackTagCompound.getIntArray("pos")).toString());
					left.add("In dimension: " + itemstack.stackTagCompound.getInteger("dim"));
					left.add("Tile name: " + itemstack.stackTagCompound.getString("tile"));
				}else{
					left.add("Unbound.");
				}
				right.remove(0);
				right.add("Click on block, that generates");
				right.add("or stores entropy to start");
				right.add("connection. Then click on block");
				right.add("that uses or transfers entropy.");
			}
			if(itemstack.getItem() instanceof IItemAllowsSeeingEntropy){
				left.add("Allows player see tile connections");
			}
			if(itemstack.getItem() instanceof IItemBlockOutline){
				left.add("Allows player see selected block outilne");
			}
		}
		
	}
	
	public static class PointedBlock implements IPointedBlockModule{
		@Override
		public void addBlockInfo(EntityPlayer player, Block block, List<String> left, List<String> right, String pagename) {			
			if("Animatronics".equals(pagename)){
				MovingObjectPosition pos = DebugScreenPlusAPI.pointedObject(player, player.worldObj);
				if(pos != null){
					Vector3 vec = new Vector3(pos.blockX, pos.blockY, pos.blockZ);
					if(WorldUtils.checkTileEntityAt(player.worldObj, vec)){
						if(WorldUtils.tileAt(player.worldObj, vec) instanceof TileEntityPrimary){
							TileEntityPrimary tile = (TileEntityPrimary)WorldUtils.tileAt(player.worldObj, vec);
							left.add("Entropy: " + tile.getEntropy() + "/" + tile.getMaxEntropy());
							if(tile.storageCoord != null){
								left.add("Bound to tile at: " + tile.storageCoord.toString());
							}
						}
					}
				}
			}
		}
	}
	
}
