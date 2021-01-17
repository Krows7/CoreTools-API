package net.coretools.core;

import static org.junit.jupiter.api.Assertions.*;
import static net.coretools.core.MathTools.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit tests for {@link MathTools} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class MathToolsTest {
	
	/**
	 * Test method for {@link net.coretools.core.MathTools#divide(int, int)}.
	 */
	@Test
	final void testDivideIntInt() {
		
		assertEquals(3.0 / 2.0, divide(3, 2));
		assertEquals(1.0 / 1.0, divide(1, 1));
		assertEquals(0.0 / 2.0, divide(0, 2));
		assertEquals( - 3.0 / 2.0, divide( - 3, 2));
		assertEquals( - 3.0 / - 2.0, divide( - 3, - 2));
		assertEquals( - 0.0 / - 2.0, divide( - 0, - 2));
	}
	
	/**
	 * Test method for {@link net.coretools.core.MathTools#divide(long, long)}.
	 */
	@Test
	final void testDivideLongLong() {
		
		assertEquals(3.0 / 2.0, divide((long) 3, (long) 2));
		assertEquals(1.0 / 1.0, divide((long) 1, (long) 1));
		assertEquals(0.0 / 2.0, divide((long) 0, (long) 2));
		assertEquals( - 3.0 / 2.0, divide((long) - 3, (long) 2));
		assertEquals( - 3.0 / - 2.0, divide((long) - 3, (long) - 2));
		assertEquals( - 0.0 / - 2.0, divide((long) - 0, (long) - 2));
	}
	
	/**
	 * Test method for {@link net.coretools.core.MathTools#mod(double)}.
	 */
	@Test
	final void testModDouble() {
		
		assertEquals(1.0, mod(1.0));
		assertEquals(10.0, mod(10.0));
		assertEquals(10.0, mod( - 10.0));
		assertEquals(0.0, mod(0.0));
	}
	
	/**
	 * Test method for {@link net.coretools.core.MathTools#mod(int)}.
	 */
	@Test
	final void testModInt() {
		
		assertEquals(1, mod(1));
		assertEquals(10, mod(10));
		assertEquals(10, mod( - 10));
		assertEquals(0, mod(0));
	}
	
	/**
	 * Test method for {@link net.coretools.core.MathTools#mod(long)}.
	 */
	@Test
	final void testModLong() {
		
		assertEquals(1, mod((long) 1));
		assertEquals(10, mod((long) 10));
		assertEquals(10, mod((long) - 10));
		assertEquals(0, mod((long) 0));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.MathTools#isOtherValues(double, double)}.
	 */
	@Test
	final void testIsOtherValuesDoubleDouble() {
		
		assertTrue(isOtherValues(1.0, - 1.0));
		assertTrue(isOtherValues( - 1.0, 1.0));
		assertTrue(isOtherValues(1.0, 0.0));
		assertTrue(isOtherValues( - 1.0, 0.0));
		assertTrue(isOtherValues(0.0, 1.0));
		assertTrue(isOtherValues(0.0, - 1.0));
		assertFalse(isOtherValues(1.0, 1.0));
		assertFalse(isOtherValues(0.0, 0.0));
		assertFalse(isOtherValues( - 1.0, - 1.0));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.MathTools#isOtherValues(int, int)}.
	 */
	@Test
	final void testIsOtherValuesIntInt() {
		
		assertTrue(isOtherValues(1, - 1));
		assertTrue(isOtherValues( - 1, 1));
		assertTrue(isOtherValues(1, 0));
		assertTrue(isOtherValues( - 1, 0));
		assertTrue(isOtherValues(0, 1));
		assertTrue(isOtherValues(0, - 1));
		assertFalse(isOtherValues(1, 1));
		assertFalse(isOtherValues(0, 0));
		assertFalse(isOtherValues( - 1, - 1));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.MathTools#isOtherValues(long, long)}.
	 */
	@Test
	final void testIsOtherValuesLongLong() {
		
		assertTrue(isOtherValues((long) 1, (long) - 1));
		assertTrue(isOtherValues((long) - 1, (long) 1));
		assertTrue(isOtherValues((long) 1, (long) 0));
		assertTrue(isOtherValues((long) - 1, (long) 0));
		assertTrue(isOtherValues((long) 0, (long) 1));
		assertTrue(isOtherValues((long) 0, (long) - 1));
		assertFalse(isOtherValues((long) 1, (long) 1));
		assertFalse(isOtherValues((long) 0, (long) 0));
		assertFalse(isOtherValues((long) - 1, (long) - 1));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.MathTools#map(double, double, double, double, double)}.
	 * 
	 * @param value Object for tests.
	 * @param result Object for tests.
	 * 
	 */
	@ParameterizedTest
	@CsvSource({"0, 50", "1, 50.5", "2, 51", "10, 55", "50, 75", "100, 100", "125, 100"})
	final void testMapDoubleDoubleDoubleDoubleDouble(double value, double result) {
		
		assertEquals(result, map(value, 0, 100, 50, 100));
	}
}