package animatronics.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronics.Animatronics;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.api.energy.ITETransfersEntropy;
import animatronics.common.tile.TileEntityPrimary;
import animatronics.utils.config.AnimatronicsConfiguration;
import animatronics.utils.helper.DistanceHelper;
import animatronics.utils.helper.NBTHelper;
import animatronics.utils.item.ItemBase;
import animatronics.utils.misc.Tinklerable;
import animatronics.utils.misc.Vector3;

public class ItemMagicalTinkler extends ItemBase{

	public ItemMagicalTinkler() {
		super("itemTinkler", Animatronics.MOD_ID);
		setTextureName("bs");
		setCreativeTab(Animatronics.creativeTabAnimatronics);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,World world, int x, int y, int z, int side, float hitX, float hitY,float hitZ) {
		if(world.isRemote) return false;
		TileEntity tile = world.getTileEntity(x, y, z);
		System.out.println(world.isRemote);
		if(tile != null && tile instanceof Tinklerable)
		{
			((Tinklerable)tile).onClicked(player);
			return true;
		}
		return false;
	}


}
