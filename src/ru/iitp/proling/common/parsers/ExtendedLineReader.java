package ru.iitp.proling.common.parsers;

import java.io.IOException;
import java.io.Reader;

public class ExtendedLineReader extends LineReader {

	public ExtendedLineReader(Reader in) {
		super(in);
	}
	
	public String stripComment(String s) {
		int index = s.indexOf("##");
		if(index != -1)
			s = s.substring(0, index);
		
		return s;
	}

	@Override
	public boolean hasNext() {
		try {
			do {
				s = br.readLine();
				if(s == null)
					break;
				
				s = stripComment(s);

				if(s.isEmpty())
					continue;
				
				return true;
				
			} while(s != null);
		} catch(IOException e) {
			return false;
		}
		
		return false;
	}

	@Override
	public String next() {
		return s;
	}
}
