package animatronics.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import animatronics.Animatronics;
import animatronics.utils.item.ItemContainerBase;
import animatronics.utils.misc.InformationProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFireStormInABottle extends ItemContainerBase{
	
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
				// йнлс мсфем опнярни йнд, йнцдю окюрър онярпнвмн
				opened = !stack.stackTagCompound.getBoolean("opened");
				stack.stackTagCompound.setBoolean("opened", opened);
			} else {
				NBTTagCompound tag = new NBTTagCompound();
	    		tag.setBoolean("opened", true);
	    		opened = true;
	    		stack.setTagCompound(tag);
			}
		}
		return stack;
    }
	
	/*
	 * baaaaubles, come heeere
	 */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isEquipped) {
		if(opened) {// 'while' JUST TERMINATES THE CLIENT, GOD DAMMIT!!!11
			Entity target = Minecraft.getMinecraft().pointedEntity;
			if(target != null) {
				if(world.getWorldTime() % 5 == 0){
				//	Animatronics.proxy.wispFX4(world, entity.posX, entity.posY+1.5, entity.posZ, target, 4, true, 0);
				}
				//if(world.isRemote)target.setFire(20);
				//well, the method is client-side oriented.
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
