package name.kazennikov.common;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Objects;

/**
 * List utilities
 * @author Anton Kazennikov
 *
 */
public class ListUtils {

	/**
	 * Find largest group in a sorted list
	 * 
	 * @param src source sorted list
	 * @param pred predicate to check equality of two values
	 * 
	 * @return largest group of elements with same aggregate value
	 */
	public static <T> List<T> largestGroup(List<T> src, EqualityPredicate<T> pred) {
		List<T> largest = null;
		int largestSize = 0;
		List<T> current = new ArrayList<>();
		T prev = null;
		
		for(int i = 0; i < src.size(); i++) {
			T curr = src.get(i);
			
			if(prev != null && pred.equals(prev, curr)) {
				if(current.size() > largestSize) {
					largest = current;
					current = new ArrayList<>();
					largestSize = largest.size();
				} else {
					current.clear();
				}
			}
			
			current.add(curr);
			prev = curr;
		}
		
		if(current.size() > largestSize) {
			largest = current;
			current = new ArrayList<>();
			largestSize = largest.size();
		}
		
		return largest;
	}
	
	
	/**
	 * Find largest group in a sorted list
	 * 
	 * @param src source sorted list
	 * @param pred grouping predicate
	 * 
	 * @return largest group of elements with same aggregate value
	 */
	public static <T, F> List<T> largestGroup(List<T> src, Function<T, F> pred) {
		List<T> largest = null;
		int largestSize = 0;
		List<T> current = new ArrayList<>();
		F prevVal = null;
		
		for(int i = 0; i < src.size(); i++) {
			T curr = src.get(i);
			F curVal = pred.apply(curr);
			
			if(Objects.equal(prevVal, curVal)) {
				if(current.size() > largestSize) {
					largest = current;
					current = new ArrayList<>();
					largestSize = largest.size();
				} else {
					current.clear();
				}
			}
			
			current.add(curr);
			prevVal = curVal;
		}
		
		if(current.size() > largestSize) {
			largest = current;
			current = new ArrayList<>();
			largestSize = largest.size();
		}
		
		return largest;
	}

	
	/**
	 * Return a list of grouped values
	 * 
	 * @param src input sorted list
	 * @param pred predicate to check equality of two values
	 * 
	 * @return list of grouped values
	 */
	public static <T> List<List<T>> groupBy(List<T> src, EqualityPredicate<T> pred) {
		List<List<T>> res = new ArrayList<>();
		List<T> current = new ArrayList<>();
		T prev = null;
		
		for(int i = 0; i < src.size(); i++) {
			T curr = src.get(i);
			
			if(prev != null && pred.equals(prev, curr)) {
				res.add(current);
				current = new ArrayList<>();
			}
			
			current.add(curr);
			prev = curr;
		}
		
		res.add(current);
		
		return res;
	}
	
	/**
	 * Return a list of grouped values
	 * 
	 * @param src input sorted list
	 * @param pred grouping predicate
	 * 
	 * @return list of grouped values
	 */
	public static <T, F> List<List<T>> groupBy(List<T> src, Function<T, F> pred) {
		List<List<T>> res = new ArrayList<>();
		List<T> current = new ArrayList<>();
		F prevVal = null;
		
		for(int i = 0; i < src.size(); i++) {
			T curr = src.get(i);
			F curVal = pred.apply(curr);
			
			if(Objects.equal(prevVal, curVal)) {
				res.add(current);
				current = new ArrayList<>();
			}
			
			current.add(curr);
			prevVal = curVal;
		}
		
		res.add(current);
		
		return res;
	}

	

}
