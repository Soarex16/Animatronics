package animatronica.api.energy;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.utils.helper.NBTHelper;
import animatronica.utils.item.ItemContainerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoordinationMatrix extends ItemContainerBase {

	public IIcon icon;
	public IIcon icon_activated;
	
	public ItemCoordinationMatrix(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		//this.setTextureName("ItemBindingStaff");
		this.setCreativeTab(Animatronica.creativeTabAnimatronica);
		this.maxStackSize = 1;
	}
	
	public boolean createTag(ItemStack stack)
    {
    	if(stack.getTagCompound() == null)
    	{
    		NBTTagCompound tag = new NBTTagCompound();
    		tag.setIntArray("position", new int[]{0,0,0});
    		return true;
    	}
    	return false;
    }

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int xCoord, int yCoord, int zCoord, int side, float hitX, float hitY, float hitZ){
		TileEntity tile = world.getTileEntity(xCoord, yCoord, zCoord);
    	if(tile != null && !world.isRemote)
    	{	
    		if((tile instanceof ITERequiresEntropy || tile instanceof ITETransfersEntropy || tile instanceof ITEStoresEntropy) && !world.isRemote)
    		{
    			ITEHasEntropy tile1 = (ITEHasEntropy) tile;
    			createTag(stack);
    			NBTHelper.getStackTag(stack).setIntArray("position", new int[]{xCoord,yCoord,zCoord});
    			NBTHelper.getStackTag(stack).setInteger("dimension", player.dimension);
    			player.addChatMessage(new ChatComponentText("Staff contains machine alias").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    			return true;
    		}
    	}else
    	{
    		if(world.getBlock(xCoord, yCoord, zCoord) instanceof ICoordinationMatrixClickable)
    		{
    			createTag(stack);
    			NBTHelper.getStackTag(stack).setIntArray("position", new int[]{xCoord,yCoord,zCoord});
    			NBTHelper.getStackTag(stack).setInteger("dimension", player.dimension);
    			player.addChatMessage(new ChatComponentText("Staff contains machine alias").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    			return true;
    		}
    	}
		return false;
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
		if(itemStack.getTagCompound() != null) {
			if(player.isSneaking()) {
				//player.addChatMessage(new ChatComponentText("valid").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
					itemStack.setTagCompound(null);
					player.addChatMessage(new ChatComponentText("Information in the staff was removed").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
			}
		}
		 return itemStack;
    }
	

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
    {
    	if(itemStack.getTagCompound() != null)
    	{
    		int coord[] = NBTHelper.getStackTag(itemStack).getIntArray("position");
    		list.add("Connected to Machine at:");
    		list.add(EnumChatFormatting.DARK_RED + "x: "+coord[0]);
    		list.add(EnumChatFormatting.DARK_GREEN + "y: "+coord[1]);
    		list.add(EnumChatFormatting.DARK_BLUE + "z: "+coord[2]);
    		list.add(EnumChatFormatting.GOLD + "dimension: "+NBTHelper.getStackTag(itemStack).getInteger("dimension"));
    	}
    }
    
    public static int[] getCoords(ItemStack stack)
    {
    	return NBTHelper.getStackTag(stack).getIntArray("position");
    }
	
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.icon = par1IconRegister.registerIcon(Animatronica.MOD_ID + ":" + "ItemBindingStaff");
        this.icon_activated = par1IconRegister.registerIcon(Animatronica.MOD_ID + ":" + "ItemCoordinationMatrix");
        this.itemIcon = par1IconRegister.registerIcon(Animatronica.MOD_ID + ":" + "ItemBindingStaff");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack i)
    {
        if(i.hasTagCompound())
        {
        	return this.icon_activated;
        }else
        {
        	return this.icon;
        }
    }
    
}
