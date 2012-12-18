package name.kazennikov.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GenericMapList<K,V> implements MapList<K, V> {
	
	public interface ListMaker<V> {
		public List<V> make();
	}
	
	public interface MapMaker<K,V> {
		public Map<K, List<V>> make();
	}
	
	Map<K, List<V>> map = new HashMap<K, List<V>>();
	
	public GenericMapList() {
	}

	@Override
	public List<V> get(K key) {
		return map.get(key);
	}

	@Override
	public void put(K key, V value) {
		List<V> l = map.get(key);

		if(l == null) {
			l = new ArrayList<V>();
			map.put(key, l);
		}
		
		l.add(value);
		
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<List<V>> values() {
		return map.values();
	}

	@Override
	public boolean contains(K key) {
		return map.containsKey(key);
	}
	
	public List<V> valueMaker() {
		return new ArrayList<V>();
	}
	
	public Map<K, List<V>> mapMaker() {
		return new HashMap<K, List<V>>();
	}

	@Override
	public void putAll(K key, List<V> values) {
		for(V value : values)
			put(key, value);
	}
}
