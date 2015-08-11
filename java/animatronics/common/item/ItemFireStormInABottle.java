package animatronics.common.item;

import animatronics.Animatronics;
import animatronics.utils.helper.NBTHelper;
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
	
	public boolean opened = false;

	public ItemFireStormInABottle(String unlocalizedName, String modId, int maxDamage) {
		super(unlocalizedName, modId, maxDamage);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			if(stack.getTagCompound() != null && stack.stackTagCompound.hasKey("opened")) {	
				if(stack.stackTagCompound.getBoolean("opened")) {
					stack.stackTagCompound.setBoolean("opened", false);
					opened = false;
				} else {
					stack.stackTagCompound.setBoolean("opened", true);
					opened = true;
				}
			} else {
				NBTTagCompound tag = new NBTTagCompound();
	    		tag.setBoolean("opened", true);
	    		stack.setTagCompound(tag);
			}
		}
		return stack;
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isEquipped) {
		while(opened) {
			Entity target = Minecraft.getMinecraft().pointedEntity;
			if(target != null) {
				Animatronics.proxy.wispFX4(world, entity.posX, entity.posY+1.5, entity.posZ, target, 4, true, 0);
				target.setFire(20);
			}
		}
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
