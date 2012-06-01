package ru.iitp.proling.common.parsers;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequenceReader<E> implements Iterator<List<E>>, Closeable {
	BufferedReader br;
	List<E> data;
	
	
	public SequenceReader(Reader in, StringObjectParser<E> parser) {
		br = new BufferedReader(in);
	}

	@Override
	public void close() throws IOException {
		br.close();
	}
	
	public String stripComment(String s) {
		int index = s.indexOf("##");
		if(index != -1)
			s = s.substring(0, index);
		
		return s;
	}

	@Override
	public boolean hasNext() {
		data = new ArrayList<E>();
		String s = null;
		try {
			do {
				s = br.readLine();
				if(s == null)
					break;
				
				if(s.isEmpty())
					return true;

				
				s = stripComment(s);
				if(s.isEmpty())
					continue;
				
			} while(s != null);
			
			return !data.isEmpty();
		} catch(IOException e) {
			return false;
		}
	}

	@Override
	public List<E> next() {
		return data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
