package net.coretools.core;

/**
 * 
 * BasicPair class is implementation of {@link Pair} interface which allows using the container with pair of objects of two different or similar types.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type.
 * 
 * @since 1.4.9 (2'nd patch)
 * 
 * @author Krows
 * 
 */
public class BasicPair<T, E> implements Pair<T, E> {

/**
 * 
 * First object of the pair.
 * 
 */
	protected T first;
	
/**
 * 
 * Second object of the pair.
 * 
 */
	protected E second;
	
/**
 * 
 * Creates new object which contains pair of the objects. Objects may be different types.
 * 
 * @param first First object of the pair.
 * @param second Second object of the pair.
 * 
 */
	public BasicPair(T first, E second) {

		this.first = first;
		
		this.second = second;
	}
	
	@Override
	public T getFirst() {
		
		return first;
	}

	@Override
	public E getSecond() {

		return second;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		if(obj == null || !(obj instanceof Pair)) return false;
		
		Pair<?, ?> p = (Pair<?, ?>) obj;
		
		return getFirst().equals(p.getFirst()) && getSecond().equals(p.getSecond());
	}
	
	@Override
	public int hashCode() {
		
		int prime = 31;
		
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		
		return result;
	}
	
	@Override
	public String toString() {
		
		return String.format("[First: %s; Second: %s]", first, second); 
	}
}