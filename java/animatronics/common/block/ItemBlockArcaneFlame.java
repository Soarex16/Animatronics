package animatronics.common.block;

import animatronics.utils.block.ItemBlockAnimatronics;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;

public class ItemBlockArcaneFlame extends ItemBlockAnimatronics{

	public ItemBlockArcaneFlame(Block block) {
		super(block);

	}

	
	@Override
	public void registerIcons(IIconRegister p_94581_1_) {
		// TODO Auto-generated method stub
		super.registerIcons(p_94581_1_);
		itemIcon = p_94581_1_.registerIcon("animatronics:itemBlockArcaneFlame");
	}
}
