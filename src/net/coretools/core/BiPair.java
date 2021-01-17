package net.coretools.core;

/**
 * 
 * BiPair interface is extending of {@link Pair} interface which implies to contains objects of one type rather than two types like inherited pair.
 * 
 * @param <T> Any generic containing type.
 * 
 * @since 1.5.0
 * 
 * @author Krows
 * 
 */
public interface BiPair<T> extends Pair<T, T> {
}