package name.kazennikov.common;

public class MathUtils {

	/**
	 * Fast computation of 1/sqrt(x)
	 * @param x
	 * @return
	 */
	public static float invSqrt(float x){
		float xhalf = 0.5f * x;
		int i = Float.floatToIntBits(x); // store floating-point bits in integer
		i = 0x5f3759d5 - (i >> 1); // initial guess for Newton's method
		x = Float.intBitsToFloat(i); // convert new bits into float
		x = x*(1.5f - xhalf*x*x); // One round of Newton's method
		return x;
	}
	
	public static double invSqrt( double x ) {
	    double xhalf = ( double )0.5 * x;
	    long  i = Double.doubleToLongBits(x);
	    i = 0x5fe6ec85e7de30daL - (i >> 1);
	    x = Double.longBitsToDouble(i);
	    x = x * ( ( double )1.5 - xhalf * x * x );	    
	    return x;
	}


}
