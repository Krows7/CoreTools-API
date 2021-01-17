package net.coretools.core;

/**
 * 
 * The MathTools class contains various numbers and computing methods for comfort developing. 
 * 
 * @author Krows
 * 
 * @since 1.0.0 (old: 1.0)
 *
 */
public final class MathTools {
	
/**
 * 
 * Closed constructor.
 * 
 */
	private MathTools() {
		
	}
	
/**
 * 
 * Divides two integer numbers and returns result.
 * 
 * @param i First integer number.
 * @param j Second integer number.
 * 
 * @return Result of dividing.
 * 
 */
	public static double divide(int i, int j) {
		
		double result = (double) i / (double) j;
		
		return result == - 0.0 ? 0.0 : result;
	}
	
/**
 * 
 * Divides two long numbers and returns result.
 * 
 * @param i First long number.
 * @param j Second long number.
 * 
 * @return Result of dividing.
 * 
 */
	public static double divide(long i, long j) {
		
		double result = (double) i / (double) j;
		
		return result == - 0.0 ? 0.0 : result;
	}
	
/**
 * 
 * Returns module of the double value.
 * 
 * @param num Double value to module.
 * 
 * @return Double module.
 * 
 */
	public static double mod(double num) {
		
		return num < 0.0 ? - num : num;
	}
	
/**
 * 
 * Returns module of the float value.
 * 
 * @param num Float value to module.
 * 
 * @return Float module.
 * 
 */
	public static float mod(float num) {
		
		return num < 0.0f ? - num : num;
	}
	
/**
 * 
 * Returns module of the integer value.
 * 
 * @param num Integer value to module.
 * 
 * @return Integer module.
 * 
 */
	public static int mod(int num) {
		
		return num < 0 ? - num : num;
	}
	
/**
 * 
 * Returns module of the long value.
 * 
 * @param num Long value to module.
 * 
 * @return Long module.
 * 
 */
	public static long mod(long num) {
		
		return num < 0L ? - num : num;
	}
	
/**
 * 
 * Returns the smaller of two double values by them modules.
 * 
 * @param i First number.
 * @param j Second number.
 * 
 * @return The smaller of two double values by them modules.
 *
 */
	public static double minMod(double i, double j) {
		
		return mod(i) < mod(j) ? i : j;
	}
	
/**
 * 
 * Returns the smaller of two float values by them modules.
 * 
 * @param i First number.
 * @param j Second number.
 * 
 * @return The smaller of two float values by them modules.
 *
 */
	public static double minMod(float i, float j) {
		
		return mod(i) < mod(j) ? i : j;
	}
	
/**
 * 
 * Returns the smaller of two integer values by them modules.
 * 
 * @param i First number.
 * @param j Second number.
 * 
 * @return The smaller of two integer values by them modules.
 *
 */
	public static int minMod(int i, int j) {
		
		return mod(i) < mod(j) ? i : j;
	}
	
/**
 * 
 * Returns the smaller of two long values by them modules.
 * 
 * @param i First number.
 * @param j Second number.
 * 
 * @return The smaller of two long values by them modules.
 *
 */
	public static double minMod(long i, long j) {
		
		return mod(i) < mod(j) ? i : j;
	}
	
/**
 * 
 * Returns the greater of two double values by them modules.
 * 
 *  @param i First number.
 *  @param j Second number.
 *  
 *  @return The greater of two double values by them modules.
 *
 */
	public static double maxMod(double i, double j) {
		
		return mod(j) < mod(i) ? i : j;
	}
	
/**
 * 
 * Returns the greater of two integer values by them modules.
 * 
 *  @param i First number.
 *  @param j Second number.
 *  
 *  @return The greater of two integer values by them modules.
 *
 */
	public static double maxMod(int i, int j) {
			
		return mod(j) < mod(i) ? i : j;
	}
	
/**
 * 
 * Returns the greater of two long values by them modules.
 * 
 *  @param i First number.
 *  @param j Second number.
 *  
 *  @return The greater of two long values by them modules.
 *
 */
	public static double maxMod(long i, long j) {
		
		return mod(j) < mod(i) ? i : j;
	}
	
/**
 * 
 * Returns specified double value with the same sign that and second value.
 * 
 * @param num Returning double value to change sign.
 * @param sign Double value with needed sign.
 * 
 * @return Double value with the same sign that and second value.
 *
 */
	public static double simSign(double num, double sign) {
		
		return sign < 0.0 ? num < 0.0 ? num : - num : num < 0.0 ? - num : num;
	}
	
/**
 * 
 * Returns specified float value with the same sign that and second value.
 * 
 * @param num Returning float value to change sign.
 * @param sign Float value with needed sign.
 * 
 * @return Float value with the same sign that and second value.
 *
 */
	public static double simSign(float num, float sign) {
		
		return sign < 0.0f ? num < 0.0f ? num : - num : num < 0.0f ? - num : num;
	}
	
/**
 * 
 * Returns specified integer value with the same sign that and second value.
 * 
 * @param num Returning integer value to change sign.
 * @param sign Integer value with needed sign.
 * 
 * @return Integer value with the same sign that and second value.
 *
 */
	public static double simSign(int num, int sign) {
			
		return sign < 0 ? num < 0 ? num : - num : num < 0 ? - num : num;
	}
	
/**
 * 
 * Returns specified long value with the same sign that and second value.
 * 
 * @param num Returning long value to change sign.
 * @param sign Long value with needed sign.
 * 
 * @return Long value with the same sign that and second value.
 *
 */
	public static double simSign(long num, long sign) {
		
		return sign < 0L ? num < 0L ? num : - num : num < 0L ? - num : num;
	}
	
/**
 * 
 * Returns value difference of two double numbers.
 * (Numbers can be one of three values: positive value, negative value or zero). 
 * 
 * @param first First double number.
 * @param second Second double number.
 * 
 * @return True if numbers have different values, otherwise returns false.
 * 
 */
	public static boolean isOtherValues(double first, double second) {
		
		return second > first || first > second;
	}
	
/**
 * 
 * Returns whether the specified double is round or not. Double number is round if it hasn't fraction (equivalent of integer).
 * 
 * @param n Double number to round check.
 * 
 * @return True if double number is round. Otherwise returns false.
 *
 */
	public static boolean isRound(double n) {
		
		return n - (int) n == 0.0;
	}
	
/**
 * 
 * Returns whether the specified float is round or not. Float number is round if it hasn't fraction (equivalent of integer).
 * 
 * @param n Float number to round check.
 * 
 * @return True if float number is round. Otherwise returns false.
 *
 */
	public static boolean isRound(float n) {
		
		return n - (int) n == 0.0;
	}
	
/**
 * 
 * Returns value difference of two integer numbers.
 * (Numbers can be one of three values: positive value, negative value or zero). 
 * 
 * @param first First integer number.
 * @param second Second integer number.
 * 
 * @return True if numbers have different values, otherwise returns false.
 * 
 */
	public static boolean isOtherValues(int first, int second) {
		
		return second > first || first > second;
	}
	
/**
 * 
 * Returns value difference of two long numbers.
 * (Numbers can be one of three values: positive value, negative value or zero). 
 * 
 * @param first First long number.
 * @param second Second long number.
 * 
 * @return True if numbers have different values, otherwise returns false.
 * 
 */
	public static boolean isOtherValues(long first, long second) {
		
		return second > first || first > second;
	}
	
	public static boolean isNumber(String s) {
		
		try {
			
			Double.valueOf(s);
		} catch(NumberFormatException e) {
			
			return false;
		}
		
		return true;
	}
	
	public static double sin(double a) {
		
		return Math.sin(Math.toRadians(a));
	}
	
	public static double map(double value, double min, double max) {
		
		return value < min ? min : value > max ? max : value;
	}
	
	public static double map(double value, double min, double max, double minValue, double maxValue) {
		
		return map(minValue + ((value - min) * (maxValue - minValue)) / (max - min), minValue, maxValue);
	}
}