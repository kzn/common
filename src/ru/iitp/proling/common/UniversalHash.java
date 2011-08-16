package ru.iitp.proling.common;

public class UniversalHash {
	
	/**
	 * h_a(key) -> 2^dim bit universal hash function
	 * @param a
	 * @param key
	 * @param dim
	 * @return
	 */
	public static int hash(int a, int key, int dim) {
		int x = a * key;
		return (int)(x >>> (32 - dim));
		
	}

}
