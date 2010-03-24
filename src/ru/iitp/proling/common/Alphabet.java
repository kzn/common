package ru.iitp.proling.common;

import gnu.trove.TObjectHashingStrategy;
import gnu.trove.TObjectIntHashMap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Fast mapper between Object <-> int. Is an enhanced HashSet.
 * elements indexes starts from 1, all values, less from 1 means invalid'  
 * @author ant
 *
 */
public class Alphabet<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2474726474895920764L;
	/**
	 * Current version of alphabet class
	 */
	
	protected TObjectIntHashMap<T> map;
	protected ArrayList<T> entries;
	
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
		return entries.get(i - 1);
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
		
		int retIndex = map.get(object);
		if(retIndex > 0)
			return retIndex;
		
		
		if(add){
			retIndex = entries.size() + 1;
			map.put(object, retIndex);
			entries.add(object);
		}
		
		return retIndex > 0? retIndex : -1;
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
		int i = 1;
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
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeObject(entries);
		
	}
	
	@SuppressWarnings("unchecked")
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		entries = (ArrayList<T>)ois.readObject();
		map = new TObjectIntHashMap<T>(entries.size());
		int i = 0;
		for(T entry : entries){
			map.put(entry, i++);
		}
	}
	/**
	 * Return entry list
	 * @return
	 */
	public List<T> entries(){
		return entries;
	}

}
