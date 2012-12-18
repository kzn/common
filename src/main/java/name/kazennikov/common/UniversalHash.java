package name.kazennikov.common;

public class UniversalHash {
	
	/**
	 * h_a(key) -> 2^dim bit universal hash function
	 * @param a
	 * @param key
	 * @param dim
	 * @return
	 */
	public static int hash32(int a, int key, int dim) {
		int x = a * key;
		return (int)(x >>> (31 - dim));
	}
	
	public static long hash64(long a, long key, int dim) {
		long x = a * key;
		return (long)(x >>> (63 - dim));
	}

}
