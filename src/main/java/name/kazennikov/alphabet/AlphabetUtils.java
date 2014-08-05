package name.kazennikov.alphabet;

import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;


public class AlphabetUtils {
	
	public static int get(TLongIntHashMap map, boolean readOnly, int key1, int key2) {
		long key = key1;
		key <<= 32;
		key += key2;
		
		int val = map.get(key);
		if(val == 0 && !readOnly) {
			val = map.size() + 1;
			map.put(key, val);
		}
		
		return val;
	}
	
	public static int get(TIntIntHashMap map, boolean readOnly, int key) {
		int v = map.get(key);
		if(v == 0 && !readOnly) {
			v = map.size() + 1;
			map.put(key, v);
		}
		
		return v;
	}

	public static <E> int get(TObjectIntHashMap<E> map, boolean readOnly, E key) {
		int val = map.get(key);
		if(val == 0 && !readOnly) {
			val = map.size() + 1;
			map.put(key, val);
		}
		
		return val;
	}
}
