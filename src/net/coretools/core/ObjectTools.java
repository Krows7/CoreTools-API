package net.coretools.core;

import static net.coretools.core.ArrayTools.predicate;
import static net.coretools.core.ArrayTools.predicateByte;
import static net.coretools.core.ArrayTools.predicateChar;
import static net.coretools.core.ArrayTools.predicateDouble;
import static net.coretools.core.ArrayTools.predicateFloat;
import static net.coretools.core.ArrayTools.predicateInt;
import static net.coretools.core.ArrayTools.predicateLong;
import static net.coretools.core.ArrayTools.predicateShort;

import java.util.Random;
import java.util.function.Function;

/**
 * 
 * ObjectTools class contains methods for working with objects. In most cases these methods comparing or changing objects.
 * 
 * @author Krows
 * 
 * @since 1.0.0 (old: 1.0)
 *
 */
public final class ObjectTools {
	
/**
 * 
 * Closed constructor.
 * 
 */
	private ObjectTools() {
		
	}
	
/**
 * 
 * Compares specified object with array and returns true if the object is contained in the array.
 * 
 * @param object Object which can be contained in the array.
 * @param objects Object array.
 * 
 * @return True if object is contained in the array, otherwise false.
 * 
 */
	public static boolean containsObject(Object object, Object... objects) {
		
		return predicate(objects, o -> o == object);
	}
	
/**
 * 
 * Compares specified {@link String} object with array and returns true if string is contained in the array.
 * 
 * @param object String object which can be contained in the array.
 * @param objects String array.
 * 
 * @return True if string is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(String object, String... objects) {
		
		return predicate(objects, o -> o.equals(object));
	}
	
/**
 * 
 * Compares specified byte number with array and returns true if byte is contained in the array.
 * 
 * @param object Byte number which can be contained in the array.
 * @param objects Byte array.
 * 
 * @return True if byte is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(byte object, byte... objects) {
		
		return predicateByte(objects, o -> object == o);
	}
		
/**
 * 
 * Compares specified short number with array and returns true if short is contained in the array.
 * 
 * @param object Short number which can be contained in the array.
 * @param objects Short array.
 * 
 * @return True if short is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(short object, short... objects) {
		
		return predicateShort(objects, o -> object == o);
	}
	
/**
 * 
 * Compares specified integer number with array and returns true if integer is contained in the array.
 * 
 * @param object Integer number which can be contained in the array.
 * @param objects Integer array.
 * 
 * @return True if integer is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(int object, int... objects) {
		
		return predicateInt(objects, o -> object == o); 
	}
	
/**
 * 
 * Compares specified long number with array and returns true if long is contained in the array.
 * 
 * @param object Long number which can be contained in the array.
 * @param objects Long array.
 * 
 * @return True if long is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(long object, long... objects) {
		
		return predicateLong(objects, o -> object == o);
	}
	
/**
 * 
 * Compares specified double number with array and returns true if double is contained in the array.
 * 
 * @param object Double number which can be contained in the array.
 * @param objects Double array.
 * 
 * @return True if double is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(double object, double... objects) {
		
		return predicateDouble(objects, o -> object == o);
	}
	
/**
 * 
 * Compares specified float number with array and returns true if float is contained in the array.
 * 
 * @param object Float number which can be contained in the array.
 * @param objects Float array.
 * 
 * @return True if float is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(float object, float... objects) {
		
		return predicateFloat(objects, o -> object == o);
	}
	
/**
 * 
 * Compares specified boolean with array and returns true if boolean is contained in the array.
 * 
 * @param object Boolean which can be contained in the array.
 * @param objects Boolean object.
 * 
 * @return True if boolean is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(boolean object, boolean... objects) {
		
		for(boolean tempObject : objects) if(tempObject == object) return true;
		
		return false; 
	}
	
/**
 * 
 * Compares specified character with array and returns true if character is contained in the array.
 * 
 * @param object Character which can be contained in the array.
 * @param objects Character object.
 * 
 * @return True if character is contained in the array, otherwise false.
 * 
 */
	public static boolean contains(char object, char... objects) {
		
		return predicateChar(objects, o -> object == o);
	}
	
/**
 * 
 * Returns random object from specified T array.
 * 
 * @param <T> Any generic type.
 * 
 * @param objects T array.
 * 
 * @return Random T object from the array.
 * 
 */
	@SafeVarargs
	public static <T> T random(T... objects) {
		
		return objects[new Random().nextInt(objects.length)];
	}
	
/**
 * 
 * Returns random object from specified object array.
 * 
 * @param objects Object array.
 * 
 * @return Random object from array.
 * 
 */
	public static Object randomObject(Object... objects) {
		
		return objects[(new Random().nextInt(objects.length))];
	}
	
/**
 * 
 * Returns Object {@code value} from parameter if it isn't equal null, otherwise returns Object {@code ifNull}.
 * 
 * @param value Object returns if it isn't equal null.
 * @param ifNull Object returns if {@code value} equals null. 
 * 
 * @return {@code value} if it isn't equal null, otherwise returns {@code ifNull}.
 * 
 */
	public static Object valueObjectOrIfNull(Object value, Object ifNull) {
		
		return value == null ? ifNull : value;
	}
	
/**
 * 
 * Returns T {@code value} from parameter if it isn't equal null, otherwise returns T {@code ifNull}.
 * 
 * @param <T> Any generic type.
 * 
 * @param value T returns if it isn't equal null.
 * @param ifNull T returns if {@code value} equals null. 
 * 
 * @return {@code value} if it isn't equal null, otherwise returns {@code ifNull}.
 * 
 */
	public static <T> T valueOrIfNull(T value, T ifNull) {
		
		return value == null ? ifNull : value;
	}
	
/**
 * 
 * Returns Object {@code value} from parameter if Object {@code object} isn't equal null, otherwise returns Object {@code ifNull}.
 * 
 * @param object Object for null checking.
 * @param value Object returns if {@code object} isn't equal null.
 * @param ifNull Object returns if {@code object} equals null. 
 * 
 * @return {@code value} if {@code object} isn't equal null, otherwise returns {@code ifNull}.
 * 
 */
	public static Object valueObjectOrIfNull(Object object, Object value, Object ifNull) {
		
		return object == null ? ifNull : value;
	}
	
/**
 * 
 * Returns Object {@code value} from parameter if Object {@code object} isn't equal null, otherwise returns null.
 * 
 * @param object Object for null checking.
 * @param value Object returns if {@code object} isn't equal null.
 * 
 * @return {@code value} if {@code object} isn't equal null, otherwise returns null.
 * 
 */
	public static Object valueObjectOrNull(Object object, Object value) {
		
		return object == null ? null : value;
	}
	
/**
 * 
 * Returns E {@code value} from parameter if T {@code object} isn't equal null, otherwise returns null.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type.
 * 
 * @param object T for null checking.
 * @param value E returns if {@code object} isn't equal null.
 * 
 * @return {@code value} if {@code object} isn't equal null, otherwise returns null.
 * 
 */
	public static <T, E> E valueOrNull(T object, E value) {
		
		return object == null ? null : value;
	}
	
/**
 * 
 * If specific T object equals null then returns null. Otherwise returns result of specified {@link Function} where the argument is specific T.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type. Unlike T type, the method returns this type and is used in {@link Function} as return type.
 * 
 * @param object T object to null check.
 * @param value Function which returns final result for returning by this method.
 * 
 * @return Null if T object is null. Otherwise returns result of function.
 * 
 */
	public static <T, E> E valueOrNull(T object, Function<T, E> value) {
		
		return object == null ? null : value.apply(object);
	}
	
/**
 * 
 * Returns E {@code value} from parameter if T {@code object} isn't equal null, otherwise returns E {@code ifNull}.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type.
 * 
 * @param object T for null checking.
 * @param value E returns if {@code object} isn't equal null.
 * @param ifNull E returns if {@code object} equals null. 
 * 
 * @return {@code value} if {@code object} isn't equal null, otherwise returns {@code ifNull}.
 * 
 */
	public static <T, E> E valueOrIfNull(T object, E value, E ifNull) {
		
		return object == null ? ifNull : value;
	}
	
/**
 * 
 * If specific T equals null then returns specified E. Otherwise returns result of specified {@link Function} where the argument is specific T.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type. Unlike T type, the method returns this type and is used in {@link Function} as return type.
 * 
 * @param object T object to null check.
 * @param value Function which returns final result for returning by this method.
 * @param ifNull E object returns if T object is null.
 * 
 * @return If T object is null then returns result of function. Otherwise returns E object.
 *
 */
	public static <T, E> E valueOrIfNull(T object, Function<T, E> value, E ifNull) {
		
		return object == null ? ifNull : value.apply(object);
	}
	
/**
 * 
 * Returns T different from one of two T from parameter. If object is not equals to these objects returns null.
 * 
 * @param <T> Any generic type.
 * 
 * @param object Compared T object.
 * @param first First T object for comparing.
 * @param second Second T object for comparing.
 * 
 * @return Null if object is not equals one of two T, otherwise returns T different to object and one T from parameter.
 * 
 */
	public static <T> T differentOrNull(T object, T first, T second) {
		
		return object == first ? second : object == second ? first : null;
	}

/**
 * 
 * Returns object different from one of two objects from parameter. If object is not equals to these objects returns null.
 * 
 * @param object Compared object.
 * @param first First object for comparing.
 * @param second Second object for comparing.
 * 
 * @return Null if object is not equals one of two objects, otherwise returns object different to object and one object from parameter.
 * 
 */
	public static Object differentObjectOrNull(Object object, Object first, Object second) {
		
		return object == first ? second : object == second ? first : null;
	}
	
/**
 * 
 * Returns T different from one of two T from parameter. 
 * If object is not equals to these objects returns object from parameter {@code ifNull}.
 * 
 * @param <T> Any generic type.
 * 
 * @param object Compared T object.
 * @param first First T object for comparing.
 * @param second Second T object for comparing.
 * @param ifNull T object returns if object is not equals to comparing objects.
 * 
 * @return {@code ifNull} object if object is not equals one of two T, otherwise returns T different to object and one T from parameter.
 * 
 */
	public static <T> T differentOrIfNull(T object, T first, T second, T ifNull) {

		T result = differentOrNull(object, first, second);
		
		return result == null ? ifNull : result;
	}
	
/**
 * 
 * Returns object different from one of two objects from parameter. 
 * If object is not equals to these objects returns object from parameter {@code ifNull}.
 * 
 * @param object Compared object.
 * @param first First object for comparing.
 * @param second Second object for comparing.
 * @param ifNull Object returns if object is not equals to comparing objects.
 * 
 * @return {@code ifNull} object if object is not equals one of two comparing objects, otherwise returns object different to object and one objects from parameter.
 * 
 */
	public static Object differentObjectOrIfNull(Object object, Object first, Object second, Object ifNull) {

		Object result = differentObjectOrNull(object, first, second);
		
		return result == null ? ifNull : result;
	}
	
/**
 * 
 * Returns result of checking to instance of objects. If one of objects is instance of specified class then returns true, otherwise returns false.
 * 
 * @param clazz Class as instance of one of objects.
 * @param objects Object array to instance check.
 * 
 * @return True if one of specified objects is instance of specified class, otherwise returns false.
 *
 */
	public static boolean isInstance(Class<?> clazz, Object... objects) {
		
		return predicate(objects, clazz::isInstance);
	}
	
/**
 * 
 * Returns result of checking to instance of objects. There is certain options:
 * <blockquote>
 * 1. If first object is not instance of both classes then returns false.
 * <br>
 * 2. If second object is not instance of both classes then returns false.
 * <br>
 * 3. If first object is instance of both classes then checks second object.
 * <br>
 * 3.1. If second object is not instance of first class then checks to second class. Otherwise returns true.
 * <br>
 * 3.2. If second object is not instance of second class then returns false. Otherwise returns true.
 * <br>
 * 4. If first object is instance of one of both classes then second object checks for instance to other class.
 * <br>
 * 4.1. If second object is not instance of other class then returns false. Otherwise returns true.
 * <br>
 * <br>
 * <strong>Notice: </strong>Both objects can be instances of two classes simultaneously. 
 * But if they are instances of one class only, then this method returns false.
 * </blockquote>
 * 
 * @param firstClass First class as instance of one of objects.
 * @param secondClass Second class as instance of one of the object.
 * @param firstObject First object to instance check.
 * @param secondObject Second object to instance check.
 * 
 * @return True if first object is instance of one of classes and second object is instance of other class rather than different specified. 
 * Otherwise returns false. 
 * <br>
 * More details about return object see in general description.
 *
 */
	public static boolean isInstances(Class<?> firstClass, Class<?> secondClass, Object firstObject, Object secondObject) {
		
//		First symbol is class number, second is object number
		boolean ff = firstClass.isInstance(firstObject);
		boolean fs = firstClass.isInstance(secondObject);
		boolean sf = secondClass.isInstance(firstObject);
		boolean ss = secondClass.isInstance(secondObject);
		
		return ((ff && sf) && (fs || ss)) || ((fs && ss) && (ff || sf)) || (ff && ss) || (sf && fs);
	}
}