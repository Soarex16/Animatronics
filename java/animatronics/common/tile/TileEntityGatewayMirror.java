package animatronics.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityGatewayMirror extends TileEntity {
	
	@SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }

}
