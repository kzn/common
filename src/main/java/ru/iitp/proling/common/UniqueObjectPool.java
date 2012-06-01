package ru.iitp.proling.common;

import java.util.HashMap;

/**
 * Unique hash set class. Used for storing and retrieving elements
 * from this set.
 * @author ant
 *
 * @param <T>
 */
public class UniqueObjectPool<T> {
	HashMap<T,T> internalMap = new HashMap<T, T>();
	
	/**
	 * Gets (and adds if absent) object from hash set
	 * @param object query object
	 * @return unique object 
	 */
	public T addget(final T object){
		if(internalMap.containsKey(object))
			return internalMap.get(object);
		
		internalMap.put(object, object);
		return object;
	}
	
	/**
	 * Add object to hash set 
	 * @param object
	 * @return true on successful adding, false if object already exists
	 */
	public boolean add(final T object){
		if(internalMap.containsKey(object))
			return false;
		internalMap.put(object, object);
		return true;
	}
	
	/**
	 * Check if hash set contains object
	 * @param object 
	 */
	public boolean contains(final T object){
		return internalMap.containsKey(object);
	}
	
	public int size(){
		return internalMap.size();
	}

}
