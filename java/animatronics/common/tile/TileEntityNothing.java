package animatronics.common.tile;

import animatronics.api.misc.Vector3;
import animatronics.utils.misc.MiscUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityNothing extends TileEntity {
	
	public boolean canUpdate() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return MiscUtils.boundingBoxFromTo(Vector3.fromTileEntity(this), Vector3.fromTileEntity(this).add(1));
    }
	
}
