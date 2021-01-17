package net.coretools.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;

/**
 * 
 * CollectionTools class contains methods to extraordinarily and not very work with Java collections.
 * Since 1.5.0 version most methods from this class was moved to {@link ArrayTools} class to splitting logic of containing methods.
 * 
 * @since 1.0.0 (old: 1.0)
 *
 * @author Krows
 * 
 */
public final class CollectionTools {
	
/**
 * 
 * Closed constructor.
 * 
 */
	private CollectionTools() {
		
	}
	
/**
 * 
 * Returns modifiable T {@link List} object which contains specified objects from T array.
 * 
 * @param <T> Any generic type.
 * 
 * @param elements T array for the list.
 * 
 * @return Modifiable T List of specified T array.
 * 
 */
	@SafeVarargs
	public static <T> List<T> createModifiableListOf(T... elements) {
		
		return new ArrayList<>(Arrays.asList(elements));
	}
	
/**
 * 
 * Takes T object from {@link List} object and sets it to first place in the list. 
 * If object index already does set on 0 or list does not contain this object then returns false, otherwise returns true.
 * 
 * @param <T> Any generic type.
 * 
 * @param list List with containing object.
 * @param object Object to replace.
 * 
 * @return True if object success replaced, otherwise returns false.
 * 
 */
	public static <T> boolean makeObjectFirst(List<T> list, T object) {
		
		if(list.contains(object) && list.indexOf(object) != 0) {
			
			list.remove(object);
			list.add(0, object);
			
			return true;
		}
		
		return false;
	}
	
/**
 * 
 * Takes T object from {@link List} object and sets it to last place in the list. 
 * If object index already does set on last index or list does not contain this object then returns false, otherwise returns true.
 * 
 * @param <T> Any generic type.
 * 
 * @param list List with containing object.
 * @param object Object to replace.
 * 
 * @return True if object success replaced, otherwise returns false.
 * 
 */
	public static <T> boolean makeObjectLast(List<T> list, T object) {
		
		if(list.contains(object) && list.indexOf(object) != list.size() - 1) {

			list.remove(object);
			list.add(object);
			
			return true;
		}

		return false;
	}
	
/**
 * 
 * Reverses object positions in specified {@link List} object.
 * 
 * @param <T> Any generic type.
 * 
 * @param list List to reverse.
 * 
 * @return New List object with reversed object positions.
 * 
 */
	public static <T> List<T> createReverseList(List<T> list) {
		
		List<T> result = new ArrayList<>();
		
		for(int i = list.size() - 1; i >= 0; i--) {
			
			result.add(list.get(i));
		}
		
		return result;
	}
	
/**
 * 
 * Removes specified count of objects from T {@link Collection} from begin and returns it.
 * 
 * @param <T> Any generic type.
 * 
 * @param count Count of objects for removing. 
 * @param collection Collection object for editing.
 * 
 * @return Specified T Collection which does not contain specified count of objects.
 * 
 */
	public static <T> Collection<T> removeElementsFromBegin(int count, Collection<T> collection) {
		
		List<T> resultList = new ArrayList<>(collection);
		
		for(int i = 0; i < count; i++) resultList.remove(0);
		
		collection.clear();
		collection.addAll(resultList);
		
		return collection;
	}
	
/**
 * 
 * Removes specified count of objects from T {@link Collection} from end and returns it.
 * 
 * @param <T> Any generic type.
 * 
 * @param count Count of objects for removing. 
 * @param collection Collection object for editing.
 * 
 * @return Specified T Collection which does not contain specified count of objects.
 * 
 */
	public static <T> Collection<T> removeElementsFromEnd(int count, Collection<T> collection) {
		
		List<T> resultList = new ArrayList<>(collection);
		
		for(int i = 0; i < count; i++) resultList.remove(resultList.size() - 1);
		
		collection.clear();
		collection.addAll(resultList);
		
		return collection;
	}
	
/**
 * 
 * Creates new E {@link Collection} and adds to it objects from {@link Puller} iteration.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param collection T Collection with objects to Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New E Collection with Puller iteration objects.
 * 
 * @throws NullPointerException If collection size equals 0.
 * 
 */
	public static <T, E> List<E> createPulledElementList(Collection<T> collection, Puller<T, E> puller) {
		
		if(collection.size() == 0) throw new NullPointerException("Collection size equals 0.");
		
		List<E> resultList = new ArrayList<>(collection.size());
		
		collection.forEach(value -> resultList.add(puller.pull(value)));
		
		return resultList;
		
//		Streams are so slow :(
//		return collection.stream().map(puller::pull).collect(Collectors.toList());
	}
	
/**
 * 
 * Creates new E {@link Collection} and adds to it objects from {@link Puller} iteration.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param elements T array to Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New E Collection with Puller iteration objects.
 * 
 * @throws NullPointerException If array length equal 0.
 * 
 */
	public static <T, E> Collection<E> createPulledElementCollection(T[] elements, Puller<T, E> puller) {
		
		if(elements.length == 0) throw new NullPointerException("Array length equals 0.");
		
		Collection<E> resultList = new ArrayList<>(elements.length);
		
		for(T t : elements) resultList.add(puller.pull(t));
		
		return resultList;
	}
	
/**
 * 
 * Creates new E array and adds to it objects from {@link Puller} iteration.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param elements T array to Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New E array with Puller iteration objects.
 * 
 * @throws NullPointerException If array length equal 0.
 * 
 */
	public static <T, E> E[] createPulledElementArray(T[] elements, Puller<T, E> puller) {
		
		return createPulledElementCollection(elements, puller).toArray(ArrayTools.createArray(puller.pull(elements[0])));
	}
	
/**
 * 
 * Creates new E array and adds to it objects from {@link Puller} iteration.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param collection T Collection with objects to Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New E array with Puller iteration objects.
 * 
 * @throws NullPointerException If collection size equal 0.
 * 
 */
	public static <T, E> E[] createPulledElementArray(Collection<T> collection, Puller<T, E> puller) {
		
		return createPulledElementList(collection, puller).toArray(ArrayTools.createArray(puller.pull(collection.iterator().next())));
	}
	
/**
 * 
 * Creates new T, E {@link Map} where the keys is T array and the values is taken pulling values from {@link Puller} 
 * where values is elements from array.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param elements T array for keys and Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New T, E Map with keys from array and Puller iteration objects.
 * 
 */
	public static <T, E> Map<T, E> createMapFromPulledElements(T[] elements, Puller<T, E> puller) {
		
		return createMapFromPulledElements(Arrays.asList(elements), puller);
	}
	
/**
 * 
 * Creates new T, E {@link Map} where the keys is T Collection and the values is taken pulling values from {@link Puller} 
 * where values is elements from Collection.
 * 
 * @param <T> Any generic type.
 * @param <E> Any generic type which will be received from puller.
 * 
 * @param elements T Collection for keys and Puller iteration.
 * @param puller Puller to iteration.
 * 
 * @return New T, E Map with keys from Collection and Puller iteration objects.
 * 
 */
	public static <T, E> Map<T, E> createMapFromPulledElements(Collection<T> elements, Puller<T, E> puller) {
		
		Map<T, E> resultMap = new HashMap<>();
		
		for(T element : elements) resultMap.put(element, puller.pull(element));
		
		return resultMap;
	}
	
/**
 * 
 * Creates T, E {@link Map} from key and value arrays from parameters.
 * 
 * @param <T> Any generic type of keys.
 * @param <E> Any generic type of values.
 * 
 * @param keys Key array for Map.
 * @param values Value array for Map.
 * 
 * @return Map object which contains keys and values from arrays.
 * 
 */
	public static <T, E> Map<T, E> createElementMap(T[] keys, E[] values) {
		
		if(keys.length != values.length) throw new IllegalArgumentException("Number of keys isn't equal to number of values.");
		
		Map<T, E> resultMap = new HashMap<>();
		
		for(int i = 0; i < keys.length; i++) resultMap.put(keys[i], values[i]);
		
		return resultMap;
	}
	
/**
 * 
 * Creates T, E {@link Map} from key and value {@link Collection} objects from parameters. 
 * "key-value" pair will create by order of {@link Iterator} object of both Collections.
 * 
 * @param <T> Any generic type of keys.
 * @param <E> Any generic type of values.
 * 
 * @param keys Key Collection for Map.
 * @param values Value Collection for Map.
 * 
 * @return Map object which contains keys and values from Collection objects.
 * 
 */
	public static <T, E> Map<T, E> createElementMap(Collection<T> keys, Collection<E> values) {
		
		if(keys.size() != values.size()) throw new IllegalArgumentException("Number of keys isn't equal to number of values.");
		
		Map<T, E> resultMap = new HashMap<>();
		
		Iterator<T> keyIterator = keys.iterator();
		Iterator<E> valueIterator = values.iterator();
		
		while(keyIterator.hasNext()) resultMap.put(keyIterator.next(), valueIterator.next());
		
		return resultMap;	
	}
	
	public static <T, E> Map<T, E> createElementMap(Pair<T, E>... pairs) {
		
		Map<T, E> map = new HashMap<>();
		
		ArrayTools.forEach(pairs, pair -> map.put(pair.getFirst(), pair.getSecond()));
		
		return map;
	}
	
	public static <T, E> Map<T, E> createElementMap(List<Pair<T, E>> pairList) {
		
		Map<T, E> map = new HashMap<>();
		
		pairList.forEach(pair -> map.put(pair.getFirst(), pair.getSecond()));
		
		return map;
	}
	
/**
 * 
 * Creates {@link Collection} with single null object.
 * 
 * @param <T> Any Generic type.
 * 
 * @return T Collection with single null object.
 * 
 */
	public static <T> Collection<T> singleNullCollection() {
		
		return Arrays.asList((T) null);
	}
	
/**
 * 
 * Creates {@link List} with single null object.
 * 
 * @param <T> Any Generic type.
 * 
 * @return T List with single null object.
 * 
 */
	public static <T> List<T> singleNullList() {
		
		return Arrays.asList((T) null);
	}
	
/**
 * 
 * Creates and returns {@link Iterator} from T array. Returned iterator supports {@code remove()} method.
 * 
 * @param <T> Any generic type.
 * 
 * @param array Array for iterator.
 * 
 * @return Iterator which contains objects from array.
 * 
 */
	public static <T> Iterator<T> arrayIterator(T[] array) {
		
		T[] tempArray = Objects.requireNonNull(array, "Array must not be null.");
		
		return new Iterator<T>() {
			
			int index = 0;
			
			T[] elementArray = tempArray;
			
			@Override
			public T next() {

				if(!hasNext()) throw new NoSuchElementException();
				
				return elementArray[index++];
			}
			
			@Override
			public void remove() {
				
				index = elementArray.length;
				
				elementArray = null;
			}
			
			@Override
			public boolean hasNext() {

				return index < elementArray.length;
			}
		};
	}
	
/**
 * 
 * Creates and returns {@link Iterator} from T varargs. Returned iterator supports {@code remove()} method.
 * 
 * @param <T> Any generic type.
 * 
 * @param array Varargs for iterator.
 * 
 * @return Iterator which contains objects from varargs.
 * 
 */
	@SafeVarargs
	public static <T> Iterator<T> tIterator(T... array) {
		
		if(array == null) throw new NullPointerException();
		
		T[] tempArray = array;
		
		return new Iterator<T>() {
			
			int index = 0;
			
			T[] elementArray;
			
			{this.elementArray = tempArray;}
			
			@Override
			public T next() {

				if(!hasNext()) throw new NoSuchElementException();
				
				return elementArray[index++];
			}
			
			@Override
			public void remove() {
			
				elementArray = null;
			}
			
			@Override
			public boolean hasNext() {

				return index < elementArray.length;
			}
		};
	}
	
/**
 * 
 * Makes for-loop of all elements from specified {@link Collection} and creates predicate with them. 
 * If one of element matches the predicate then returns true. If none element from collection matches the predicate then returns false.
 * 
 * @param <T> Any generic type.
 * 
 * @param collection Collection with elements to predicate.
 * @param predicate Predicate for array elements.
 * 
 * @return True if one of elements from collection matches the predicate. Otherwise returns false.
 *
 */
	public static <T> boolean predicate(Collection<T> collection, Predicate<T> predicate) {
		
		for(T t : collection) if(predicate.test(t)) return true;
		
		return false;
	}
	
	public static <T, E> T get(Collection<T> collection, E e, Function<T, E> function) {
		
		return get(collection, t -> e.equals(function.apply(t)));
	}
	
	public static <T, E> boolean contains(Collection<T> collection, E e, Function<T, E> function) {
		
		return get(collection, e, function) != null;
	}
	
	public static <T> T get(Collection<T> collection, Predicate<T> predicate) {
		
		for(T t : collection) if(predicate.test(t)) return t;
		
		return null;
	}
	
	public static <T> T getFirst(Collection<T> collection, T... elements) {
		
		return get(collection, e -> ObjectTools.containsObject(e, elements));
	}
	
	public static <T> void forEachIndex(Collection<T> collection, ObjIntConsumer<T> consumer) {
		
		AtomicInteger index = new AtomicInteger();
		
		collection.forEach(e -> consumer.accept(e, index.getAndIncrement()));
	}
	
	public static <T> void forEachExcept(Collection<T> collection, Consumer<T> consumer, int... indexes) {
		
		forEachIndex(collection, (e, index) -> UtilTools.ifMatch(e, e1 -> !ObjectTools.contains(index, indexes), consumer::accept));
	}
	
	public static <T> void forEachWithPrevious(Collection<T> collection, BiConsumer<T, T> consumer) {
		
		AtomicReference<T> previous = new AtomicReference<>();
		
		collection.forEach(e -> consumer.accept(previous.getAndSet(e), e));
	}
	
	public static <T> void forEachWithPreviousExcept(Collection<T> collection, BiConsumer<T, T> consumer, int... indexes) {
		
		AtomicReference<T> previous = new AtomicReference<>();
		
		forEachIndex(collection, (e, index) -> UtilTools.ifMatch(e, e1 -> !ObjectTools.contains(index, indexes), e1 -> consumer.accept(previous.getAndSet(e1), e1)));
	}
}