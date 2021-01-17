package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 
 * JUnit tests for {@link ArgumentBlock} class.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
class ArgumentBlockTest {
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#ArgumentBlock(java.lang.String[])}.
 * 
 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentBlockStringArray() {
		
		assertThrows(NullPointerException.class, () -> new ArgumentBlock((String) null));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock("Hello World!", null));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(""));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(new String[0]));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(new String[5]));
		
		new ArgumentBlock("Hello, World!");
		new ArgumentBlock("Test", "1", "Hello World!");
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#ArgumentBlock(net.coretools.core.argument.VariableDescription[])}.
 * 
 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentBlockVariableDescriptionArray() {
		
		assertThrows(NullPointerException.class, () -> new ArgumentBlock((VariableDescription) null));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(new VariableDescription("Hello, World!", null), null));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(new VariableDescription[0]));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock(new VariableDescription[5]));
		
		new ArgumentBlock(new VariableDescription("Hello, World!", "Hello, World!"));
		new ArgumentBlock(new VariableDescription("Hello, World!", "Hello, World!"), 
								new VariableDescription("Test", "Test"), 
									new VariableDescription("1", "1"));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#checkArguments(net.coretools.core.argument.Argument[])}.
 * 
 */
	@Test
	final void testCheckArguments() {
		
		assertThrows(ArgumentException.class, () -> new ArgumentBlock("Test").checkArguments(new Argument("1")));
		assertThrows(ArgumentException.class, () -> new ArgumentBlock("Test").checkArguments(new Argument("Test"), new Argument("1")));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock("Test").checkArguments((Argument) null));
		
		new ArgumentBlock("Test").checkArguments(new Argument("Test"));
		new ArgumentBlock("Test").checkArguments();
		new ArgumentBlock("Test", "1", "Hello, World!").checkArguments(new Argument("Test"), new Argument("1"), new Argument("Hello, World!"));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#checkVariables(java.lang.String[])}.
 * 
 */
	@Test
	final void testCheckVariables() {
		
		assertThrows(ArgumentException.class, () -> new ArgumentBlock("Test").checkVariables("1"));
		assertThrows(ArgumentException.class, () -> new ArgumentBlock("Test").checkVariables("Test", "1"));
		assertThrows(NullPointerException.class, () -> new ArgumentBlock("Test").checkVariables((String) null));
		
		new ArgumentBlock("Test").checkVariables("Test");
		new ArgumentBlock("Test").checkVariables();
		new ArgumentBlock("Test", "1", "Hello, World!").checkVariables("Test", "1", "Hello, World!");
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#containsVariables(net.coretools.core.argument.Argument[])}.
 * 
 */
	@Test
	final void testContainsVariablesArgumentArray() {
		
		assertThrows(NullPointerException.class, () -> new ArgumentBlock("Test").containsVariables((Argument) null));
		
		assertFalse(new ArgumentBlock("Test").containsVariables(new Argument("1")));
		assertFalse(new ArgumentBlock("Test").containsVariables(new Argument("Test"), new Argument("1")));
		assertTrue(new ArgumentBlock("Test").containsVariables(new Argument("Test")));
		assertTrue(new ArgumentBlock("Test").containsVariables(new Argument[0]));
		assertTrue(new ArgumentBlock("Test", "1", "Hello, World!").containsVariables(new Argument("Test"), new Argument("1"), new Argument("Hello, World!")));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#containsVariables(java.lang.String[])}.
 * 
 */
	@Test
	final void testContainsVariablesStringArray() {
		
		assertThrows(NullPointerException.class, () -> new ArgumentBlock("Test").containsVariables((String) null));
		
		assertFalse(new ArgumentBlock("Test").containsVariables("1"));
		assertFalse(new ArgumentBlock("Test").containsVariables("Test", "1"));
		assertTrue(new ArgumentBlock("Test").containsVariables("Test"));
		assertTrue(new ArgumentBlock("Test").containsVariables(new String[0]));
		assertTrue(new ArgumentBlock("Test", "1", "Hello, World!").containsVariables("Test", "1", "Hello, World!"));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#getVariableDescriptions()}.
 * 
 */
	@Test
	final void testGetVariableDescriptions() {
		
		VariableDescription[] array = {new VariableDescription("Test", "")};
		
		assertArrayEquals(array, new ArgumentBlock("Test").getVariableDescriptions());
		
		array = new VariableDescription[] {new VariableDescription("Test", ""), new VariableDescription("1", ""), new VariableDescription("Hello, World!", "")};
		
		assertArrayEquals(array, new ArgumentBlock("Test", "1", "Hello, World!").getVariableDescriptions());
		assertFalse(Arrays.deepEquals(array, new ArgumentBlock("Test").getVariableDescriptions()));
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#toString()}.
 * 
 */
	@Test
	final void testToString() {
		
		assertEquals("[[Test: ]]", new ArgumentBlock("Test").toString());
		assertEquals("[[Test: Test]]", new ArgumentBlock(new VariableDescription("Test", "Test")).toString());
		assertEquals("[[1: 1], [Test: Test]]", new ArgumentBlock(new VariableDescription("Test", "Test"), new VariableDescription("1", "1")).toString());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.argument.ArgumentBlock#createEmptyArgumentBlock()}.
 * 
 */
	@Test
	final void testCreateEmptyArgumentBlock() {
		
		ArgumentBlock block = ArgumentBlock.createEmptyArgumentBlock();
		
		assertFalse(block.containsVariables(""));
		assertFalse(block.containsVariables("Test"));
		assertEquals("[]", block.toString());
		assertArrayEquals(new VariableDescription[0], block.getVariableDescriptions());
	}
}
