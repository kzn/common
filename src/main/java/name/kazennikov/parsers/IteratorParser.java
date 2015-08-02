package name.kazennikov.parsers;

import java.util.Iterator;

/**
 * Transforms string iterator to object iterator
 * @author ant
 *
 * @param <E>
 */
public class IteratorParser<E> implements Iterator<E> {
	StringObjectParser<E> parser;
	Iterator<String> in;
	
	public IteratorParser(Iterator<String> in, StringObjectParser<E> parser) {
		this.parser = parser;
		this.in = in;
	}


	@Override
	public boolean hasNext() {
		return in.hasNext();
	}

	@Override
	public E next() {
		return parser.parse(in.next());
	}

	@Override
	public void remove() {
		in.remove();
	}
}
