package ru.iitp.proling.common;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface MapList<K, V> {
	
	public List<V> get(K key);
	public void put(K key, V value);
	public void putAll(K key, List<V> values);
	public int size();
	
	public Set<K> keySet();
	public Collection<List<V>> values();
	public boolean contains(K key);

	
	
	
}
