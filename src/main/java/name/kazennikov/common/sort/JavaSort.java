package name.kazennikov.common.sort;

import cern.colt.Swapper;
import cern.colt.function.IntComparator;

/**
 * Generic sorting algorithm ported from JDK 7
 * @author Anton Kazennikov
 *
 */
public class JavaSort {
	public static void insertionSort(int from, int to, IntComparator c, Swapper s) {
		   for (int i = from; i < to; i++) {
			   for (int j = i; j > from && c.compare(j-1, j) > 0; j--) {
				   s.swap(j, j - 1);
			   }
		   }
	}
}
