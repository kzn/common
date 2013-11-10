package name.kazennikov.common;

public class ArrayUtils {
	
	public static void swap(int[] array, int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	
	public static void swap(double[] array, int i, int j){
		double t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	public static void shuffle(double[] array, int active){
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}
	
	public static void shuffle(int[] array, int active){
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}
	
	public static int min(int[] array) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	public static int minIndex(int[] array) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}

	
	public static int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	public static int maxIndex(int[] array) {
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}

	

}
