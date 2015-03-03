package animatronica.utils.helper;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/** 
 * @author SpaceToad
 */
public class Position{

	public double x, y, z;

	public ForgeDirection orientation;

	public Position(){
		x = 0;
		y = 0;
		z = 0;
		orientation = ForgeDirection.UNKNOWN;
	}

	public Position(double ci, double cj, double ck){
		x = ci;
		y = cj;
		z = ck;
		orientation = ForgeDirection.UNKNOWN;
	}

	public Position(double ci, double cj, double ck, ForgeDirection corientation){
		x = ci;
		y = cj;
		z = ck;
		orientation = corientation;
		if(orientation == null){
			orientation = ForgeDirection.UNKNOWN;
		}
	}

	public Position(Position p){
		x = p.x;
		y = p.y;
		z = p.z;
		orientation = p.orientation;
	}

	public Position(TileEntity tile){
		x = tile.xCoord;
		y = tile.yCoord;
		z = tile.zCoord;
		orientation = ForgeDirection.UNKNOWN;
	}

	public void moveRight(double step){
		switch(orientation){
		case SOUTH:
			x -= step;
			break;
		case NORTH:
			x += step;
			break;
		case EAST:
			z += step;
			break;
		case WEST:
			z -= step;
			break;
		default:
			break;
		}
	}

	public void moveLeft(double step){
		moveRight(-step);
	}

	public void moveForwards(double step){
		switch(orientation){
		case UP:
			y += step;
			break;
		case DOWN:
			y -= step;
			break;
		case SOUTH:
			z += step;
			break;
		case NORTH:
			z -= step;
			break;
		case EAST:
			x += step;
			break;
		case WEST:
			x -= step;
			break;
		default:
			break;
		}
	}

	public void moveBackwards(double step){
		moveForwards(-step);
	}

	public void moveUp(double step){
		switch(orientation){
		case SOUTH:
		case NORTH:
		case EAST:
		case WEST:
			y += step;
			break;
		default:
			break;
		}
	}

	public void moveDown(double step){
		moveUp(-step);
	}

	public String toString(){
		return "Coordinates: {" + x + ", " + y + ", " + z + "}";
	}

	public Position min(Position p){
		return new Position(p.x > x ? x : p.x, p.y > y ? y : p.y, p.z > z ? z : p.z);
	}

	public Position max(Position p){
		return new Position(p.x < x ? x : p.x, p.y < y ? y : p.y, p.z < z ? z : p.z);
	}

	public boolean isClose(Position newPosition, float distance){
		double dx = x - newPosition.x;
		double dy = y - newPosition.y;
		double dz = z - newPosition.z;
		double sqrDis = dx * dx + dy * dy + dz * dz;
		return !(sqrDis > distance * distance);
	}
}
