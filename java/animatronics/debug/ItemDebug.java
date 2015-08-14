package animatronics.debug;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.energy.IItemAllowsSeeingEntropy;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.api.energy.ITETransfersEntropy;
import animatronics.common.tile.TileEntityPrimary;
import animatronics.utils.item.ItemContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import static animatronics.utils.misc.ItemUtils.*;

public class ItemDebug extends ItemContainerBase implements IItemAllowsSeeingEntropy {

	public ItemDebug(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
	}
	
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote) return false;
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null) {
			if(tile instanceof ITEStoresEntropy) {
				player.addChatMessage(new ChatComponentText("Entropy : " + ((TileEntityPrimary)tile).getEntropy()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY)));
				return true;
			} else {
			if(tile instanceof ITERequiresEntropy  || tile instanceof ITETransfersEntropy) {
				player.addChatMessage(new ChatComponentText("Storage coordinates : " + ((TileEntityPrimary)tile).storageCoord).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
				player.addChatMessage(new ChatComponentText("Entropy : " + ((TileEntityPrimary)tile).getEntropy()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY)));					return true;
				}
			}		
		}
        return false;
    }
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GOLD + getInfoProviderTag(INFO_TAG_DEV));
		list.add(EnumChatFormatting.GOLD + getInfoProviderTag(INFO_TAG_CRASH));
	}
	
}
