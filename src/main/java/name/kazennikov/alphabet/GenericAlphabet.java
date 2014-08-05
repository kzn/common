package name.kazennikov.alphabet;


import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.io.IOException;
import java.util.List;

public class GenericAlphabet {
	TLongIntHashMap internal = new TLongIntHashMap();
	TIntIntHashMap external = new TIntIntHashMap();
	TObjectIntHashMap<String> object = new TObjectIntHashMap<String>();
	boolean readOnly;
	
	public GenericAlphabet() {
	}
	
	public GenericAlphabet(int capacityInternal, int capacityExternal, int capacityObject) {
		internal.ensureCapacity(capacityInternal);
		external.ensureCapacity(capacityExternal);
		object.ensureCapacity(capacityObject);
	}
		

	public int get(Object s) {
		int val = 0;
		if(s instanceof List) {
			List<?> l = (List<?>) s;
			for(Object o : l) {
				int v1 = AlphabetUtils.get(object, readOnly, o.toString());
				val = AlphabetUtils.get(internal, readOnly, val, v1);
				
			}
			
		} else {
			val = AlphabetUtils.get(object, readOnly, s.toString());
		}
		
		return external(val);
	}
	
	public int external(int key) {
		return AlphabetUtils.get(external, readOnly, key);
	}
	
	public int internal(int key1, int key2) {
		return AlphabetUtils.get(internal, readOnly, key1, key2);
	}
	
	public int object(Object o) {
		return AlphabetUtils.get(object, readOnly, o.toString());
	}
	
	public int roll(int seed, Object o) {
		return internal(seed, object(o));
	}
	
	public int roll(Object s) {
		int val = 0;
		if(s instanceof List) {
			List<?> l = (List<?>) s;
			for(Object o : l) {
				int v1 = object(o);
				val = internal(val, v1);
			}
		} else {
			val = object(s);
		}

		return val;
	}

	public boolean contains(Object s) {
		int h = object(s);
		int v = external(h);
		return v != 0;
	}

	public boolean contains(int id) {
		return id < external.size();
	}

	public int size() {
		return external.size();
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}


	public String stats() {
		return String.format("generic stats: %d/%d/%d%n", object.size(), internal.size(), external.size());
	}
	
	public void write(String prefix) throws IOException {
		TStringWriters.write(prefix + ".internal", internal);
		TStringWriters.write(prefix + ".external", external);
		TStringWriters.write(prefix + ".object", object);
	}
	
	public void read(String prefix) throws IOException {
		internal = TStringReaders.readLongIntHashMap(prefix + ".internal");
		external = TStringReaders.readIntIntHashMap(prefix + ".external");
		object = TStringReaders.readObjectIntHashMap(prefix + ".object", new StringParser.Identity());
	}
	

	

}
