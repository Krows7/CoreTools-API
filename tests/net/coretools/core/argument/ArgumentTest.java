package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Argument} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class ArgumentTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Argument#Argument(java.lang.String)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentString() {
		
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
	 * {@link net.coretools.core.argument.Argument#Argument(java.lang.String, java.lang.Object)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentStringObject() {
		
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
	 * {@link net.coretools.core.argument.Argument#getVariable()}.
	 */
	@Test
	final void testGetVariable() {
		
		assertEquals("Hello", new Argument("Hello").getVariable());
		assertEquals("World", new Argument("World").getVariable());
		assertEquals("-start", new Argument("-start").getVariable());
		assertEquals("color", new Argument("color").getVariable());
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Argument#getValue()}.
	 */
	@Test
	final void testGetValue() {
		
		assertEquals("World", new Argument("Hello", "World").getValue());
		assertEquals(null, new Argument("World").getValue());
		assertEquals(null, new Argument("-start").getValue());
		assertEquals("red", new Argument("color", "red").getValue());
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Argument#toString()}.
	 */
	@Test
	final void testToString() {
		
		String msg = "net.coretools.core.argument.Argument[variable: %s; value: %s]";
		assertEquals(String.format(msg, "color", "red"), new Argument("color", "red").toString());
		assertEquals(String.format(msg, "Hello", "World"), new Argument("Hello", "World").toString());
		assertEquals(String.format(msg, "-start", null), new Argument("-start").toString());
		assertEquals(String.format(msg, "auto", null), new Argument("auto").toString());
	}
}
