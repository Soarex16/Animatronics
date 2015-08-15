package animatronics.common.item;

import java.util.List;

import animatronics.Animatronics;
import animatronics.api.energy.IItemAllowsSeeingEntropy;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.api.energy.ITETransfersEntropy;
import animatronics.common.tile.TileEntityPrimary;
import animatronics.utils.config.AnimatronicsConfiguration;
import animatronics.utils.helper.DistanceHelper;
import animatronics.utils.helper.NBTHelper;
import animatronics.utils.item.ItemContainerBase;
import animatronics.utils.misc.Vector3;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBindingStaff extends ItemContainerBase implements IItemAllowsSeeingEntropy {
	
	public IIcon bs_inactive;
	public IIcon bs_active;
	
	public static Vector3 genCoords;
	
	public ItemBindingStaff(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		maxStackSize = 1;
	}

	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote) return false;
		if(!(stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("pos")))
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null)
			{
				if(tile instanceof ITEStoresEntropy || tile instanceof ITETransfersEntropy)
				{
					genCoords =  new Vector3(x, y, z);
					NBTHelper.getStackTag(stack).setIntArray("pos", new int[]{x,y,z});
					NBTHelper.getStackTag(stack).setInteger("dim", player.dimension);
					player.addChatMessage(new ChatComponentText("Staff now contains machine alias").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
					return true;
				}
			}
		}else
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null && player.isSneaking())
			{
				if(tile instanceof ITERequiresEntropy  || tile instanceof ITETransfersEntropy)
				{
					int[] coords = NBTHelper.getStackTag(stack).getIntArray("pos");
					float distance = new DistanceHelper(new Vector3(x,y,z),new Vector3(coords[0],coords[1],coords[2])).getDistance();
					float maxDist = AnimatronicsConfiguration.maxEnergyDistance;
					if(distance <= maxDist){
						genCoords = null;
						((TileEntityPrimary)tile).storageCoord = new Vector3(coords[0],coords[1],coords[2]);
						world.playSoundAtEntity(player, "random.levelup", 1.0F, 0.01F);
						player.addChatMessage(new ChatComponentText("Machine linked").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
						world.markBlockForUpdate(x, y, z);
						stack.getTagCompound().removeTag("pos");
						stack.getTagCompound().removeTag("dim");
						return true;
					}
				}
			}
		}
        return false;
    }

	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
    	if(itemStack.stackTagCompound.hasKey("pos") && itemStack.stackTagCompound.hasKey("dim") && !world.isRemote)
    	{
    		itemStack.stackTagCompound.removeTag("pos");
    		itemStack.stackTagCompound.removeTag("dimension");
    		world.playSoundAtEntity(player, "random.break", 1.0F, 0.01F);
    		player.addChatMessage(new ChatComponentText("Staff no longer remembers the machine.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));

    	}
        return itemStack;
    }
    
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
    {
    	if(NBTHelper.getStackTag(itemStack).hasKey("pos")){
    		int coord[] = NBTHelper.getStackTag(itemStack).getIntArray("pos");
    		list.add("Connected to Machine at:");
	    	list.add(EnumChatFormatting.DARK_RED + "x: "+coord[0]);
	    	list.add(EnumChatFormatting.DARK_GREEN + "y: "+coord[1]);
	    	list.add(EnumChatFormatting.DARK_BLUE + "z: "+coord[2]);
	    	list.add(EnumChatFormatting.GOLD + "dimension: "+NBTHelper.getStackTag(itemStack).getInteger("dimension"));
    	}
    }
    
    public static int[] getCoords(ItemStack stack)
    {
    	return NBTHelper.getStackTag(stack).getIntArray("pos");
    }
    
    
    public boolean createTag(ItemStack stack)
    {
    	if(stack.getTagCompound() == null)
    	{
    		NBTTagCompound tag = new NBTTagCompound();
    		tag.setIntArray("pos", new int[]{0,0,0});
    		return true;
    	}
    	return false;
    }
    
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        bs_inactive = par1IconRegister.registerIcon("animatronics:binding_staff_empty");
        bs_active = par1IconRegister.registerIcon("animatronics:binding_staff_full");
        itemIcon = par1IconRegister.registerIcon("animatronics:binding_staff_empty");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack)
    {
        if(stack.stackTagCompound != null && (stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("pos"))) {
        	return bs_active;
        } else {
        	return bs_inactive;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass)
    {
    	 if(stack.stackTagCompound != null && (stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("pos"))) {
        	return bs_active;
        } else {
        	return bs_inactive;
        }
    }
    
    @Override
    public void onUpdate(ItemStack s, World w, Entity e, int slot, boolean held) {
    	
    }
}    