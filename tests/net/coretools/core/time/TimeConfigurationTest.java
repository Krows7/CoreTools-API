package net.coretools.core.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 
 * JUnit tests for {@link TimeConfiguration} class.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
class TimeConfigurationTest {
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#getDifferenceTime()}.
 * 
 * @param lastTime Object for tests.
 * @param currentTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"200, 500", "0, 1000", "324324346, 4365465465476"})
	final void testGetDifferenceTime(long lastTime, long currentTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setCurrentTime(currentTime);
		time.setLastTime(lastTime);
		time.countDifferenceTime();
		
		assertEquals(currentTime - lastTime, time.getDifferenceTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#setDifferenceTime(long)}.
 * 
 * @param dTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "3243254356657"})
	final void testSetDifferenceTime(long dTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setDifferenceTime(dTime);
		
		assertEquals(dTime, time.getDifferenceTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#getCurrentTime()}.
 * 
 * @param currentTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "32434254576423"})
	final void testGetCurrentTime(long currentTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setCurrentTime(currentTime);
		
		assertEquals(currentTime, time.getCurrentTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#countDifferenceTime()}.
 * 
 * @param lastTime Object for tests.
 * @param currentTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"200, 500", "0, 1000", "324324346, 4365465465476"})
	final void testCountDifferenceTime(long lastTime, long currentTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setCurrentTime(currentTime);
		time.setLastTime(lastTime);
		
		assertEquals(currentTime - lastTime, time.countDifferenceTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#clearDifferenceTime()}.
 * 
 * @param dTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "443656754231"})
	final void testClearDifferenceTime(long dTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setDifferenceTime(dTime);
		
		assertEquals(0, time.clearDifferenceTime());
		assertEquals(0, time.getDifferenceTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#appendDifferenceTime()}.
 * 
 * @param append object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "15"})
	final void testAppendDifferenceTime(int append) {
		
		TimeConfiguration time = new TimeConfiguration();
		
		for(int i = 0; i < append; i++) time.appendDifferenceTime();
		
		assertEquals(append, time.getAppendTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#setCurrentTime(long)}.
 * 
 * @param currentTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "5434645723441"})
	final void testSetCurrentTime(long currentTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setCurrentTime(currentTime);
		
		assertEquals(currentTime, time.getCurrentTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#getLastTime()}.
 * 
 * @param lastTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "4365687546"})
	final void testGetLastTime(long lastTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setLastTime(lastTime);
		
		assertEquals(lastTime, time.getLastTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#getLastTime()}.
 * 
 * @param lastTime Object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1000", "543762452436"})
	final void testSetLastTime(long lastTime) {
		
		TimeConfiguration time = new TimeConfiguration();
		time.setLastTime(lastTime);
		
		assertEquals(lastTime, time.getLastTime());
	}
	
/**
 * 
 * Test method for {@link net.coretools.core.time.TimeConfiguration#getAppendTime()}.
 * 
 * @param append object for tests.
 * 
 */
	@ParameterizedTest
	@CsvSource({"0", "1", "5", "15"})
	final void testGetAppendTime(int append) {
		
		TimeConfiguration time = new TimeConfiguration();
		
		for(int i = 0; i < append; i++) time.appendDifferenceTime();
		
		assertEquals(append, time.getAppendTime());
		
		time.clearDifferenceTime();
		
		assertEquals(0, time.getAppendTime());
	}
}
