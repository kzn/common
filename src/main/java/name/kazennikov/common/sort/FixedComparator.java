package name.kazennikov.common.sort;

import java.util.Comparator;

/**
 * Fixed comparator - returns comparison result with some other object 
 * directly encoded in the comparator.
 * 
 * Used in keyless binary search methods
 * @author Anton Kazennikov
 *
 * Follows {link {@link Comparator} conventions
 * @param <E>
 */
public interface FixedComparator<E> {
	/**
	 * Compares argument object with some other object directly encoded
	 * in this comparator
	 * 
	 * @param o object to compare
	 * 
	 * @return {@link Comparator} for return conventions, 
	 * -1 if given object is less, 0 if "equals", 1 if it is greater
	 */
	public int compare(E o);
}
