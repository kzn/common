package name.kazennikov.common;

import java.io.Serializable;

public interface StringMapper extends Serializable{
	public int lookup(String string);
	public int size();
	public void write(String filename);
}
