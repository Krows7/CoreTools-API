package net.coretools.core;

import static net.coretools.core.ObjectTools.contains;
import static net.coretools.core.ObjectTools.containsObject;
import static net.coretools.core.ObjectTools.differentObjectOrIfNull;
import static net.coretools.core.ObjectTools.differentObjectOrNull;
import static net.coretools.core.ObjectTools.differentOrIfNull;
import static net.coretools.core.ObjectTools.differentOrNull;
import static net.coretools.core.ObjectTools.random;
import static net.coretools.core.ObjectTools.randomObject;
import static net.coretools.core.ObjectTools.valueObjectOrIfNull;
import static net.coretools.core.ObjectTools.valueObjectOrNull;
import static net.coretools.core.ObjectTools.valueOrIfNull;
import static net.coretools.core.ObjectTools.valueOrNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit tests for {@link ObjectTools} class.
 * 
 * @since 1.5.0
 * 
 * @author Krows
 * 
 */
class ObjectToolsTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#containsObject(java.lang.Object, java.lang.Object[])}.
	 */
	@Test
	final void testContainsObject() {
		
		Integer[] intArray = {1, 2, 3, 4, 5
		};
		String[] stringArray = {"A", "B", "C", "D", "E"
		};
		Character[] charArray = {'a', 'b', 'c', 'd', 'e'
		};
		assertTrue(containsObject(3, (Object[]) intArray));
		assertFalse(containsObject(0, (Object[]) intArray));
		assertTrue(containsObject("D", (Object[]) stringArray));
		assertFalse(containsObject("d", (Object[]) stringArray));
		assertTrue(containsObject('e', (Object[]) charArray));
		assertFalse(containsObject('t', (Object[]) charArray));
	}
	
	/**
	 * Test method for {@link ObjectTools#contains(String, String[])}.
	 */
	@Test
	final void testContainsStringStringArray() {
		
		String[] array = {"First", "Second", "Third", "Fourth", "Fifth"
		};
		assertTrue(contains("First", array));
		assertTrue(contains("Second", array));
		assertTrue(contains("Third", array));
		assertTrue(contains("Fourth", array));
		assertTrue(contains("Fifth", array));
		assertFalse(contains("", array));
		assertFalse(contains("Sixth", array));
		assertFalse(contains("gregregre", array));
		assertFalse(contains(null, array));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(byte, byte[])}.
	 */
	@Test
	final void testContainsByteByteArray() {
		
		byte[] first = {1, 2, 3, 4, 5
		};
		byte[] second = {0, - 1, - 2, - 3, - 4, - 5
		};
		assertTrue(contains((byte) 1, first));
		assertTrue(contains((byte) 5, first));
		assertFalse(contains((byte) 0, first));
		assertFalse(contains((byte) 43, first));
		assertFalse(contains((byte) - 1, first));
		assertTrue(contains((byte) - 1, second));
		assertTrue(contains((byte) - 5, second));
		assertTrue(contains((byte) 0, second));
		assertFalse(contains((byte) - 43, second));
		assertFalse(contains((byte) 1, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(short, short[])}.
	 */
	@Test
	final void testContainsShortShortArray() {
		
		short[] first = {1, 2, 3, 4, 5
		};
		short[] second = {0, - 1, - 2, - 3, - 4, - 5
		};
		assertTrue(contains((short) 1, first));
		assertTrue(contains((short) 5, first));
		assertFalse(contains((short) 0, first));
		assertFalse(contains((short) 43, first));
		assertFalse(contains((short) - 1, first));
		assertTrue(contains((short) - 1, second));
		assertTrue(contains((short) - 5, second));
		assertTrue(contains((short) 0, second));
		assertFalse(contains((short) - 43, second));
		assertFalse(contains((short) 1, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(int, int[])}.
	 */
	@Test
	final void testContainsIntIntArray() {
		
		int[] first = {1, 2, 3, 4, 5
		};
		int[] second = {0, - 1, - 2, - 3, - 4, - 5
		};
		assertTrue(contains(1, first));
		assertTrue(contains(5, first));
		assertFalse(contains(0, first));
		assertFalse(contains(43, first));
		assertFalse(contains( - 1, first));
		assertTrue(contains( - 1, second));
		assertTrue(contains( - 5, second));
		assertTrue(contains(0, second));
		assertFalse(contains( - 43, second));
		assertFalse(contains(1, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(long, long[])}.
	 */
	@Test
	final void testContainsLongLongArray() {
		
		long[] first = {1, 2, 3, 4, 5
		};
		long[] second = {0, - 1, - 2, - 3, - 4, - 5
		};
		assertTrue(contains(1, first));
		assertTrue(contains(5, first));
		assertFalse(contains(0, first));
		assertFalse(contains(43, first));
		assertFalse(contains( - 1, first));
		assertTrue(contains( - 1, second));
		assertTrue(contains( - 5, second));
		assertTrue(contains(0, second));
		assertFalse(contains( - 43, second));
		assertFalse(contains(1, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(double, double[])}.
	 */
	@Test
	final void testContainsDoubleDoubleArray() {
		
		double[] first = {1.0, 2.0, 3.0, 4.0, 5.0
		};
		double[] second = {0.0, - 1.0, - 2.0, - 3.0, - 4.0, - 5.0
		};
		assertTrue(contains(1.0, first));
		assertTrue(contains(5.0, first));
		assertFalse(contains(0.0, first));
		assertFalse(contains(43.0, first));
		assertFalse(contains( - 1.0, first));
		assertTrue(contains( - 1.0, second));
		assertTrue(contains( - 5.0, second));
		assertTrue(contains(0.0, second));
		assertFalse(contains( - 43.0, second));
		assertFalse(contains(1.0, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(float, float[])}.
	 */
	@Test
	final void testContainsFloatFloatArray() {
		
		float[] first = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f
		};
		float[] second = {0.0f, - 1.0f, - 2.0f, - 3.0f, - 4.0f, - 5.0f
		};
		assertTrue(contains(1.0f, first));
		assertTrue(contains(5.0f, first));
		assertFalse(contains(0.0f, first));
		assertFalse(contains(43.0f, first));
		assertFalse(contains( - 1.0f, first));
		assertTrue(contains( - 1.0f, second));
		assertTrue(contains( - 5.0f, second));
		assertTrue(contains(0.0f, second));
		assertFalse(contains( - 43.0f, second));
		assertFalse(contains(1.0f, second));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(boolean, boolean[])}.
	 */
	@Test
	final void testContainsBooleanBooleanArray() {
		
		boolean[] first = {true, false
		};
		boolean[] second = {true
		};
		boolean[] third = {false
		};
		boolean[] fourth = {};
		assertTrue(contains(true, first));
		assertTrue(contains(false, first));
		assertTrue(contains(true, second));
		assertFalse(contains(false, second));
		assertFalse(contains(true, third));
		assertTrue(contains(false, third));
		assertFalse(contains(true, fourth));
		assertFalse(contains(false, fourth));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#contains(char, char[])}.
	 */
	@Test
	final void testContainsCharCharArray() {
		
		char[] array = {'r', 'f', 'e', 'H'
		};
		assertTrue(contains('r', array));
		assertTrue(contains('f', array));
		assertTrue(contains('e', array));
		assertTrue(contains('H', array));
		assertFalse(contains('h', array));
		assertFalse(contains('A', array));
		assertFalse(contains(' ', array));
	}
	
	/**
	 * Test method for {@link net.coretools.core.ObjectTools#random(Object[])}.
	 */
	@Test
	final void testRandom() {
		
		Object[] array = {1, "Hello", 5.6, 't'
		};
		Object result = random(array);
		for(Object object : array)
			if(result == object) return;
		fail("Not equals");
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#randomObject(java.lang.Object[])}.
	 */
	@Test
	final void testRandomObject() {
		
		Object[] array = {1, "Hello", 5.6, 't'
		};
		Object result = randomObject(array);
		for(Object object : array)
			if(result == object) return;
		fail("Not equals");
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueObjectOrIfNull(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueObjectOrIfNullObjectObject() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals(first, valueObjectOrIfNull(first, "ifNull"));
		assertEquals("ifNull", valueObjectOrIfNull(second, "ifNull"));
		assertEquals(third, valueObjectOrIfNull(third, "ifNull"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueOrIfNull(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueOrIfNullTT() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals(first, valueOrIfNull(first, "ifNull"));
		assertEquals("ifNull", valueOrIfNull(second, "ifNull"));
		assertEquals(third, valueOrIfNull(third, "ifNull"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueObjectOrIfNull(java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueObjectOrIfNullObjectObjectObject() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals("object", valueObjectOrIfNull(first, "object", "ifNull"));
		assertEquals("ifNull", valueObjectOrIfNull(second, "object", "ifNull"));
		assertEquals("object", valueObjectOrIfNull(third, "object", "ifNull"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueObjectOrNull(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueObjectOrNull() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals("object", valueObjectOrNull(first, "object"));
		assertEquals(null, valueObjectOrNull(second, "object"));
		assertEquals("object", valueObjectOrNull(third, "object"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueOrNull(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueOrNullObjectObject() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals("object", valueOrNull(first, "object"));
		assertEquals(null, valueOrNull(second, "object"));
		assertEquals("object", valueOrNull(third, "object"));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ObjectTools#valueOrNull(java.lang.Object, java.util.function.Function)}.
 * 
 * @param object Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1", "2", "3", "a", "b", "c", "Hello!"})
	final void testValueOrNull(String object) {
		
		assertEquals(object, valueOrNull(object, o -> o.substring(0)));
		assertEquals(null, valueOrNull((String) null, o -> o.substring(0)));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#valueOrIfNull(java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testValueOrIfNullTEE() {
		
		Object first = 1;
		Object second = null;
		Object third = "Hello";
		assertEquals("object", valueOrIfNull(first, "object", "ifNull"));
		assertEquals("ifNull", valueOrIfNull(second, "object", "ifNull"));
		assertEquals("object", valueOrIfNull(third, "object", "ifNull"));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.ObjectTools#valueOrIfNull(java.lang.Object, java.util.function.Function, java.lang.Object)}.
 * 
 * @param object Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"1", "2", "3", "a", "b", "c", "Hello!"})
	final void testValueOrIfNull(String object) {
		
		assertEquals(object, valueOrIfNull(object, o -> o.substring(0), "Hello World!"));
		assertEquals("Hello World!", valueOrIfNull((String) null, o -> o.substring(0), "Hello World!"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#differentOrNull(java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testDifferentOrNull() {
		
		assertEquals("Second", differentOrNull("First", "First", "Second"));
		assertEquals("First", differentOrNull("Second", "First", "Second"));
		assertEquals(null, differentOrNull("Third", "First", "Second"));
		assertEquals((Integer) 55, differentOrNull(12, 12, 55));
		assertEquals((Integer) 12, differentOrNull(55, 12, 55));
		assertEquals(null, differentOrNull(39, 12, 55));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#differentObjectOrNull(java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testDifferentObjectOrNull() {
		
		assertEquals("Second", differentObjectOrNull("First", "First", "Second"));
		assertEquals("First", differentObjectOrNull("Second", "First", "Second"));
		assertEquals(null, differentObjectOrNull("Third", "First", "Second"));
		assertEquals(55, differentObjectOrNull(12, 12, 55));
		assertEquals(12, differentObjectOrNull(55, 12, 55));
		assertEquals(null, differentObjectOrNull(39, 12, 55));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#differentOrIfNull(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testDifferentOrIfNull() {
		
		assertEquals("Second", differentOrIfNull("First", "First", "Second", "Null Object"));
		assertEquals("First", differentOrIfNull("Second", "First", "Second", "Null Object"));
		assertEquals("Null Object", differentOrIfNull("Third", "First", "Second", "Null Object"));
		assertEquals(55, differentOrIfNull(12, 12, 55, "Null Object"));
		assertEquals(12, differentOrIfNull(55, 12, 55, "Null Object"));
		assertEquals("Null Object", differentOrIfNull(39, 12, 55, "Null Object"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ObjectTools#differentObjectOrIfNull(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testDifferentObjectOrIfNull() {
		
		assertEquals("Second", differentObjectOrIfNull("First", "First", "Second", "Null Object"));
		assertEquals("First", differentObjectOrIfNull("Second", "First", "Second", "Null Object"));
		assertEquals("Null Object", differentObjectOrIfNull("Third", "First", "Second", "Null Object"));
		assertEquals(55, differentObjectOrIfNull(12, 12, 55, "Null Object"));
		assertEquals(12, differentObjectOrIfNull(55, 12, 55, "Null Object"));
		assertEquals("Null Object", differentObjectOrIfNull(39, 12, 55, "Null Object"));
	}
}
