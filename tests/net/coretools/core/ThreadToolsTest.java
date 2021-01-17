package net.coretools.core;

import static net.coretools.core.ThreadTools.createThread;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.coretools.core.argument.Argument;

/**
 * JUnit tests for {@link ThreadTools} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class ThreadToolsTest {
	
	/**
	 * Test {@link Thread}.
	 */
	private Thread thread;
	
	/**
	 * Test {@link Script}.
	 */
	private Script script;
	
	/**
	 * Set up method for {@link #testCreateThread()}.
	 */
	@BeforeEach
	final void setUp() {
		
		script = () -> {
			assertTrue(thread.isDaemon());
			assertTrue(thread.isAlive());
		};
	}
	
	/**
	 * Test method for
	 * {@link net.coretools.core.ThreadTools#createThread(net.coretools.core.Script, net.coretools.core.argument.Argument[])}.
	 */
	@Test
	final void testCreateThread() {
		
		thread = createThread(script, new Argument("-START"), new Argument("DAEMON", true));
	}
}
