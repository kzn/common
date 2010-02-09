package ru.iitp.proling.common;

public class HashUtils {
	
	/**
	 * Compute hash value from integer
	 * @param value to hash
	 * @return hash value
	 */
	public static int hashValue(int value){
		
        int seed = 0;
        
        long positive = value < 0 ? -1 - value : value;

           
        for(int i = 0; i != 31; i++)
        	seed ^=  (positive >>> i) + (seed<<6) + (seed>>2);
       
        
        seed ^=  value + (seed<<6) + (seed>>2);

        return seed;
	}
	
	/**
	 * Combine 2 hash values into new hash value
	 * @param seed initial hash value
	 * @param hash hash value of the new hashed object
	 * @return combined hash value
	 */
	public static int hashCombine(int seed, int hash){
		 return seed ^ (hash + 0x9e3779b9 + (seed<< 6) + (seed>>>2));
		
	}

}
