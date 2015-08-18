package animatronics.utils.block;

import java.util.List;

import animatronics.api.misc.InformationProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockAnimatronics extends ItemBlock {

	public ItemBlockAnimatronics(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) 
    {
    	if(this.field_150939_a != null && this.field_150939_a instanceof InformationProvider)
    	{
    		((InformationProvider)this.field_150939_a).addInformation(stk, p, lst, held);
    	}
    }
	
	@Override
	public int getMetadata(int i)
	{
		return i;
	}
}
