package ru.iitp.proling.common;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class CompatDataInputStream extends DataInputStream {

	public CompatDataInputStream(InputStream in) {
		super(in);
	}
	
	public String readString() throws IOException, EOFException {
		int len = readInt();
		
		byte[] bytes = new byte[len];
		readFully(bytes);
		
		return new String(bytes, "UTF-8");
	}

}
