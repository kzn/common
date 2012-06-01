package ru.iitp.proling.common.io.unchecked;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineReader implements Closeable, Iterable<String>, Iterator<String> {
	BufferedReader reader;
	String line;
	
	public LineReader(Reader in) {
		reader = new BufferedReader(in);
	}

	@Override
	public boolean hasNext() {
		try {
			line = reader.readLine();
		} catch(IOException e) {
			throw new RuntimeIOException(e);
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
}
