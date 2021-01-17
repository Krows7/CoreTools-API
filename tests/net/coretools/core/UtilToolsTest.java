package net.coretools.core;

import static net.coretools.core.UtilTools.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * 
 * JUnit tests for {@link UtilTools} class.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
class UtilToolsTest {
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#forLoop(int, java.util.function.IntConsumer)}.
 * 
 * @param n Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "10", "50"})
	final void testForLoop(int n) {
		
		AtomicInteger i = new AtomicInteger(0);
		
		forLoop(n, index -> assertEquals(i.getAndIncrement(), index));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#reverseForLoop(int, java.util.function.IntConsumer)}.
 * 
 * @param n Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "10", "50"})
	final void testReverseForLoop(int n) {
		
		AtomicInteger i = new AtomicInteger(n);
		
		reverseForLoop(n, index -> assertEquals(i.getAndDecrement(), index));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#after(java.lang.Object, java.util.function.Consumer)}.
 * 
 * @param n Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "10", "50"})
	final void testAfter(int n) {
		
		AtomicInteger i = new AtomicInteger(n - 1);
		
		assertNotEquals(n, i.get());
		assertEquals(n, after(i, i1 -> i1.set(n)).get());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#ifMatch(java.lang.Object, java.util.function.Predicate, java.util.function.Consumer)}.
 * 
 * @param n Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "10", "50"})
	final void testIfMatch(int n) {
		
		AtomicInteger i = new AtomicInteger(n);
		
		ifMatch(i, index -> index.get() <= 10, index -> assertTrue(index.get() <= 10));
		ifMatch(i, index -> index.get() > 10, index -> assertTrue(index.get() > 10));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#ifMatchGet(java.lang.Object, java.util.function.Predicate, java.util.function.Consumer)}.
 * 
 * @param n Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "10", "50"})
	final void testIfMatchGet(int n) {
		
		AtomicInteger i = new AtomicInteger(n);
		
		assertEquals(n + n, ifMatchGet(i, index -> index.get() == n, index -> index.addAndGet(n)).get());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#getObjectClass(java.lang.Class)}.
 * 
 */
	@Test
	final void testGetObjectClass() {
		
		assertEquals(Object.class, getObjectClass(Object[].class));
		assertEquals(Object.class, getObjectClass(Object.class));
		
		assertEquals(String.class, getObjectClass(String[].class));
		assertEquals(String.class, getObjectClass(String.class));
		
		assertEquals(byte.class, getObjectClass(byte[].class));
		assertEquals(byte.class, getObjectClass(byte.class));
		
		assertEquals(short.class, getObjectClass(short[].class));
		assertEquals(short.class, getObjectClass(short.class));
		
		assertEquals(int.class, getObjectClass(int[].class));
		assertEquals(int.class, getObjectClass(int.class));
		
		assertEquals(long.class, getObjectClass(long[].class));
		assertEquals(long.class, getObjectClass(long.class));
		
		assertEquals(double.class, getObjectClass(double[].class));
		assertEquals(double.class, getObjectClass(double.class));
		
		assertEquals(float.class, getObjectClass(float[].class));
		assertEquals(float.class, getObjectClass(float.class));
		
		assertEquals(char.class, getObjectClass(char[].class));
		assertEquals(char.class, getObjectClass(char.class));
		
		assertEquals(boolean.class, getObjectClass(boolean[].class));
		assertEquals(boolean.class, getObjectClass(boolean.class));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.UtilTools#cast(java.lang.Object)}.
 * 
 */
	@SuppressWarnings("cast")
	@Test
	final void testCast() {
		
		Object o = "Hello";
		
		assertEquals((String) o, cast(o));
		assertEquals(o, cast(o));
		assertEquals("Hello", cast(o));
	}
}
