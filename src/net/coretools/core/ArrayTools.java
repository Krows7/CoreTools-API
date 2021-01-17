package net.coretools.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import net.coretools.core.OnQuestion.Status;

/**
 * 
 * ArrayTools class contains methods with working of arrays. 
 * Since 1.5.0 version most methods from {@link CollectionTools} class was moved to this class to splitting logic of containing methods.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
public final class ArrayTools {
	
/**
 * 
 * Closed constructor.
 *
 */
	private ArrayTools() {
			
	}
	
/**
 * 
 * Makes for-each loop with specified T array and does Consumer action with each element of the array and after that returns specified array.
 * 
 * @param <T> Any generic type.
 * 
 * @param array T array which contains elements for "for-each" cycle.
 * @param consumer Action for each element from array.
 * 
 * @return Specified T array after completing for-each loop and completing every Consumer action.
 *
 */
	public static <T> T[] forEach(T[] array, Consumer<T> consumer) {
		
		for(T t : array) consumer.accept(t);
		
		return array;
	}
	
/**
 * 
 * Makes for-loop with array indexes and does Consumer action with current index of loop and after that returns specified array.
 * 
 * @param <T> Any generic type.
 * 
 * @param array T array to make for-loop with specified {@link Consumer} action.
 * @param consumer Consumer action to execute for each index of specified T array.
 * 
 * @return Specified T array after completing for-loop and completing every Consumer action.
 *
 */
	public static <T> T[] forIndex(T[] array, Consumer<Integer> consumer) {
		
		for(int i = 0; i < array.length; i++) consumer.accept(i);
		
		return array;
	}
	
/**
 * 
 * Creates new T array, fills it by specified T object the count of specified integer number and returns it.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object for filling the array.
 * @param length Length of new array.
 * 
 * @return New T array of specified length and filled by specified object.
 *
 */
	public static <T> T[] filledOf(T t, int length) {
		
		return filledOf(createArray(t, length), t);
	}
	
/**
 * 
 * Fills specified T array with specified T element and returns this array.
 * 
 * @param <T> Any generic type.
 * 
 * @param array T array to fill with element.
 * @param t T element to fill the T array.
 * 
 * @return Specified T array after filling it with specified T element.
 *
 */
	public static <T> T[] filledOf(T[] array, T t) {
		
		return forIndex(array, index -> array[index] = t);
	}
	
/**
 * 
 * Returns T array which contains objects from specified T array except specified count of object from begin.
 * 
 * @param <T> Any generic type.
 * 
 * @param count Count of object for removing.
 * @param elements T array for editing.
 * 
 * @return New T array which does not contain specified count of objects but contains other objects from specified T array.
 * 
 */
	public static <T> T[] removeElementsFromBegin(int count, T[] elements) {
		
		return Arrays.copyOfRange(elements, count, elements.length);
	}
	
/**
 * 
 * Returns T array which contains objects from specified T array except specified count of object from end.
 * 
 * @param <T> Any generic type.
 * 
 * @param count Count of object for removing.
 * @param elements T array for editing.
 * 
 * @return New T array which does not contain specified count of objects but contains other objects from specified T array.
 * 
 */
	public static <T> T[] removeElementsFromEnd(int count, T[] elements) {
		
		return Arrays.copyOf(elements, elements.length - count);
	}
	
/**
 * 
 * Creates and returns an array of T with single element. Uses method {@link Arrays#asList(Object...)}.
 * 
 * @param <T> Any generic type.
 * 
 * @param element Element for array.
 * 
 * @return Array with single element parameter.
 * 
 */
	public static <T> T[] singletonArray(T element) {
		
		return Arrays.asList(element).toArray(createArray(element));
	}
	
/**
 * 
 * Creates T array with single null object.
 * 
 * @param <T> Any Generic type.
 * 
 * @return T array with single null object.
 * 
 */
	public static <T> T[] singleNullArray() {
		
		return elementArray((T) null);
	}
	
/**
 * 
 * Creates and returns T array from T varargs.
 * 
 * @param <T> Any generic type.
 * 
 * @param elements T varargs for array.
 * 
 * @return T array with elements from parameter.
 * 
 */
	@SafeVarargs
	public static <T> T[] elementArray(T... elements) {
		
		return elements;
	}
	
/**
 * 
 * Creates and returns T array from varargs of other T arrays. 
 * The order of adding values starts from first element of first argument array. 
 * 
 * @param <T> Any generic type.
 * 
 * @param arrays Varargs of T arrays.
 * 
 * @return Array of argument arrays.
 * 
 */
	@SafeVarargs
	@OnDevelopment
	public static <T> T[] appendArrays(T[]... arrays) {
		
		if(arrays.length == 0) throw new NullPointerException("Array size equal 0.");
		
		List<T> resultList = new ArrayList<>();
		
		forEach(arrays, a -> forEach(a, e -> resultList.add(e)));
		
		return resultList.toArray(arrays[0]);
	}
	
/**
 * 
 * Checks for emptiness of this array. Every element in array must be null.
 * 
 * @param array Array for checking.
 * 
 * @return True if array is empty, otherwise false.
 * 
 */
	public static boolean isEmptyArray(Object[] array) {
		
		return !predicate(array, o -> o != null);
	}
	
/**
 * 
 * Checks for fullness of the array and null objects.
 * 
 * @param array Array for checking.
 * 
 * @return True if array contains one element at least and does not contain null objects, otherwise returns false.
 * 
 */
	public static boolean isFullArray(Object[] array) {
		
		return array.length != 0 && !predicate(array, o -> o == null);
	}
	
/**
 * 
 * Checks for fullness of this array and containing null objects or other objects different of specified element.
 * 
 * @param array Array for checking.
 * @param element Object for checking to containing in array.
 * 
 * @return True if array contains one element at least and does not contain null objects or objects different to specified object, otherwise returns false.
 * 
 */
	public static boolean isFullArray(Object[] array, Object element) {
		
		return array.length != 0 && !predicate(array, o -> o == null || o != element);
	}
	
/**
 * 
 * Checks for fullness of this array and containing null objects or other objects different of specified elements.
 * Every element on array must be equal to one of specified element.
 * 
 * @param array Array for checking.
 * @param elements Objects for checking to containing in array.
 * 
 * @return True if array contains one element at least and does not contain null objects or objects different to specified objects, otherwise returns false.
 * 
 */
	public static boolean isFullArray(Object[] array, Object... elements) {
		
		if(array.length == 0) return false;
		
		for(Object object : array) {
			
			if(object == null) return false;
			if(!ObjectTools.containsObject(object, elements)) return false;
		}
		
		return true;
	}
	
/**
 * 
 * Makes for-loop of all elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param <T> Any generic type.
 * 
 * @param array Array with elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static <T> boolean predicate(T[] array, Predicate<T> predicate) {
		
		for(T t : array) if(predicate.test(t)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all byte elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with byte elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateByte(byte[] array, IntPredicate predicate) {
		
		for(byte b : array) if(predicate.test(b)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all short elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with short elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateShort(short[] array, IntPredicate predicate) {
		
		for(short s : array) if(predicate.test(s)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all integer elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with integer elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateInt(int[] array, IntPredicate predicate) {
		
		for(int i : array) if(predicate.test(i)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all character elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with character elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateChar(char[] array, IntPredicate predicate) {
		
		for(int i : array) if(predicate.test(i)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all long elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with long elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateLong(long[] array, LongPredicate predicate) {
		
		for(long l : array) if(predicate.test(l)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all double elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with double elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateDouble(double[] array, DoublePredicate predicate) {
		
		for(double d : array) if(predicate.test(d)) return true;
		
		return false;
	}
	
/**
 * 
 * Makes for-loop of all float elements from specified array and creates predicate with them. If one of element matches the predicate then returns true.
 * If none element from array matches the predicate then returns false.
 * 
 * @param array Array with float elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from array matches the predicate. Otherwise returns false.
 *
 */
	public static boolean predicateFloat(float[] array, DoublePredicate predicate) {
		
		for(double d : array) if(predicate.test(d)) return true;
		
		return false;
	}
	
/**
 * 
 * Creates and returns T array from {@link Iterator} data.
 * 
 * @param <T> Any generic type.
 * 
 * @param iterator Iterator for receiving of data.
 * 
 * @return T array from objects of iterator.
 * 
 */
	public static <T> T[] createArrayFromIterator(Iterator<T> iterator) {
		
		return castArray(UtilTools.after(new ArrayList<>(), list -> iterator.forEachRemaining(list::add)).toArray());
	}
	
/**
 * 
 * Returns new E array with sorted elements from specific array by predicate. Array can be empty but must not be null.
 * 
 * @param <E> Any generic type.
 * 
 * @param array E array to get elements.
 * @param predicate Predicate to sort elements.
 * 
 * @return New E array with sorted elements from specific array by predicate. This array can be empty.
 *
 */
	public static <E> E[] createSortedArray(E[] array, Predicate<E> predicate) {
		
		return Arrays.stream(array).filter(predicate).toArray(i -> createArray(array.getClass(), i));
	}
	
/**
 * 
 * Returns Object array of T arguments.
 * 
 * @param <T> Any generic type.
 * 
 * @param array T varargs or array for casting.
 * 
 * @return Object array.
 * 
 */
	@SafeVarargs
	@OnQuestion(status = Status.REMOVE, description = "This method is useless. And also added *castArray* method.")
	@Deprecated
	public static <T> Object[] castToObjectArray(T... array) {
		
		return array;
	}
	
/**
 * 
 * Creates new zero length array of specified class which can be class of array. Type of returned array always will be object, but not array.
 * 
 * @param <T> E type or type of E object if E type is an array.
 * @param <E> Any generic type. It can be an array.
 * 
 * @param clazz Class type of new array. This class can be an array, but in final array the type always will be type of object.
 * 
 * @return New zero length array of type of specified class. If class type is an array then type will be type of array object.
 *
 */
	static <T, E> T[] createArray(Class<E> clazz) {
		
		return createArray(clazz, 0);
	}
	
/**
 * 
 * Creates new array of specified class which can be class of array with specified length. Type of returned array always will be object, but not array.
 * 
 * @param <T> E type or type of E object if E type is an array.
 * @param <E> Any generic type. It can be an array.
 * 
 * @param clazz Class type of new array. This class can be an array, but in final array the type always will be type of object.
 * @param length Length of new array.
 * 
 * @return New array of type of specified class with specified length. If class type is an array then type will be type of array object.
 *
 */
	static <T, E> T[] createArray(Class<E> clazz, int length) {
		
		return UtilTools.cast(Array.newInstance(UtilTools.getObjectClass(clazz), length));
	}
	
/**
 * 
 * Creates and returns zero length T array.
 * 
 * @param <T> Any generic type.
 * 
 * @param element T object for creating array.
 * 
 * @return Zero length T array.
 * 
 */
	static <T> T[] createArray(T element) {
		
		return createArray(element, 0);
	}
	
/**
 * 
 * Creates and returns new empty T array with specified length.
 * 
 * @param <T> Any generic type.
 * 
 * @param element T object for creating array.
 * @param length Length of array.
 * 
 * @return New empty T array with specified length.
 * 
 */
	@SuppressWarnings("unchecked")
	static <T> T[] createArray(T element, int length) {
		
		return (T[]) Array.newInstance(element.getClass(), length);
	}
	
/**
 * 
 * Casts the specified T array to the array of E elements and return it.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type inherited from T type.
 * 
 * @param array T array to cast.
 * 
 * @return Casted T array to E array.
 *
 */
	public static <T, E extends T> E[] castArray(T[] array) {
		
		return castArray0(array);
	}
	
/**
 * 
 * Casts Object array to T array and returns it.
 * 
 * @param <T> Any generic type.
 * 
 * @param array Object array to cast.
 * 
 * @return T array from specified Object array.
 * 
 */
	@SuppressWarnings("unchecked")
	private static <T> T[] castArray0(Object[] array) {
		
		return (T[]) array;
	}
	
	@SafeVarargs
	public static <T> T[] appendElements(T[] array, T... elements) {
		
		T[] result = createArray(UtilTools.getObjectClass(array.getClass()), array.length + elements.length);
		
		UtilTools.forLoop(array.length, i -> result[i] = array[i]);
		UtilTools.forLoop(elements.length, i -> result[i + array.length] = elements[i]);
		
		return result;
	}
}