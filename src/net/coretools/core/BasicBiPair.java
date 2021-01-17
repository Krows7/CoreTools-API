package net.coretools.core;

/**
 * 
 * BasicBiPair class is implementation of {@link BiPair} interface which allows using the container with pair of objects of one type unlike the {@link BasicPair} class.
 * 
 * @param <T> Any generic containing type.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
public class BasicBiPair<T> extends BasicPair<T, T> implements BiPair<T> {

/**
 * 
 * Creates new object which contains pair of the objects. Both objects should be one type.
 * 
 * @param first First object of the pair.
 * @param second Second object of the pair.
 * 
 */
	public BasicBiPair(T first, T second) {
		
		super(first, second);
	}
}