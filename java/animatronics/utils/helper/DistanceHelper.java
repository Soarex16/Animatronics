package animatronics.utils.helper;

import animatronics.utils.misc.Vector3;

public class DistanceHelper {
	
	private final float distance;
	
	public static double module(double a)
	{
		if(a < 0) a = -a;
		return a;
	}

	public static float getDifference(double pos1, double pos2)
	{
		double diff = pos1-pos2;
		return (float)module(diff);
	}
	
	public DistanceHelper()
	{
		distance = 0;
	}
	
	public DistanceHelper(Vector3 first, Vector3 second)
	{
		float diffX = getDifference(first.x, second.x);
		float diffY = getDifference(first.y, second.y);
		float diffZ = getDifference(first.z, second.z);
		distance = (float) Math.sqrt(diffX*diffX+diffY*diffY+diffZ*diffZ);
	}
	
	public DistanceHelper(float first, float second)
	{
		distance = getDifference(first, second);
	}
	
	public float getDistance()
	{
		return this.distance;
	}
	
	public static float getDifference(Vector3 first, Vector3 second){
		float diffX = getDifference(first.x, second.x);
		float diffY = getDifference(first.y, second.y);
		float diffZ = getDifference(first.z, second.z);
		return (float) Math.sqrt(diffX*diffX+diffY*diffY+diffZ*diffZ);
	}
}
