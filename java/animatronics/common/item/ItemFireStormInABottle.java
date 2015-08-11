package animatronics.common.item;

import animatronics.Animatronics;
import animatronics.utils.item.ItemContainerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemFireStormInABottle extends ItemContainerBase {
	
	public IIcon fire_storm_inactive;
	public IIcon fire_storm_active;

	public ItemFireStormInABottle(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		//Now I don't know? how I can do this :D
		return stack;
    }
	
	@Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
		fire_storm_inactive = par1IconRegister.registerIcon("animatronics:bs");
		fire_storm_active = par1IconRegister.registerIcon("animatronics:fsafs");
        itemIcon = par1IconRegister.registerIcon("animatronics:book_1");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack i)
    {
        if(i.getTagCompound() != null && i.stackTagCompound.getBoolean("opened")) {
        	return fire_storm_active;
        } else {
        	return fire_storm_inactive;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack i, int pass)
    {
    	if(i.getTagCompound() != null && i.stackTagCompound.getBoolean("opened")) {
        	return fire_storm_active;
        } else {
        	return fire_storm_inactive;
        }
    }

}
