package net.coretools.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Launcher} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class LauncherTest {
	
	/**
	 * Arguments for comparing.
	 */
	private final String[] args = {"First", "Second", "Third"
	};
	
	/**
	 * Predicted arguments.
	 */
	String[] predict;
	
	/**
	 * Test launcher.
	 */
	private Launcher launcher = new Launcher(args) {
		
		@Override
		public void launch() {
			
			predict = this.args;
		}
	};
	
	/**
	 * Test method for
	 * {@link net.coretools.core.Launcher#Launcher(java.lang.String[])}.
	 */
	@Test
	void testLauncher() {
		
		assertEquals(args, launcher.args);
	}
	
	/**
	 * Test method for {@link net.coretools.core.Launcher#launch()}.
	 */
	@Test
	void testLaunch() {
		
		launcher.launch();
		assertEquals(args, predict);
	}
}
