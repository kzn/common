package name.kazennikov.parsers;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import name.kazennikov.common.StringTools;


/**
 * Parser for simple column based format like tabbed one
 * @author ant
 *
 */
public class SeparatorFormatParser implements Iterator<List<String>>, Closeable {
	BufferedReader br;
	char sep;
	
	public SeparatorFormatParser(Reader in, char sep) {
		br = new BufferedReader(in);
		this.sep = sep;
	}

	@Override
	public void close() throws IOException {
		br.close();
	}
	
	public String stripComments(String s) {
		int offset = s.indexOf("##");
		if(offset != -1)
			s = s.substring(0, offset);
		
		return s;
	}
	
	List<String> data;

	
	@Override
	public boolean hasNext() {
		try {
			String s = null;
			do {
				s = br.readLine();
				if(s == null) 
					return false;
				
				s = stripComments(s).trim();
				
				if(s.isEmpty())
					continue;
				
				data = StringTools.split(s, sep, false);
				return true;
				
				
			} while(s != null);
			
		} catch(IOException e) {
			return false;
		}
		
		return false;
	}

	@Override
	public List<String> next() {
		return data;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	

}
