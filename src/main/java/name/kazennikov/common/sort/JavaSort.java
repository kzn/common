package name.kazennikov.common.sort;

/**
 * Generic sorting algorithm ported from JDK 7
 * @author Anton Kazennikov
 *
 */
public class JavaSort {
	public static void insertionSort(SortAdapter x, int off, int len) {
		   for (int i = off; i < len + off; i++) {
			   for (int j = i; j > off && x.compare(j-1, j) > 0; j--) {
				   x.swap(j, j-1);
			   }
		   }
	}
}
