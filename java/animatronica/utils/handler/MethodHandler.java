package animatronica.utils.handler;

import net.minecraft.world.World;
import animatronica.Animatronica;

public class MethodHandler implements IParticleHandler {


	@Override
	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m) {
		Animatronica.proxy.sparkleFX(world, x, y, z, r, g, b, size, m);
	}
	
}
