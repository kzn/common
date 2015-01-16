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

    public static long sizeOf(Object object) {
        Unsafe unsafe = getUnsafe();
        return unsafe.getAddress( normalize( unsafe.getInt(object, 4L) ) + 12L );
    }

    public static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }
	
	public static void main(String[] args) {
		Unsafe unsafe = getUnsafe();
		
		System.out.printf("Unsafe page size: %d%naddress size: %d%n", unsafe.pageSize(), unsafe.addressSize());
	}

}
