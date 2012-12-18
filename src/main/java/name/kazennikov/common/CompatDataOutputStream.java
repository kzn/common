package name.kazennikov.common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * DataOutputStream that supports writing strings in UTF-8 format.
 * 
 * Strings are written in this format: [int] [utf-8 bytes], where [int] is an
 * integer size string length
 * @author ant
 *
 */
public class CompatDataOutputStream extends DataOutputStream {

	public CompatDataOutputStream(OutputStream out) {
		super(out);
	}
	
	/**
	 * Write string to the stream
	 * @param s string to write
	 * @throws IOException
	 */
	public void writeString(String s) throws IOException {
		writeInt(s.length());
		byte[] encoded = s.getBytes("UTF-8");
		
		write(encoded);
	}

}
