package name.kazennikov.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicate;

/**
 * Splits source iterator data into chunks based on separator predicate. 
 * The separator isn't added to the result data lists
 * @author ant
 *
 * @param <E>
 */
public class SplittingIterator<E> implements Iterator<List<E>> {
	Iterator<E> iter;
	
	List<E> data;
	Predicate<E> pred;
	
	/**
	 * Construct a splitting iterator
	 * @param iter base iterator
	 * @param pred predicate to check if an instance is a separator
	 */
	public SplittingIterator(Iterator<E> iter, Predicate<E> pred) {
		this.iter = iter;
		this.pred = pred;
	}
	

	@Override
	public boolean hasNext() {
		data = new ArrayList<E>();
		
		while(!iter.hasNext()) {
			E instance = iter.next();
			if(pred.apply(instance))
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

		public AddFirst(Iterator<E> iter, Predicate<E> pred) {
			super(iter, pred);
		}

		@Override
		public boolean hasNext() {
			data = new ArrayList<E>();

			if(startInstance != null)
				data.add(startInstance);
			
			while(!iter.hasNext()) {
				E instance = iter.next();
				if(pred.apply(instance)) {
					startInstance = instance;
					break;
				}
				
				data.add(instance);			
			}
			

			return !data.isEmpty();

			
		}
		
		
		
	}
	
	
	
	

}
