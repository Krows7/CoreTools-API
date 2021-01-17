package net.coretools.core.argument;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Arguments} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class ArgumentsTest {
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#Arguments(net.coretools.core.argument.Argument[])}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentsArgumentArray() {
		
		assertThrows(NullPointerException.class, () -> {
			new Arguments((Argument) null);
		});
		assertThrows(ArgumentException.class, () -> {
			new Arguments(new Argument("-start"), new Argument(""));
		});
		assertThrows(ArgumentException.class, () -> {
			new Arguments(new Argument("-start"), new Argument(null));
		});
		new Arguments(new Argument("-start"), new Argument("color"));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#Arguments(java.util.Collection)}.
	 */
	@SuppressWarnings("unused")
	@Test
	final void testArgumentsCollectionOfArgument() {
		
		assertThrows(NullPointerException.class, () -> {
			new Arguments(Arrays.asList((Argument) null));
		});
		assertThrows(ArgumentException.class, () -> {
			new Arguments(Arrays.asList(new Argument("-start"), new Argument("")));
		});
		assertThrows(ArgumentException.class, () -> {
			new Arguments(Arrays.asList(new Argument("-start"), new Argument(null)));
		});
		new Arguments(Arrays.asList(new Argument("-start"), new Argument("color")));
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#Arguments(net.coretools.core.argument.Variables, net.coretools.core.argument.Values)}.
	 */
	@Test
	final void testArgumentsVariablesValues() {
		
		// new Arguments(vars, values);
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#Arguments(java.lang.String[], java.lang.Object[])}.
	 */
	@Test
	final void testArgumentsStringArrayObjectArray() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#Arguments(java.util.Map)}.
	 */
	@Test
	final void testArgumentsMapOfStringObject() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#adaptArguments(net.coretools.core.argument.Arguments, net.coretools.core.argument.ArgumentBlock)}.
	 */
	@Test
	final void testAdaptArguments() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getArgument(java.lang.String)}.
	 */
	@Test
	final void testGetArgument() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getVariables()}.
	 */
	@Test
	final void testGetVariables() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getValues()}.
	 */
	@Test
	final void testGetValues() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getArguments()}.
	 */
	@Test
	final void testGetArguments() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getValue(java.lang.String)}.
	 */
	@Test
	final void testGetValue() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#getValueOrOther(java.lang.String, java.lang.Object)}.
	 */
	@Test
	final void testGetValueOrOther() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#containsArgument(java.lang.String)}.
	 */
	@Test
	final void testContainsArgumentString() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.argument.Arguments#containsArgument(java.lang.String, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	final void testContainsArgumentStringObjectObject() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Arguments#getSize()}.
	 */
	@Test
	final void testGetSize() {
		
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link net.coretools.core.argument.Arguments#toString()}.
	 */
	@Test
	final void testToString() {
		
		fail("Not yet implemented"); // TODO
	}
}
