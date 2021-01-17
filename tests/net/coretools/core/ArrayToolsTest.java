package net.coretools.core;

import static net.coretools.core.ArrayTools.appendArrays;
import static net.coretools.core.ArrayTools.castToObjectArray;
import static net.coretools.core.ArrayTools.createArray;
import static net.coretools.core.ArrayTools.createArrayFromIterator;
import static net.coretools.core.ArrayTools.elementArray;
import static net.coretools.core.ArrayTools.filledOf;
import static net.coretools.core.ArrayTools.forEach;
import static net.coretools.core.ArrayTools.forIndex;
import static net.coretools.core.ArrayTools.isEmptyArray;
import static net.coretools.core.ArrayTools.isFullArray;
import static net.coretools.core.ArrayTools.predicate;
import static net.coretools.core.ArrayTools.predicateByte;
import static net.coretools.core.ArrayTools.predicateChar;
import static net.coretools.core.ArrayTools.predicateDouble;
import static net.coretools.core.ArrayTools.predicateFloat;
import static net.coretools.core.ArrayTools.predicateInt;
import static net.coretools.core.ArrayTools.predicateLong;
import static net.coretools.core.ArrayTools.predicateShort;
import static net.coretools.core.ArrayTools.removeElementsFromBegin;
import static net.coretools.core.ArrayTools.removeElementsFromEnd;
import static net.coretools.core.ArrayTools.singleNullArray;
import static net.coretools.core.ArrayTools.singletonArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * 
 * JUnit tests for {@link ArrayTools} class.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
class ArrayToolsTest {
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#forEach(Object[], java.util.function.Consumer)}.
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
		final void testForEach(Object first, Object second, Object third, Object fourth, Object fifth) {
			
			Object[] array = {first, second, third, fourth, fifth};
			
			List<Object> list = new ArrayList<>();
			
			forEach(array, value -> list.add(value));
					
			assertArrayEquals(new Object[] {first.toString(), 
												second.toString(), 
													third.toString(), 
														fourth.toString(), 
															fifth.toString()}, list.toArray());
		}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#forIndex(Object[], java.util.function.Consumer)}.
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
	final void testForIndex(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		Object[] array = {first, second, third, fourth, fifth};
		
		assertArrayEquals(new Object[] {first.toString(), 
											second.toString(), 
												third.toString(), 
													fourth.toString(), 
														fifth.toString()}, forIndex(array, index -> array[index] = array[index].toString()));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#filledOf(java.lang.Object, int)}.
 * 
 * @param o Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"Test", "1", "Hello World!"})
	final void testFilledOfTInt(Object o) {
		
		Object[] array = {o, o, o, o, o};
		
		assertArrayEquals(array, filledOf(o, 5));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#filledOf(Object[], java.lang.Object)}.
 * 
 * @param o Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"Test", "1", "Hello World!"})
	final void testFilledOfTArrayT(Object o) {
		
		Object[] array = {o, o, o, o, o};
		
		assertArrayEquals(array, filledOf(new Object[5], o));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#removeElementsFromBegin(int, Object[])}.
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
	final void testRemoveElementsFromBegin(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		Object[] array = {third, fourth, fifth};
		
		assertArrayEquals(array, removeElementsFromBegin(2, new Object[] {first, second, third, fourth, fifth}));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#removeElementsFromEnd(int, Object[])}.
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
	final void testRemoveElementsFromEnd(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		Object[] array = {first, second, third};
		
		assertArrayEquals(array, removeElementsFromEnd(2, new Object[] {first, second, third, fourth, fifth}));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#createSingletonArray(java.lang.Object)}.
 * 
 * @param o Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"Test", "1", "Hello World!"})
	final void testCreateSingletonArray(Object o) {
		
		Object[] array = {o};
		
		assertArrayEquals(array, singletonArray(o));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#createSingleNullArray()}.
 * 
 */
	@Test
	final void testCreateSingleNullArray() {
		
		Object[] array = {null};
		
		assertArrayEquals(array, singleNullArray());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#elementArray(Object[])}.
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
	final void testCreateElementArray(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		Object[] array = {first, second, third, fourth, fifth};
		
		assertArrayEquals(array, elementArray(first, second, third, fourth, fifth));
	}
	
/**
 * Test method for {@link net.coretools.core.ArrayTools#appendArrays(Object[][])}.
 * 
 * @param f1 Object for tests.
 * @param f2 Object for tests.
 * @param f3 Object for tests.
 * @param s1 Object for tests.
 * @param s2 Object for tests.
 * @param s3 Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5, 6", "First, Second, Third, Fourth, Fifth, Sixth", "a, b, c, d, e, f"})
	final void testAppendArrays(Object f1, Object f2, Object f3, Object s1, Object s2, Object s3) {
		
		Object[] array = {f1, f2, f3, s1, s2, s3};
		
		Object[] first = {f1, f2, f3};
		Object[] second = {s1, s2, s3};
		
		assertArrayEquals(array, appendArrays(first, second));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#isEmptyArray(java.lang.Object[])}.
 * 
 */
	@Test
	final void testIsEmptyArray() {
		
		assertTrue(isEmptyArray(new Object[5]));
		assertFalse(isEmptyArray(new Object[] {1, 2, 3, 4, 5}));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#isFullArray(java.lang.Object[])}.
 * 
 */
	@Test
	final void testIsFullArrayObjectArray() {
		
		assertFalse(isFullArray(new Object[0]));
		assertFalse(isFullArray(new Object[5]));
		assertTrue(isFullArray(new Object[] {1, 2, 3, 4, 5}));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#isFullArray(java.lang.Object[], java.lang.Object)}.
 * 
 * @param o Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"Test", "1", "Hello World!"})
	final void testIsFullArrayObjectArrayObject(Object o) {
		
		assertFalse(isFullArray(new Object[0], o));
		assertFalse(isFullArray(new Object[5], o));
		assertTrue(isFullArray(new Object[] {o}, o));
		assertFalse(isFullArray(new Object[] {o, o.toString() + "1"}, o));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#isFullArray(java.lang.Object[], java.lang.Object[])}.
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
	final void testIsFullArrayObjectArrayObjectArray(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		assertFalse(isFullArray(new Object[0], first, second, third, fourth, fifth));
		assertFalse(isFullArray(new Object[5], first, second, third, fourth, fifth));
		assertTrue(isFullArray(new Object[] {first}, first, second, third, fourth, fifth));
		assertTrue(isFullArray(new Object[] {first, second, third, fourth, fifth}, first, second, third, fourth, fifth));
		assertFalse(isFullArray(new Object[] {first, second.hashCode()}, first, second, third, fourth, fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicate(Object[], java.util.function.Predicate)}.
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
		
		Object[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicate(array, t -> t == first));
		assertTrue(predicate(array, t -> t == second));
		assertTrue(predicate(array, t -> t == third));
		assertTrue(predicate(array, t -> t == fourth));
		assertTrue(predicate(array, t -> t == fifth));
		assertFalse(predicate(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateByte(byte[], java.util.function.IntPredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "10, 20, 30, 40, 50", "-1, -2, -3, -4, -5"})
	final void testPredicateByte(byte first, byte second, byte third, byte fourth, byte fifth) {
		
		byte[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateByte(array, t -> t == first));
		assertTrue(predicateByte(array, t -> t == second));
		assertTrue(predicateByte(array, t -> t == third));
		assertTrue(predicateByte(array, t -> t == fourth));
		assertTrue(predicateByte(array, t -> t == fifth));
		assertFalse(predicateByte(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateShort(short[], java.util.function.IntPredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "10, 20, 30, 40, 50", "-1, -2, -3, -4, -5"})
	final void testPredicateShort(short first, short second, short third, short fourth, short fifth) {
		
		short[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateShort(array, t -> t == first));
		assertTrue(predicateShort(array, t -> t == second));
		assertTrue(predicateShort(array, t -> t == third));
		assertTrue(predicateShort(array, t -> t == fourth));
		assertTrue(predicateShort(array, t -> t == fifth));
		assertFalse(predicateShort(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateInt(int[], java.util.function.IntPredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "10, 20, 30, 40, 50", "-1, -2, -3, -4, -5"})
	final void testPredicateInt(int first, int second, int third, int fourth, int fifth) {
		
		int[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateInt(array, t -> t == first));
		assertTrue(predicateInt(array, t -> t == second));
		assertTrue(predicateInt(array, t -> t == third));
		assertTrue(predicateInt(array, t -> t == fourth));
		assertTrue(predicateInt(array, t -> t == fifth));
		assertFalse(predicateInt(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateChar(char[], java.util.function.IntPredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"a, b, c, d, e", "A, B, C, D, E", "A, b, C, D, e"})
	final void testPredicateChar(char first, char second, char third, char fourth, char fifth) {
		
		char[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateChar(array, t -> t == first));
		assertTrue(predicateChar(array, t -> t == second));
		assertTrue(predicateChar(array, t -> t == third));
		assertTrue(predicateChar(array, t -> t == fourth));
		assertTrue(predicateChar(array, t -> t == fifth));
		assertFalse(predicateChar(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateLong(long[], java.util.function.LongPredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "10, 20, 30, 40, 50", "-1, -2, -3, -4, -5"})
	final void testPredicateLong(long first, long second, long third, long fourth, long fifth) {
		
		long[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateLong(array, t -> t == first));
		assertTrue(predicateLong(array, t -> t == second));
		assertTrue(predicateLong(array, t -> t == third));
		assertTrue(predicateLong(array, t -> t == fourth));
		assertTrue(predicateLong(array, t -> t == fifth));
		assertFalse(predicateLong(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateDouble(double[], java.util.function.DoublePredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1.0, 2.0, 3.0, 4.0, 5.0", "10.0, 20.0, 30.0, 40.0, 50.0", "-1.0, -2.0, -3.0, -4.0, -5.0"})
	final void testPredicateDouble(double first, double second, double third, double fourth, double fifth) {
		
		double[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateDouble(array, t -> t == first));
		assertTrue(predicateDouble(array, t -> t == second));
		assertTrue(predicateDouble(array, t -> t == third));
		assertTrue(predicateDouble(array, t -> t == fourth));
		assertTrue(predicateDouble(array, t -> t == fifth));
		assertFalse(predicateDouble(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#predicateFloat(float[], java.util.function.DoublePredicate)}.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1.0, 2.0, 3.0, 4.0, 5.0", "10.0, 20.0, 30.0, 40.0, 50.0", "-1.0, -2.0, -3.0, -4.0, -5.0"})
	final void testPredicateFloat(float first, float second, float third, float fourth, float fifth) {
		
		float[] array = {first, second, third, fourth, fifth};
		
		assertTrue(predicateFloat(array, t -> t == first));
		assertTrue(predicateFloat(array, t -> t == second));
		assertTrue(predicateFloat(array, t -> t == third));
		assertTrue(predicateFloat(array, t -> t == fourth));
		assertTrue(predicateFloat(array, t -> t == fifth));
		assertFalse(predicateFloat(array, t -> t != first && t != second && t != third && t != fourth && t != fifth));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#createArrayFromIterator(java.util.Iterator)}.
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
	final void testCreateArrayFromIterator(Object first, Object second, Object third, Object fourth, Object fifth) {
		
		Object[] array = {first, second, third, fourth, fifth};
		
//			Tests of net.coretools.core.CollectionTools.createTIterator(T[]) contains in tests.net.coretools.core.CollectionToolsTest.testCreateTIterator(Object[]).
		Iterator<Object> iterator = CollectionTools.tIterator(first, second, third, fourth, fifth);
		
		assertArrayEquals(array, createArrayFromIterator(iterator));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#castToObjectArray(Object[])}.
 * 
 * @param <T> Generic type for tests.
 * 
 * @param first Object for tests.
 * @param second Object for tests.
 * @param third Object for tests.
 * @param fourth Object for tests.
 * @param fifth Object for tests.
 * 
 */
	@SuppressWarnings({"cast", "unchecked"})
	@ParameterizedTest
	@CsvSource({"1, 2, 3, 4, 5", "First, Second, Third, Fourth, Fifth", "a, b, c, d, e"})
	final <T> void testCastToObjectArray(T first, T second, T third, T fourth, T fifth) {
		
		Object[] array = castToObjectArray(first, second, third, fourth, fifth);
		
		assertEquals(first, (T) array[0]);
		assertEquals(second, (T) array[1]);
		assertEquals(third, (T) array[2]);
		assertEquals(fourth, (T) array[3]);
		assertEquals(fifth, (T) array[4]);
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#createArray(java.lang.Object)}.
 * 
 */
	@Test
	final void testCreateArrayT() {
		
		assertArrayEquals(new Object[0], createArray(new Object()));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ArrayTools#createArray(java.lang.Object, int)}.
 * 
 */
	@Test
	final void testCreateArrayTInt() {
		
		assertArrayEquals(new Object[5], createArray(new Object(), 5));
	}
	
	final void testCreateSortedArrayTPredicate() {
		
//		createSortedArray(array, predicate);
	}
}
