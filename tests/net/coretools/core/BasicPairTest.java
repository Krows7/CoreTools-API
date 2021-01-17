package net.coretools.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link BasicPair} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class BasicPairTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.BasicPair#BasicPair(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testBasicPair() {
		
		BasicPair<String, String> firstPair = new BasicPair<>("Hello", "Hi");
		BasicPair<Integer, Integer> secondPair = new BasicPair<>(546, - 5324);
		assertEquals("Hello", firstPair.getFirst());
		assertEquals("Hi", firstPair.getSecond());
		assertEquals((Integer) 546, secondPair.getFirst());
		assertEquals((Integer) ( - 5324), secondPair.getSecond());
	}
	
	/**
	 * Test method for {@link net.coretools.core.BasicPair#getFirst()}.
	 */
	@Test
	final void testGetFirst() {
		
		BasicPair<String, String> firstPair = new BasicPair<>("Hello", "Hi");
		BasicPair<Integer, Integer> secondPair = new BasicPair<>(546, - 5324);
		assertEquals("Hello", firstPair.getFirst());
		assertEquals((Integer) 546, secondPair.getFirst());
	}
	
	/**
	 * Test method for {@link net.coretools.core.BasicPair#getSecond()}.
	 */
	@Test
	final void testGetSecond() {
		
		BasicPair<String, String> firstPair = new BasicPair<>("Hello", "Hi");
		BasicPair<Integer, Integer> secondPair = new BasicPair<>(546, - 5324);
		assertEquals("Hi", firstPair.getSecond());
		assertEquals((Integer) ( - 5324), secondPair.getSecond());
	}
}
