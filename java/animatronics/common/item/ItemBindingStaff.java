package animatronics.common.item;

import java.util.List;

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
import animatronics.Animatronics;
import animatronics.api.IItemBlockOutline;
import animatronics.api.Vector3;
import animatronics.api.energy.IItemAllowsSeeingEntropy;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.api.energy.ITETransfersEntropy;
import animatronics.common.tile.TileEntityPrimary;
import animatronics.utils.config.AnimatronicsConfiguration;
import animatronics.utils.helper.NBTHelper;
import animatronics.utils.item.ItemContainerBase;
import animatronics.utils.misc.WorldUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBindingStaff extends ItemContainerBase implements IItemAllowsSeeingEntropy, IItemBlockOutline {
	
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
		// Used for null-safety.
		NBTHelper.getStackTag(stack);
		if(!(stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("pos") && stack.stackTagCompound.hasKey("tile")))
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null)
			{
				if(tile instanceof ITEStoresEntropy || tile instanceof ITETransfersEntropy)
				{
					NBTHelper.getStackTag(stack).setIntArray("pos", new int[]{x,y,z});
					NBTHelper.getStackTag(stack).setInteger("dim", player.dimension);
					NBTHelper.getStackTag(stack).setString("tile", tile.getBlockType().getLocalizedName());
					player.addChatMessage(new ChatComponentText("Staff now contains alias of " + tile.getBlockType().getLocalizedName()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
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
					double distance = Vector3.fromArray(coords).getDistanceTo(new Vector3(x,y,z));
					float maxDist = AnimatronicsConfiguration.maxEnergyDistance;
					if(distance <= maxDist){
						((TileEntityPrimary)tile).storageCoord = new Vector3(coords[0],coords[1],coords[2]);
						world.playSoundAtEntity(player, "random.levelup", 1.0F, 0.01F);
						player.addChatMessage(new ChatComponentText("Machine linked").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
						world.markBlockForUpdate(x, y, z);
						stack.getTagCompound().removeTag("pos");
						stack.getTagCompound().removeTag("dim");
						stack.getTagCompound().removeTag("tile");
						return true;
					}
				}
			}
		}
        return false;
    }
	
	public void removeBinding(ItemStack stack){
		// Null-safety.
		NBTHelper.getStackTag(stack);
		stack.getTagCompound().removeTag("pos");
		stack.getTagCompound().removeTag("dim");
		stack.getTagCompound().removeTag("tile");
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
		NBTHelper.getStackTag(itemStack);
    	if(itemStack.getTagCompound() != null && itemStack.stackTagCompound.hasKey("pos") && itemStack.stackTagCompound.hasKey("dim") && itemStack.stackTagCompound.hasKey("tile") && !world.isRemote)
    	{
    		removeBinding(itemStack);
    		world.playSoundAtEntity(player, "random.break", 1.0F, 0.01F);
    		player.addChatMessage(new ChatComponentText("Staff no longer remembers the machine.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));

    	}
        return itemStack;
    }
    
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
    {
    	if(itemStack.getTagCompound() != null && itemStack.stackTagCompound.hasKey("pos") && itemStack.stackTagCompound.hasKey("dim") && itemStack.stackTagCompound.hasKey("tile")){
    		int coord[] = NBTHelper.getStackTag(itemStack).getIntArray("pos");
    		String tile = NBTHelper.getStackTag(itemStack).getString("tile");
    		list.add("Connected to " + tile + " at:");
	    	list.add(EnumChatFormatting.DARK_RED + "x: "+coord[0]);
	    	list.add(EnumChatFormatting.DARK_GREEN + "y: "+coord[1]);
	    	list.add(EnumChatFormatting.DARK_BLUE + "z: "+coord[2]);
	    	list.add(EnumChatFormatting.GOLD + "dimension: "+NBTHelper.getStackTag(itemStack).getInteger("dim"));
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
        if(stack.stackTagCompound != null && (stack.stackTagCompound.hasKey("pos") && stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("tile"))) {
        	return bs_active;
        } else {
        	return bs_inactive;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass)
    {
    	 if(stack.stackTagCompound != null && (stack.stackTagCompound.hasKey("pos") && stack.stackTagCompound.hasKey("dim") && stack.stackTagCompound.hasKey("tile"))) {
        	return bs_active;
        } else {
        	return bs_inactive;
        }
    }
    
    @Override
    public void onUpdate(ItemStack s, World w, Entity e, int slot, boolean held) {
    	if(w.isRemote) return;
    	if(WorldUtils.tileAt(w, Vector3.fromArray(NBTHelper.getStackTag(s).getIntArray("pos"))) == null | !(WorldUtils.tileAt(w, Vector3.fromArray(NBTHelper.getStackTag(s).getIntArray("pos"))) instanceof TileEntityPrimary)){
    		removeBinding(s);
    	}
    }

	@Override
	public Vector3 getBindingCoordinates(ItemStack stack) {
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("pos")) {
			int[] coords = stack.stackTagCompound.getIntArray("pos");
			return Vector3.fromArray(coords);
		} else
			return null;
	}
}    