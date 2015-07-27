package animatronica.debug;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronica.api.energy.ITERequiresEntropy;
import animatronica.api.energy.ITEStoresEntropy;
import animatronica.api.energy.ITETransfersEntropy;
import animatronica.common.tile.TileEntityPrimary;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.helper.DistanceHelper;
import animatronica.utils.helper.NBTHelper;
import animatronica.utils.helper.Vector3;
import animatronica.utils.item.ItemContainerBase;

public class ItemDebug extends ItemContainerBase {

	public ItemDebug(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		setCreativeTab(animatronica.Animatronica.creativeTabAnimatronica);
	}
	
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote) return false;
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null) {
			if(tile instanceof ITEStoresEntropy || tile instanceof ITETransfersEntropy) {
				player.addChatMessage(new ChatComponentText("Entropy : " + ((TileEntityPrimary)tile).getEntropy()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY)));
				return true;
			} else {
			if(tile instanceof ITERequiresEntropy) {
				player.addChatMessage(new ChatComponentText("Storage coordinates : " + ((TileEntityPrimary)tile).storageCoord).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
				player.addChatMessage(new ChatComponentText("Entropy : " + ((TileEntityPrimary)tile).getEntropy()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY)));					return true;
				}
			}		
		}
        return false;
    }
	
	@Override
	public void addInformation(ItemStack stk, EntityPlayer p, List list, boolean held) {
		list.add(EnumChatFormatting.GREEN+"Only for developers");
		list.add(EnumChatFormatting.RED+"Can cause crashes");
	}
	
}
