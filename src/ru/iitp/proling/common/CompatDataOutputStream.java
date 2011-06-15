package ru.iitp.proling.common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CompatDataOutputStream extends DataOutputStream {

	public CompatDataOutputStream(OutputStream out) {
		super(out);
	}
	
	public void writeString(String s) throws IOException {
		writeInt(s.length());
		byte[] encoded = s.getBytes("UTF-8");
		
		write(encoded);
	}

}
