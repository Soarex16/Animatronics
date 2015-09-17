package animatronics.client.render;

import net.minecraft.util.AxisAlignedBB;
import animatronics.api.misc.Vector3;

public interface IBlockOutlineRenderingRequester {
	
	AxisAlignedBB getAABB();
	
	int getColor();
	
	Vector3 getPosition();
	
	float getThickness();
	
}
