package name.kazennikov.common.sort;


public class IndexSort {
	
	public static int[] sort(double[] x) {
	    int[] ix = new int[x.length];
	    int[] scratch = new int[x.length];
	    for (int i = 0; i < ix.length; i++) {
	        ix[i] = i;
	    }
	    mergeSortIndexed(x, ix, scratch, 0, x.length - 1);
	    return ix;
	}

	private static void mergeSortIndexed(double[] x, int[] ix, int[] scratch, int lo, int hi) {
	    if (lo == hi)
	        return;
	    int mid = (lo + hi + 1) / 2;
	    mergeSortIndexed(x, ix, scratch, lo, mid - 1);
	    mergeSortIndexed(x, ix, scratch, mid, hi);
	    mergeIndexed(x, ix, scratch, lo, mid - 1, mid, hi);
	}

	private static void mergeIndexed(double[] x, int[] ix, int[] scratch, int lo1, int hi1, int lo2, int hi2) {
	    int i = 0;
	    int i1 = lo1;
	    int i2 = lo2;
	    int n1 = hi1 - lo1 + 1;
	    while (i1 <= hi1 && i2 <= hi2) {
	        if (x[ix[i1]] <= x[ix[i2]])
	            scratch[i++] = ix[i1++];
	        else
	            scratch[i++] = ix[i2++];
	    }
	    while (i1 <= hi1)
	        scratch[i++] = ix[i1++];
	    while (i2 <= hi2)
	        scratch[i++] = ix[i2++];
	    for (int j = lo1; j <= hi1; j++)
	        ix[j] = scratch[j - lo1];
	    for (int j = lo2; j <= hi2; j++)
	        ix[j] = scratch[(j - lo2 + n1)];
	}


}
