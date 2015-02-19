package name.kazennikov.alphabet;

import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Fast mapper between Object <-> int. Is an enhanced HashSet.
 * @author Anton Kazennikov
 *
 */
public class Alphabet<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	/**
	 * Current version of alphabet class
	 */
	
	TObjectIntHashMap<T> map;
	ArrayList<T> entries;
	boolean readOnly = false;
	private int startIndex;
	private int missingIndex;
	
	/**
	 * Create default alphabet
	 */
	public Alphabet(int startIndex, int missingIndex) {
		map = new TObjectIntHashMap<T>();
		entries = new ArrayList<T>();
		this.startIndex = startIndex;
		this.missingIndex = missingIndex;
	}
	
	public Alphabet(int startIndex) {
		this(startIndex, startIndex - 1);
	}
	
	public Alphabet(TObjectIntHashMap<T> map, int missingIndex) {
		this.missingIndex = missingIndex;
		this.map = map;
		
		this.entries = new ArrayList<T>(map.size());
		map.forEachValue(new TIntProcedure() {
			
			@Override
			public boolean execute(int value) {
				startIndex = Math.min(value, startIndex);
				return true;
			}
		});
		
		map.forEachEntry(new TObjectIntProcedure<T>() {

			@Override
			public boolean execute(T a, int b) {
				entries.set(b - startIndex, a);
				return true;
			}
		});
	}
	
	/**
	 * Default alphabet constructor. Index starts at 1, missing value = 0 
	 */
	public Alphabet() {
		this(1);
	}
	
	/**
	 * Get object at given index
	 * 
	 * @param i index in the alphabet
	 * @return object at index in the alphabet
	 */
	public T get(int i) {
		return entries.get(i - startIndex);
	}
	
	/**
	 * Get/add object to alphabet
	 * 
	 * @param object object to lookup
	 * @param add if true adds object to alphabet if missing
	 * 
	 * @return index of object, or missingIndex if not found
	 */
	public int get(final T object, boolean add) {
		if(object == null)
			throw new IllegalArgumentException ("Can't lookup \"null\" in an Alphabet.");
		
		int retIndex = map.get(object);
		
		if(retIndex != missingIndex)
			return retIndex;
		
		if(add) {
			retIndex = entries.size() + startIndex;
			map.put(object, retIndex);
			entries.add(object);
			return retIndex;
		}
		
		return missingIndex;
	}
	
	/**
	 * Simple get. By default, adds missing object
	 * @param object
	 * @return index of object
	 */
	public int get(final T object) {
		return get(object, true);
	}
	
	/**
	 * Get number of entries in the alphabet
	 * @return number of entries in the alphabet
	 */
	public int size() {
		return entries.size();
	}
	
	/**
	 * Convert alphabet object to String representation
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Alphabet:\n");
		int i = startIndex;
		
		for(T entry : entries) {
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
	public boolean contains(T object) {
		return map.contains(object);
	}
	
	public boolean contains(int index) {
		index -= startIndex;
		return index >= 0 && index < size();
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeInt(startIndex);
		oos.writeInt(missingIndex);
		oos.writeObject(entries);
		
	}
	
	@SuppressWarnings("unchecked")
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		startIndex = ois.readInt();
		missingIndex = ois.readInt(); 
		entries = (ArrayList<T>) ois.readObject();
		
		map = new TObjectIntHashMap<T>(entries.size());
		int i = startIndex;
		
		for(T entry : entries) {
			map.put(entry, i++);
		}
	}
	
	/**
	 * Return entry list
	 * @return
	 */
	public List<T> entries() {
		return entries;
	}
	
	public T entry(int index) {
		return entries.get(index - startIndex);
	}
	
	public int id(final T object) {
		return get(object, !readOnly);
	}
	
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Alphabet<T> read(String filename) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Alphabet<T> alphabet = (Alphabet<T>)ois.readObject();
		ois.close();
		fis.close();
		
		return alphabet;
	}
	
	public void write(String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		fos.close();
	}
	
	public void write(StringParser<T> parser, File fileName) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.append(String.format("%d\t%d\n", startIndex, missingIndex));
			
			for(T entry : entries) {
				writer.append(parser.serialize(entry));
				writer.newLine();
			}
		} 
	}


	public Alphabet<T> read(StringParser<T> parser, File fileName) throws IOException {
	
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			
			String s = null;
			s = reader.readLine();
			String[] header = s.split("\\t");
			startIndex = Integer.parseInt(header[0]);
			missingIndex = Integer.parseInt(header[1]);
			int counter = 1;
			
			while((s = reader.readLine()) != null) {
				T entry = parser.parse(s);
				map.put(entry, counter++);
				entries.add(entry);
			}
		}
		
		return this;
	}
}
