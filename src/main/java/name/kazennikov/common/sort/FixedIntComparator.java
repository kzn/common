package name.kazennikov.common.sort;

import java.util.Comparator;

/**
 * Primitive version of {@link FixedComparator}. Typically used
 * to compare some indexed object with an object encoded in this comparator
 * 
 * Follows {link {@link Comparator} conventions
 * @author kazennikov
 *
 */
public interface FixedIntComparator {
	/**
	 * Compare and integer with an object encoded in this comparator
	 * @param i integer to compare
	 * @return 
	 */
	public int compare(int i);

}
