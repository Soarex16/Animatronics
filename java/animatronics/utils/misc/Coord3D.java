package animatronics.utils.misc;

public class Coord3D {
	
	public static float x;
	public static float y;
	public static float z;
	
	public Coord3D(double posX, double posY, double posZ)
	{
		this.x = (float) posX;
		this.y = (float) posY;
		this.z = (float) posZ;
	}
	
	public Coord3D(float i, float k, float j)
	{
		this.x = i;
		this.y = k;
		this.z = j;
	}
	
	public Coord3D()
	{
		this(0,0,0);
	}
	
	public static float[] toArray()
	{	
		float array [] = {x,y,z};
		return array;
	}
}
