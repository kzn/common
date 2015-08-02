package name.kazennikov.common;

import name.kazennikov.iterator.DoubleIterator;

import java.util.Arrays;

public class ArrayUtils {

    public static void swap(Object[] array, int i, int j) {
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
	
	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

    public static void swap(long[] array, int i, int j) {
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


    public static void swap(float[] array, int i, int j) {
        float t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
	
	
	public static void swap(double[] array, int i, int j) {
		double t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void swap(short[] array, int i, int j) {
		short t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void swap(byte[] array, int i, int j) {
		byte t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void swap(char[] array, int i, int j) {
		char t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	public static void shuffle(double[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}

	public static void shuffle(float[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}

	public static void shuffle(long[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}

	public static void shuffle(short[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}

	public static void shuffle(byte[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}
	
	public static void shuffle(int[] array, int active) {
		for(int i = 0; i != active; i++){
			int j = i + (int)(Math.random() * (active - i));
			swap(array, i, j);
		}
	}

	public static void shuffle(char[] array, int active) {
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

	public static int min(char[] array) {
		char min = Character.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}

	public static long min(long[] array) {
		long min = Long.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}

	public static short min(short[] array) {
		short min = Short.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}


	public static byte min(byte[] array) {
		byte min = Byte.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}

	public static float min(float[] array) {
		float min = Float.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}

	public static double min(double[] array) {
		double min = Float.MAX_VALUE;
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

	public static int minIndex(double[] array) {
		double min = Double.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int minIndex(short[] array) {
		short min = Short.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int minIndex(char[] array) {
		char min = Character.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int minIndex(byte[] array) {
		byte min = Byte.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}


	public static int minIndex(long[] array) {
		long min = Long.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int minIndex(float[] array) {
		float min = Float.MAX_VALUE;
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

	public static long max(long[] array) {
		long max = Long.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static short max(short[] array) {
		short max = Short.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static char max(char[] array) {
		char max = Character.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static byte max(byte[] array) {
		byte max = Byte.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static float max(float[] array) {
		float max = -Float.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static double max(double[] array) {
		double max = -Double.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static int maxIndex(byte[] array) {
		byte max = Byte.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	public static int maxIndex(short[] array) {
		short max = Short.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}


	public static int maxIndex(char[] array) {
		char max = Character.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
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

	public static int maxIndex(long[] array) {
		long max = Long.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	public static int maxIndex(float[] array) {
		float max = -Float.MAX_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	public static int maxIndex(double[] array) {
		double max = -Double.MAX_VALUE;
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
