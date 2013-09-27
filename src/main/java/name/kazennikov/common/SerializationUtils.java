package name.kazennikov.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {
	public static <E> void writeObject(File f, E object) throws Exception {
		ObjectOutputStream s = null;
		try {
			s = new ObjectOutputStream(new FileOutputStream(f));
			s.writeObject(object);
		} finally {
			if(s != null)
				s.close();
		}
	}
	
	public static <E> E readObject(File f, Class<E> cls) throws Exception {
		ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(new FileInputStream(f));
			Object o = s.readObject();
			return cls.isAssignableFrom(cls)? cls.cast(o) : null;
		} finally {
			if(s != null)
				s.close();
		}
	}

	
	
	public static <E> E readObject(File f) throws Exception {
		ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(new FileInputStream(f));
			return (E) s.readObject();
		} finally {
			if(s != null)
				s.close();
		}
	}
	


}
