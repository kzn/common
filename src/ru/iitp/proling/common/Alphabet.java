package ru.iitp.proling.common;

import gnu.trove.TObjectHashingStrategy;
import gnu.trove.TObjectIntHashMap;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Fast mapper between Object <-> int. Is an enhanced HashSet  
 * @author ant
 *
 */
public class Alphabet<T> implements Serializable{
	/**
	 * Current version of alphabet class
	 */
	private static final long serialVersionUID = 1L;
	protected final TObjectIntHashMap<T> map;
	protected final ArrayList<T> entries;
	
	/**
	 * Create empty Alphabet object 
	 * @param capacity initial capacity of Alphabet object
	 * @param zeroObject default(empty) object in the Alphabet
	 */
	public Alphabet(final T zeroObject){
		this();
		entries.add(zeroObject);
		map.put(zeroObject, 0);
	}
	
	/**
	 * Create default alphabet
	 */
	public Alphabet(){
		map = new TObjectIntHashMap<T>();
		entries = new ArrayList<T>();
	}
	
	/**
	 * Create empty Alphabet this custom object hash strategy
	 * @param hashingStrategy
	 */
	public Alphabet(TObjectHashingStrategy<T> hashingStrategy){
		map = new TObjectIntHashMap<T>(hashingStrategy);
		entries = new ArrayList<T>();
	}
	
	/**
	 * Get object at index
	 * @param i index in the alphabet
	 * @return object at index in the alphabet
	 */
	public T get(int i){
		return entries.get(i);
	}
	
	/**
	 * Get/add object to alphabet
	 * @param object object to lookup
	 * @param add if true adds object to alphabet if missing
	 * @return index of object, or -1 if not found
	 */
	public int get(final T object, boolean add){
		if(object == null)
			throw new IllegalArgumentException ("Can't lookup \"null\" in an Alphabet.");
		
		int retIndex = -1;
		if(map.containsKey(object)) {
				retIndex = map.get(object);
			}
		else if (add) {
			retIndex = entries.size();
			map.put(object, retIndex);
			entries.add(object);
		}
		
		return retIndex;
	}
	
	/**
	 * Simple get. By default, adds missing object
	 * @param object
	 * @return index of object
	 */
	public int get(final T object){
		return get(object, true);
	}
	
	/**
	 * Get number of entries in the alphabet
	 * @return number of entries in the alphabet
	 */
	public int size(){
		return entries.size();
	}
	
	/**
	 * Convert alphabet object to String representation
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Alphabet:\n");
		int i = 0;
		for(T entry : entries){
			sb.append(entry.toString());
			sb.append(" <=> ");
			sb.append(i++);
			sb.append("\n");
		}
		
		
		return sb.toString();
	}
	
	
	/**
	 * Check if object is in the alphabet
	 * @param object object to check
	 */
	public boolean contains(T object){
		return map.contains(object);
	}

}
