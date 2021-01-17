package net.coretools.core;

import static org.junit.jupiter.api.Assertions.*;
import static net.coretools.core.Version.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Version} class.
 * 
 * @since 1.5.0
 * @author Krows
 */
class VersionTest {
	
	/**
	 * Test method for {@link net.coretools.core.Version#getVersion()}.
	 */
	@Test
	final void testGetVersion() {
		
		assertTrue(getVersion().startsWith(getVersionNumbers()[0] + "." + getVersionNumbers()[1] + "." + getVersionNumbers()[2]));
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getMessage()}.
	 */
	@Test
	final void testGetMessage() {
		
		assertTrue(getMessage().startsWith(String.format("Version: %s.%s.%s", getVersionNumbers()[0], getVersionNumbers()[1], getVersionNumbers()[2])));
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getVersionNumbers()}.
	 */
	@Test
	final void testGetVersionNumbers() {
		
		byte[] version = getVersionNumbers();
		assertEquals(getMajorVersion(), version[0]);
		assertEquals(getMiddleVersion(), version[1]);
		assertEquals(getMinorVersion(), version[2]);
		assertEquals(getPatchVersion(), version[3]);
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getMajorVersion()}.
	 */
	@Test
	final void testGetMajorVersion() {
		
		assertEquals(getMajorVersion(), getVersionNumbers()[0]);
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getMiddleVersion()}.
	 */
	@Test
	final void testGetMiddleVersion() {
		
		assertEquals(getMiddleVersion(), getVersionNumbers()[1]);
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getMinorVersion()}.
	 */
	@Test
	final void testGetMinorVersion() {
		
		assertEquals(getMinorVersion(), getVersionNumbers()[2]);
	}
	
	/**
	 * Test method for {@link net.coretools.core.Version#getPatchVersion()}.
	 */
	@Test
	final void testGetPatchVersion() {
		
		assertEquals(getPatchVersion(), getVersionNumbers().length == 4 ? getVersionNumbers()[3] : 0);
	}
}
