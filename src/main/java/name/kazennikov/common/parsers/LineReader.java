package name.kazennikov.common.parsers;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


/**
 * Simple line oriented format parser
 * @author ant
 *
 */
public class LineReader implements Iterator<String>, Closeable {
	BufferedReader br;
	String s;
	
	public LineReader(Reader in) {
		this.br = new BufferedReader(in);
	}

	@Override
	public void close() throws IOException {
		br.close();
	}
	
	

	@Override
	public boolean hasNext() {
		try {
			s = br.readLine();
			if(s == null)
				return false;
			return true;

		} catch(IOException e) {
			return false;
		}
	}

	@Override
	public String next() {
		return s;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	
	
	

}
