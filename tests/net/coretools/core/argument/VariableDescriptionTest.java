package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link VariableDescription} class.
 * 
 * @since 1.5.0
 * 
 * @author Krows
 * 
 */
class VariableDescriptionTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.VariableDescription#VariableDescription(java.lang.String, java.lang.String)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testVariableDescription() {
		
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription(null, "");
		});
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription("", "");
		});
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription(null, null);
		});
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription("", null);
		});
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription(null, "Description");
		});
		assertThrows(ArgumentException.class, () -> {
			new VariableDescription("", "Description");
		});
		new VariableDescription("-start", "");
		new VariableDescription("-start", null);
		new VariableDescription("-start", "Description");
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.VariableDescription#getVariable()}.
	 */
	@Test
	final void testGetVariable() {
		
		assertEquals("-start", new VariableDescription("-start", "").getVariable());
		assertEquals("color", new VariableDescription("color", "").getVariable());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.VariableDescription#getDescription()}.
	 */
	@Test
	final void testGetDescription() {
		
		assertEquals("Description", new VariableDescription("-start", "Description").getDescription());
		assertEquals("", new VariableDescription("-start", "").getDescription());
		assertEquals(null, new VariableDescription("-start", null).getDescription());
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.VariableDescription#toString()}.
	 */
	@Test
	final void testToString() {
		
		String msg = "[%s: %s]";
		assertEquals(String.format(msg, "-start", "Description"), new VariableDescription("-start", "Description").toString());
		assertEquals(String.format(msg, "color", "Description"), new VariableDescription("color", "Description").toString());
		assertEquals(String.format(msg, "-debug", "Description"), new VariableDescription("-debug", "Description").toString());
	}
}
