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
	public void registerIcons(IIconRegister ir) {
		super.registerIcons(ir);
		itemIcon = ir.registerIcon("animatronics:itemBlockArcaneFlame");
	}
}
