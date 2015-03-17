package animatronica.utils.block;

import java.util.List;

import animatronica.utils.helper.InformationProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockAnimatronica extends ItemBlock {

	public ItemBlockAnimatronica(Block b) {
		super(b);
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) 
    {
    	if(this.field_150939_a != null && this.field_150939_a instanceof InformationProvider)
    	{
    		((InformationProvider)this.field_150939_a).addInformation(stk, p, lst, held);
    	}
    }
	
	public String getUnlocalizedName(ItemStack itemStack)
    {
        return this.field_150939_a.getUnlocalizedName()+itemStack.getItemDamage();
    }
	
	@Override
	public int getMetadata(int i)
	{
		return i;
	}

}
