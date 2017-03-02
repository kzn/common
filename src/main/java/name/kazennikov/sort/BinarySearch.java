package name.kazennikov.sort;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

import cern.colt.function.IntComparator;

public class BinarySearch {
	
	private static final int BINARYSEARCH_THRESHOLD   = 5000;
	
	
	
	public static <T> int binarySearch(List<? extends T> l, int from, int to, FixedComparator<? super T> c) {
        if (l instanceof RandomAccess || l.size() < BINARYSEARCH_THRESHOLD)
            return indexedBinarySearch(l, from, to, c);
        else
            return iteratorBinarySearch(l, from, to, c);
	}
	
	public static <T> int binarySearch(List<? extends T> l, FixedComparator<? super T> c) {
		return binarySearch(l, 0, l.size(), c);
	}
	
    private static <T> int indexedBinarySearch(List<? extends T> l, int from, int to, FixedComparator<? super T> c) {
        int low = from;
        int high = to - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = l.get(mid);
            int cmp = c.compare(midVal);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
    
    public static <T> int binarySearch(T[] l, int from, int to, FixedComparator<? super T> c) {
        int low = from;
        int high = to - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = l[mid];
            int cmp = c.compare(midVal);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
    
    public static <T> int binarySearch(T[] l, FixedComparator<? super T> c) {
    	return binarySearch(l, 0, l.length, c);
    }


    private static <T> int iteratorBinarySearch(List<? extends T> l, int from, int to, FixedComparator<? super T> c) {
        int low = from;
        int high = to - 1;
        ListIterator<? extends T> i = l.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = get(i, mid);
            int cmp = c.compare(midVal);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
    
    /**
     * Gets the ith element from the given list by repositioning the specified
     * list listIterator.
     */
    private static <T> T get(ListIterator<? extends T> i, int index) {
        T obj = null;
        int pos = i.nextIndex();
        if (pos <= index) {
            do {
                obj = i.next();
            } while (pos++ < index);
        } else {
            do {
                obj = i.previous();
            } while (--pos > index);
        }
        return obj;
    }
    
    
    public static int binarySearch(int[] a, int from, int to, FixedIntComparator c) {
        int low = from;
        int high = to - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            int res = c.compare(midVal);

            if (res < 0)
                low = mid + 1;
            else if (res > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    
    public static int binarySearch(int[] a, FixedIntComparator c) {
    	return binarySearch(a, 0, a.length, c);
    }

    /**
     * Binary search.
     * Accepts int comparator c(x) that compares element at x-th position with target element
     * c(x) < 0 means that x-th element is less than target,
     * c(x) = 0: x-th element equals to target
     * c(x) > 0: x-th element greater than target
     *
     *
     * @param from start range
     * @param to end range
     * @param c comparator c(index) - how elem at index compares with target
     * @return
     */
    public static int binarySearch(int from, int to, FixedIntComparator c) {
        int low = from;
        int high = to - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int res = c.compare(mid);

            if (res < 0)
                low = mid + 1;
            else if (res > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.

    }
    
    /**
     * Find lowest index (including) such that a[x] == a[i]
     * i.e. find index of the first equal element
     * 
     * @param x base element
     * @param limit lower limit (including)
     * @param c comparator
     * 
     * @return
     */
    public static int floor(int x, int limit, IntComparator c) {
    	int x0 = x;
    	
    	while(x >= limit) {
    		if(c.compare(x0, x) != 0)
    			break;
    		x--;
    	}
    	return x;
    }
    
    public <T> int floor(List<? extends T> l,  int x, int limit, Comparator<? super T> c) {
    	T key =  l.get(x);
    	
    	while(x >= limit) {
    		if(c.compare(key, l.get(x)) != 0)
    			break;
    		x--;
    	}
    	
    	return x;
    }
    
    public <T> int floor(List<? extends T> l,  int x, int limit, FixedComparator<? super T> c) {
    	while(x >= limit) {
    		if(c.compare(l.get(x)) != 0)
    			break;
    		x--;
    	}
    	
    	return x;
    }
    
    public <T> int floor(T[] l,  int x, int limit, Comparator<? super T> c) {
    	T key =  l[x];
    	
    	while(x >= limit) {
    		if(c.compare(key, l[x]) != 0)
    			break;
    		x--;
    	}
    	
    	return x;
    }
    
    public <T> int floor(T[] l,  int x, int limit, FixedComparator<? super T> c) {
    	while(x >= limit) {
    		if(c.compare(l[x]) != 0)
    			break;
    		x--;
    	}
    	
    	return x;
    }



    
    /**
     * Find highest index (excluding) such that a[x] == a[i]
     * i.e. find index of nearest greater element
     * 
     * @param x base element
     * @param limit upper limit (excluding)
     * @param c comparator
     * 
     * @return
     */
    public static int ceiling(int x, int limit, IntComparator c) {
    	int x0 = x;
    	
    	while(x < limit) {
    		if(c.compare(x0, x) != 0)
    			break;
    		x++;
    	}
    	return x;
    }
    
    public static <T> int ceiling(List<? extends T> l,  int x, int limit, Comparator<? super T> c) {
    	T key = l.get(x);
    	
    	while(x < limit) {
    		if(c.compare(key, l.get(x)) != 0)
    			break;
    		x++;
    	}
    	return x;
    }
    
    public static <T> int ceiling(List<? extends T> l,  int x, int limit, FixedComparator<? super T> c) {
    	
    	while(x < limit) {
    		if(c.compare(l.get(x)) != 0)
    			break;
    		x++;
    	}
    	return x;
    }

    
    public static <T> int ceiling(T[] l,  int x, int limit, Comparator<? super T> c) {
    	T key = l[x];
    	
    	while(x < limit) {
    		if(c.compare(key, l[x]) != 0)
    			break;
    		x++;
    	}
    	return x;
    }
    
    public static <T> int ceiling(T[] l,  int x, int limit, FixedComparator<? super T> c) {
    	
    	while(x < limit) {
    		if(c.compare(l[x]) != 0)
    			break;
    		x++;
    	}
    	return x;
    }
}
