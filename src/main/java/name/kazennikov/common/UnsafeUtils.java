package name.kazennikov.common;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeUtils {
	
	public static Unsafe getUnsafe() {
		try
		{
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe)field.get(null);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		Unsafe unsafe = getUnsafe();
		
		System.out.printf("Unsafe page size: %d%naddress size: %d%n", unsafe.pageSize(), unsafe.addressSize());
	}

}
