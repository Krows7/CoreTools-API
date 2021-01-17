package net.coretools.core;

/**
 * 
 * Pair class is simple container which contains pair of objects (may be different types).
 * 
 * @since 1.4.9 (2'nd patch)
 * 
 * @author Krows
 *
 * @param <T> Any generic type
 * @param <E> Any generic type.
 * 
 */
public interface Pair<T, E> {

/**
 * 
 * Returns first object of the pair.
 * 
 * @return first pair object.
 * 
 */
	public T getFirst();
	
/**
 * 
 * Returns second object of the pair.
 * 
 * @return second pair object.
 * 
 */
	public E getSecond();
}