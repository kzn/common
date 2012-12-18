package name.kazennikov.common;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;


/**
 * Parser of simple line-oriented format where fields are separated by a single character separator
 * This parser doesn't support comments or blank lines.
 * Any line is treated as a data carrier
 * @author ant
 *
 */
public class TSVSimpleParser implements Iterator<List<String>>, Closeable {
	char sep;
	BufferedReader reader;
	List<String> current;
	
	public TSVSimpleParser(Reader r, char sep) {
		reader = new BufferedReader(r);
		this.sep = sep;
	}
	
	

	@Override
	public void close() throws IOException {
		reader.close();
	}

	@Override
	public boolean hasNext() {
		String s = null;
		try {
			s = reader.readLine();

			if(s == null)
				return false;

			current = StringTools.split(s, sep, false);
			return true;

		} catch(IOException e) {
			return false;
		}
	}

	@Override
	public List<String> next() {
		return current;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
