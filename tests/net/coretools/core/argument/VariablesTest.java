package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Variables} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class VariablesTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Variables#Variables(java.lang.String[])}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testVariables() {
		
		assertThrows(ArgumentException.class, () -> {
			new Variables();
		});
		assertThrows(ArgumentException.class, () -> {
			new Variables((String) null);
		});
		assertThrows(ArgumentException.class, () -> {
			new Variables("");
		});
		assertThrows(ArgumentException.class, () -> {
			new Variables("", null);
		});
		assertThrows(ArgumentException.class, () -> {
			new Variables("-start", "");
		});
		assertThrows(ArgumentException.class, () -> {
			new Variables("-start", null);
		});
		new Variables("-start");
		new Variables("-start", "color");
		new Variables("-start", "color", "-debug");
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Variables#getVariables()}.
	 */
	@Test
	final void testGetVariables() {
		
		String[] array = {"-start", "color", "-debug"
		};
		assertArrayEquals(array, new Variables(array).getVariables());
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Variables#toString()}.
	 */
	@Test
	final void testToString() {
		
		String[] array = {"-start", "color", "-debug"
		};
		assertEquals(String.format("[%s, %s, %s]", array[0], array[1], array[2]), new Variables(array).toString());
	}
}
