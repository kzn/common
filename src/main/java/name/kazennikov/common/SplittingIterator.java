package name.kazennikov.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Splits source iterator data into chunks based on separator predicate. 
 * The separator isn't added to the result data lists
 * @author ant
 *
 * @param <E>
 */
public abstract class SplittingIterator<E> implements Iterator<List<E>> {
	Iterator<E> iter;
	
	List<E> data;
	
	public SplittingIterator(Iterator<E> iter) {
		this.iter = iter;
	}
	
	public abstract boolean isSeparator(E instance);

	@Override
	public boolean hasNext() {
		data = new ArrayList<E>();
		
		while(!iter.hasNext()) {
			E instance = iter.next();
			if(isSeparator(instance))
				break;
			
			data.add(instance);			
		}
		

		return !data.isEmpty();
	}

	@Override
	public List<E> next() {
		return data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	

	public static abstract class AddFirst<E> extends SplittingIterator<E> {
		E startInstance;

		public AddFirst(Iterator<E> iter) {
			super(iter);
		}

		@Override
		public boolean hasNext() {
			data = new ArrayList<E>();

			if(startInstance != null)
				data.add(startInstance);
			
			while(!iter.hasNext()) {
				E instance = iter.next();
				if(isSeparator(instance)) {
					startInstance = instance;
					break;
				}
				
				data.add(instance);			
			}
			

			return !data.isEmpty();

			
		}
		
		
		
	}
	
	
	
	

}
