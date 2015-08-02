package name.kazennikov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NGramStringIterator implements Iterator<String> {
	String src;
	int pos = 0;
	int n;
	
	public NGramStringIterator(String src, int n) {
		this.src = src;
		this.n = n;
		
	}

	@Override
	public boolean hasNext() {
		if(pos == 0) // at least one ngram
			return true;
		return pos + n <= src.length();
	}

	@Override
	public String next() {
		if(!hasNext())
			throw new NoSuchElementException();
		int end = Math.min(pos + n, src.length());
		String s = src.substring(pos, end);
		pos++;
		return s;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static Iterable<String> iterate(final String src, final int n) {
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return new NGramStringIterator(src, n);
			}
		};
	}

}
