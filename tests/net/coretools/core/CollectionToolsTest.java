package net.coretools.core;

import static net.coretools.core.CollectionTools.*;
import static net.coretools.core.CollectionTools.arrayIterator;
import static net.coretools.core.CollectionTools.createElementMap;
import static net.coretools.core.CollectionTools.createMapFromPulledElements;
import static net.coretools.core.CollectionTools.createModifiableListOf;
import static net.coretools.core.CollectionTools.createPulledElementArray;
import static net.coretools.core.CollectionTools.createPulledElementList;
import static net.coretools.core.CollectionTools.createReverseList;
import static net.coretools.core.CollectionTools.makeObjectFirst;
import static net.coretools.core.CollectionTools.makeObjectLast;
import static net.coretools.core.CollectionTools.predicate;
import static net.coretools.core.CollectionTools.removeElementsFromBegin;
import static net.coretools.core.CollectionTools.removeElementsFromEnd;
import static net.coretools.core.CollectionTools.singleNullCollection;
import static net.coretools.core.CollectionTools.tIterator;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit tests for {@link CollectionTools} class.
 * 
 * @since 1.5.0
 * 
 * @author Krows
 * 
 */
class CollectionToolsTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createModifiableListOf(Object[])}.
	 */
	@Test
	final void testCreateModifiableListOf() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		List<String> list = createModifiableListOf(array);
		assertArrayEquals(array, list.toArray(new String[0]));
		list.add("Sixth");
		list.remove(0);
		list.remove(list.size() - 1);
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#makeObjectFirst(java.util.List, java.lang.Object)}.
	 */
	@Test
	final void testMakeObjectFirst() {
		
		List<String> list = new ArrayList<>(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
		makeObjectFirst(list, "Third");
		assertEquals("Third", list.get(0));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#makeObjectLast(java.util.List, java.lang.Object)}.
	 */
	@Test
	final void testMakeObjectLast() {
		
		List<String> list = new ArrayList<>(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
		makeObjectLast(list, "Third");
		assertEquals("Third", list.get(list.size() - 1));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createReverseList(java.util.List)}.
	 */
	@Test
	final void testCreateReverseList() {
		
		Integer[] intArray = {9, 8, 7, 6, 5, 4, 3, 2, 1
		};
		Character[] charArray = {'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'
		};
		String[] stringArray = {"J", "I", "H", "G", "F", "E", "D", "C", "B", "A"
		};
		List<Integer> intList = Arrays.asList(intArray.clone());
		List<Character> charList = Arrays.asList(charArray.clone());
		List<String> stringList = Arrays.asList(stringArray.clone());
		Arrays.sort(intArray);
		Arrays.sort(charArray);
		Arrays.sort(stringArray);
		assertEquals(Arrays.asList(intArray), createReverseList(intList));
		assertEquals(Arrays.asList(charArray), createReverseList(charList));
		assertEquals(Arrays.asList(stringArray), createReverseList(stringList));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#removeElementsFromBegin(int, java.util.Collection)}.
	 */
	@Test
	final void testRemoveElementsFromBeginIntCollectionOfT() {
		
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9
		};
		List<Integer> list = new ArrayList<>(Arrays.asList(array));
		assertIterableEquals(Arrays.asList(6, 7, 8, 9), removeElementsFromBegin(5, list));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#removeElementsFromEnd(int, java.util.Collection)}.
	 */
	@Test
	final void testRemoveElementsFromEndIntCollectionOfT() {
		
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9
		};
		List<Integer> list = new ArrayList<>(Arrays.asList(array));
		assertIterableEquals(Arrays.asList(1, 2, 3, 4), removeElementsFromEnd(5, list));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createPulledElementList(java.util.Collection, net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreatePulledElementCollectionCollectionOfTPullerOfTE() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		assertIterableEquals(Arrays.asList(5, 6, 5, 6, 5), createPulledElementList(Arrays.asList(array), value -> value.length()));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createPulledElementCollection(Object[], net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreatePulledElementCollectionTArrayPullerOfTE() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		assertIterableEquals(Arrays.asList(5, 6, 5, 6, 5), createPulledElementCollection(array, value -> value.length()));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createPulledElementArray(java.util.Collection, net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreatePulledElementArrayCollectionOfTPullerOfTE() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		assertArrayEquals(new Integer[] {5, 6, 5, 6, 5
		}, createPulledElementArray(Arrays.asList(array), value -> value.length()));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createPulledElementArray(Object[], net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreatePulledElementArrayTArrayPullerOfTE() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		assertArrayEquals(new Integer[] {5, 6, 5, 6, 5
		}, createPulledElementArray(array, value -> value.length()));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createMapFromPulledElements(Object[], net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreateMapFromPulledElementsTArrayPullerOfTE() {
		
		Integer[] array = {1, 2, 3, 4, 5
		};
		Map<Integer, String> map = createMapFromPulledElements(array, value -> value + " String");
		assertEquals("1 String", map.get(1));
		assertEquals("2 String", map.get(2));
		assertEquals("3 String", map.get(3));
		assertEquals("4 String", map.get(4));
		assertEquals("5 String", map.get(5));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createMapFromPulledElements(java.util.Collection, net.coretools.core.Puller)}.
	 */
	@Test
	final void testCreateMapFromPulledElementsCollectionOfTPullerOfTE() {
		
		Integer[] array = {1, 2, 3, 4, 5
		};
		Map<Integer, String> map = createMapFromPulledElements(Arrays.asList(array), value -> value + " String");
		assertEquals("1 String", map.get(1));
		assertEquals("2 String", map.get(2));
		assertEquals("3 String", map.get(3));
		assertEquals("4 String", map.get(4));
		assertEquals("5 String", map.get(5));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createElementMap(Object[], Object[])}.
	 */
	@Test
	final void testCreateElementMapTArrayEArray() {
		
		Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9
		};
		String[] values = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth"
		};
		Map<Integer, String> map = createElementMap(keys, values);
		assertEquals("First", map.get(1));
		assertEquals("Second", map.get(2));
		assertEquals("Third", map.get(3));
		assertEquals("Fourth", map.get(4));
		assertEquals("Fifth", map.get(5));
		assertEquals("Sixth", map.get(6));
		assertEquals("Seventh", map.get(7));
		assertEquals("Eighth", map.get(8));
		assertEquals("Ninth", map.get(9));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createElementMap(java.util.Collection, java.util.Collection)}.
	 */
	@Test
	final void testCreateElementMapCollectionOfTCollectionOfE() {
		
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<String> values = Arrays.asList("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth");
		Map<Integer, String> map = createElementMap(keys, values);
		assertEquals("First", map.get(1));
		assertEquals("Second", map.get(2));
		assertEquals("Third", map.get(3));
		assertEquals("Fourth", map.get(4));
		assertEquals("Fifth", map.get(5));
		assertEquals("Sixth", map.get(6));
		assertEquals("Seventh", map.get(7));
		assertEquals("Eighth", map.get(8));
		assertEquals("Ninth", map.get(9));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createSingleNullCollection()}.
	 */
	@Test
	final void testCreateSingleNullCollection() {
		
		assertEquals(Arrays.asList((Object) null), singleNullCollection());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createSingleNullList()}.
	 */
	@Test
	final void testCreateSingleNullList() {
		
		assertEquals(Arrays.asList((Object) null), singleNullCollection());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createArrayIterator(Object[])}.
	 */
	@Test
	final void testCreateArrayIterator() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		Iterator<String> iterator = arrayIterator(array);
		for(int i = 0; i < array.length; i++) {
			assertEquals(array[i], iterator.next());
		}
		assertFalse(iterator.hasNext());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.CollectionTools#createTIterator(Object[])}.
	 */
	@Test
	final void testCreateTIterator() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		Iterator<String> iterator = tIterator(array);
		for(int i = 0; i < array.length; i++) {
			assertEquals(array[i], iterator.next());
		}
		assertFalse(iterator.hasNext());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.CollectionTools#predicate(Collection, java.util.function.Predicate)}.
 * 
 * @param <T> Any generic type.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "First, Second, Third, Fourth, Fifth", "a, b, c, d, e"})
	final <T> void testPredicate(T first, T second, T third, T fourth, T fifth) {
		
		Collection<T> collection = createModifiableListOf(first, second, third, fourth, fifth);
		
		assertTrue(predicate(collection, t -> t == first));
		assertTrue(predicate(collection, t -> t == second));
		assertTrue(predicate(collection, t -> t == third));
		assertTrue(predicate(collection, t -> t == fourth));
		assertTrue(predicate(collection, t -> t == fifth));
		assertFalse(predicate(collection, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
}
