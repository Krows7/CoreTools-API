package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Values} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class ValuesTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Values#Values(java.lang.Object[])}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testValues() {
		
		new Values();
		new Values((String) null);
		new Values("");
		new Values("", null);
		new Values("-start", "");
		new Values("-start", null);
		new Values("-start");
		new Values("-start", "color");
		new Values("-start", "color", "-debug");
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Values#getValues()}.
	 */
	@Test
	final void testGetValues() {
		
		Object[] array = {null, "RED", null, 1
		};
		assertArrayEquals(array, new Values(array).getValues());
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Values#toString()}.
	 */
	@Test
	final void testToString() {
		
		Object[] array = {null, "RED", null, 1
		};
		assertEquals(String.format("[%s, %s, %s, %s]", array[0], array[1], array[2], array[3]), new Values(array).toString());
	}
}
