package animatronics.common.tile;

import java.awt.Color;

import animatronics.api.misc.Vector3;
import animatronics.client.render.IBlockOutlineRenderingRequester;
import animatronics.utils.handler.ClientTickHandler;
import animatronics.utils.misc.MiscUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityGatewayMirror extends TileEntity implements IBlockOutlineRenderingRequester{
	
	private AxisAlignedBB aabb;
	private Vector3 pos;
	
	public TileEntityGatewayMirror(){
		aabb = MiscUtils.boundingBoxFromTo(Vector3.fromTileEntity(this), Vector3.fromTileEntity(this).add(3));
		pos = Vector3.fromTileEntity(this);
	}
	
	public static double move;
	public static double back;
	
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
			if(move < 1) move+=0.01; 
			else if(back == 1) {
				move = 0;
				back = 0;
			} else back+=0.1;
		}
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }

	@Override
	public AxisAlignedBB getAABB() {
		return aabb;
	}

	@Override
	public int getColor() {
		return Color.HSBtoRGB(ClientTickHandler.ticksInGame % 200 / 200F, 0.6F, 1F);
	}

	@Override
	public Vector3 getPosition() {
		return pos;
	}

	@Override
	public float getThickness() {
		return 1f;
	}

}
