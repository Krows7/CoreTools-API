package net.coretools.core;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 * 
 * UtilTools class contains utility methods for programming.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
public final class UtilTools {
	
/**
 * 
 * Closed constructor.
 *
 */
	private UtilTools() {
		
	}
	
/**
 * 
 * Makes for-loop with specified number of iterations and does {@link IntConsumer} action with current index of loop.
 * 
 * @param n Number of iterations of for-loop.
 * @param consumer Consumer action to execute for each index of loop.
 * 
 */
	public static void forLoop(int n, IntConsumer consumer) {
		
		for(int i = 0; i < n; i++) consumer.accept(i);
	}
	
/**
 * 
 * Makes reverse for-loop with specified number of iterations and does {@link IntConsumer} action with current index of loop.
 * Unlike {@link #forLoop(int, IntConsumer)} method this starts iteration not from 0, but from the specified integer and reduces to zero.
 * 
 * @param n Number of iterations.
 * @param consumer IntConsumer returns current index of iteration.
 *
 */
	public static void reverseForLoop(int n, IntConsumer consumer) {
		
		for(int i = n; i > 0; i--) consumer.accept(i);
	}
	
/**
 * 
 * Accepts the specified consumer with specified T and after that returns T object.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object to accept with consumer and return.
 * @param consumer Consumer object to accept.
 * 
 * @return Specified T object after accepting the consumer.
 *
 */
	public static <T> T after(T t, Consumer<T> consumer) {
		
		consumer.accept(t);
		
		return t;
	}
	
/**
 * 
 * Accepts the specified consumer with specified T object if predicate will matched with T object.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object to make predicate and consumer.
 * @param predicate Predicate to decide to accept consumer.
 * @param consumer Consumer to accept it if predicate will matched.
 *
 */
	public static <T> void ifMatch(T t, Predicate<T> predicate, Consumer<T> consumer) {
		
		if(predicate.test(t)) consumer.accept(t);
	}
	
/**
 * 
 * Returns result of test of the specified predicate with specified T object.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object to test of predicate.
 * @param predicate Predicate to check match.
 * 
 * @return True if predicate will matched with T object. Otherwise returns false.
 *
 */
	public static <T> boolean ifMatch(T t, Predicate<T> predicate) {
		
		return predicate.test(t);
	}
	
/**
 * 
 * Accepts the specified consumer with specified T object if predicate will matched with T object. After all returns T object.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object to make predicate and consumer and to return.
 * @param predicate Predicate to decide to accept consumer.
 * @param consumer Consumer to accept it if predicate will matched.
 * 
 * @return Specified T object.
 *
 */
	public static <T> T ifMatchGet(T t, Predicate<T> predicate, Consumer<T> consumer) {
		
		return after(t, t0 -> ifMatch(t0, predicate, consumer));
	}
	
/**
 * 
 * Accepts one of specified {@link Consumer} objects. 
 * If the specified {@link Predicate} will matched with specified T object then accepts {@code ifTrue} consumer, otherwise accepts {@code ifFalse} consumer.
 * 
 * @param <T> Any generic type.
 * 
 * @param t T object to test of predicate.
 * @param predicate Predicate to decide which one to accept consumer. If match then accepts {@code ifTrue} consumer. Otherwise accepts {@code ifFalse} consumer.
 * @param ifTrue Consumer to accept if predicate will matched.
 * @param ifFalse Consumer to accept if predicate won't matched.
 *
 */
	public static <T> void ifMatchElse(T t, Predicate<T> predicate, Consumer<T> ifTrue, Consumer<T> ifFalse) {
		
		if(predicate.test(t)) ifTrue.accept(t);
		else ifFalse.accept(t);
	}
	
/**
 * 
 * Returns object class of the specified array class. It can be also the primitive class. If specified class isn't array then it will be return.
 * 
 * @param <T> Generic type of E object.
 * @param <E> Generic type of array.
 * 
 * @param clazz Class of array to return the object class.
 * 
 * @return Converted to object class the specified array class or that class if it isn't array class.
 * 
 */
	public static <T, E> Class<T> getObjectClass(Class<E> clazz) {
		
		if(!clazz.isArray()) return cast(clazz);
		
		String name = clazz.getName();
		
		if(name.charAt(name.lastIndexOf('[') + 1) != 'L') return cast(getPrimitiveClass(clazz));
		
		try {
			
			return cast(Class.forName(name.substring(name.lastIndexOf('[') + 2, name.length() - 1)));
		} catch(Exception e) {
			
			return null;
		} 
	}
	
/**
 * 
 * Returns class of primitive type from specified array class.
 * 
 * @param clazz Class of array to convert into the class of primitive.
 * 
 * @return Converted class of array to class of primitive.
 *
 */
	private static Class<?> getPrimitiveClass(Class<?> clazz) {
		
		String name = clazz.getName();
		
		switch(name.charAt(name.lastIndexOf('[') + 1)) {
			
		case 'Z': return boolean.class;
		case 'B': return byte.class;
		case 'C': return char.class;
		case 'D': return double.class;
		case 'F': return float.class;
		case 'I': return int.class;
		case 'J': return long.class;
		case 'S': return short.class;
		default: return null;
		}
	}
	
	public static <T, E> E cast(T t, Class<E> clazz) {
		
		return cast(t);
	}
	
/**
 * 
 * Casts specified T object to E type.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type to convert into this type.
 * 
 * @param t T object to cast.
 * 
 * @return T object casted into E type.
 *
 */
	public static <T, E> E cast(T t) {
		
		return cast0(t);
	}
	
/**
 * 
 * Casts specified T object to E type.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type to convert into this type.
 * 
 * @param t T object to cast.
 * 
 * @return T object casted into E type.
 *
 */
	@SuppressWarnings("unchecked")
	private static <T, E> E cast0(T t) {
		
		return (E) t;
	}
}