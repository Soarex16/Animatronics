package animatronics.api.energy;

import java.util.UUID;

public interface ITEHasEntropy {
	
	public abstract int getEntropy();

	public abstract int getMaxEntropy();

	public abstract boolean setEntropy(int i);
	
	public abstract boolean setMaxEntropy(float f);
	
	public abstract UUID getUUID();

}
