package animatronica.api.energy;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.utils.helper.NBTHelper;
import animatronica.utils.item.ItemContainerBase;

public class ItemCoordinationMatrix extends ItemContainerBase {

	public ItemCoordinationMatrix(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		this.setTextureName("ItemCoordinationMatrix");
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
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		TileEntity tile = world.getTileEntity(x, y, z);
    	if(tile != null && !world.isRemote)
    	{	
    		if(tile instanceof ITERequiresEntropy || tile instanceof ITETransfersEntropy || tile instanceof ITEStoresEntropy && !world.isRemote)
    		{
    			ITEHasEntropy tile1 = (ITEHasEntropy) tile;
    			createTag(stack);
    			NBTHelper.getStackTag(stack).setIntArray("position", new int[]{x,y,z});
    			NBTHelper.getStackTag(stack).setInteger("dimension", player.dimension);
    			world.playSoundAtEntity(player, "random.levelup", 1.0F, 1.0F);
    			return false;
    		}
    	}else
    	{
    		if(world.getBlock(x, y, z) instanceof ICoordinationMatrixClickable)
    		{
    			createTag(stack);
    			NBTHelper.getStackTag(stack).setIntArray("position", new int[]{x,y,z});
    			NBTHelper.getStackTag(stack).setInteger("dimension", player.dimension);
    			world.playSoundAtEntity(player, "random.levelup", 1.0F, 1.0F);
    			return true;
    		}
    	}
		return true;
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
    	if(itemStack.getTagCompound() != null && !world.isRemote && player.isSneaking())
    	{
    		itemStack.setTagCompound(null);
    		world.playSoundAtEntity(player, "random.break", 1.0F, 0.01F);
    	}
        return itemStack;
    }
	

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) 
    {
    	if(itemStack.getTagCompound() != null)
    	{
    		int[] coord = NBTHelper.getStackTag(itemStack).getIntArray("position");
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
	
}
