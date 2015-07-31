package animatronics.utils.misc;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import net.minecraft.block.Block;

import com.google.common.annotations.Beta;
import com.google.gson.internal.Primitives;

public class ReflectionUtils{
			
	/**
	 * @author Agravaine
	 * 
	 * Does not work with arrays of primitives(int[], double[], etc)
	 */
	@Beta
	public static void increaseArray(Class<?> clazz, int length, String... args){
		Object[] oldArray = null;
		for(Field field : clazz.getDeclaredFields()){
			try{
				for(String s : args){
					if(field.getName().equals(s)){
						field.setAccessible(true);
						if(Modifier.isFinal(field.getModifiers())){
							Field modfield = Field.class.getDeclaredField("modifiers");
							modfield.setAccessible(true);
							modfield.setInt(field, field.getModifiers() & ~Modifier.FINAL);
						}
						oldArray = (Object[])field.get(null);
						Object newArray = Array.newInstance(field.get(null).getClass().getComponentType(), length);
						System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
						field.set(null, newArray);
					}
				}
			}catch(ReflectiveOperationException e){
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isObfuscation(){
		try{
			Field field = Block.class.getDeclaredField("blockResistance");
			return true;
		}catch(ReflectiveOperationException e){
			return false;
		}
	}
}
