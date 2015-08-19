package animatronics.api.mechanisms.modules;

public interface IMechanismModule {
	
	public abstract double getStability();
	public abstract double getMaxStability();
	public abstract double getMinStability();
	
	public abstract double getSpeedModifier();
	
	public abstract boolean worksAtDaytime();
	public abstract boolean worksAtNightime();
}
