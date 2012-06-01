package ru.iitp.proling.common.io.checked;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * java.util.Scanner like Line Reader. This reader assumes an end of input on IOException. 
 * If one wants to recover, one can get the most recent IOException by calling ioException() method
 * @author ant
 *
 */
public class LineReader implements Iterable<String>,Iterator<String>, Closeable {
	BufferedReader reader;
	String line;
	IOException e;
	
	public LineReader(Reader in) {
		reader = new BufferedReader(in);
	}

	@Override
	public boolean hasNext() {
		try {
			line = reader.readLine();
		} catch(IOException e) {
			this.e = e;
			return false;
		}
		return line != null;
	}

	@Override
	public String next() {
		if(line == null)
			throw new NoSuchElementException();
		return line;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<String> iterator() {
		return this;
	}

	@Override
	public void close() throws IOException {
		if(reader != null)
			reader.close();
	}
	
	public IOException ioException() {
		return e;
	}


}
