package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link StringArgument} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class StringArgumentTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.StringArgument#StringArgument(java.lang.String)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testStringArgumentString() {
		
		assertThrows(ArgumentException.class, () -> {
			new Argument(null);
		});
		assertThrows(ArgumentException.class, () -> {
			new Argument("");
		});
		Argument first = new Argument("Hello");
		Argument second = new Argument("World");
		assertEquals("Hello", first.getVariable());
		assertEquals(null, first.getValue());
		assertEquals("World", second.getVariable());
		assertEquals(null, second.getValue());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.StringArgument#StringArgument(java.lang.String, java.lang.String)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testStringArgumentStringString() {
		
		assertThrows(ArgumentException.class, () -> {
			new Argument(null, "Hello");
		});
		assertThrows(ArgumentException.class, () -> {
			new Argument("", "Hello");
		});
		Argument first = new Argument("Hello", null);
		Argument second = new Argument("Hello", "World");
		assertEquals("Hello", first.getVariable());
		assertEquals(null, first.getValue());
		assertEquals("Hello", second.getVariable());
		assertEquals("World", second.getValue());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.StringArgument#getValue()}.
	 */
	@Test
	final void testGetValue() {
		
		assertEquals("World", new Argument("Hello", "World").getValue());
		assertEquals(null, new Argument("World").getValue());
		assertEquals(null, new Argument("-start").getValue());
		assertEquals("red", new Argument("color", "red").getValue());
	}
}
