package ru.iitp.proling.common;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * DataInputStream that supports reading UTF-8 strings from the stream.
 * Format is: [int length] [utf-8 bytes]
 * @author ant
 *
 */
public class CompatDataInputStream extends DataInputStream {

	public CompatDataInputStream(InputStream in) {
		super(in);
	}
	
	
	/**
	 * Read string from the stream. Format is [int] [utf-8 bytes]
	 * @return resulting stream
	 * @throws IOException
	 * @throws EOFException
	 */
	public String readString() throws IOException, EOFException {
		int len = readInt();
		
		byte[] bytes = new byte[len];
		readFully(bytes);
		
		return new String(bytes, "UTF-8");
	}

}
