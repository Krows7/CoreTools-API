package net.coretools.core.time;

/**
 * 
 * SystemTimeConfiguration class overrides {@link TimeConfiguration} class for working with system time that should to do easier
 * work with programs. Reworked some methods, also added new non-parameter setters for working with system time. 
 * All computes will do in nanoseconds(based on {@link System#nanoTime()}).
 * 
 * @since 1.4.6 (3'rd patch)
 *
 * @author Krows
 * 
 * @see #countDifferenceTime()
 * @see #appendDifferenceTime()
 * @see #setCurrentTime()
 * @see #setLastTime()
 * 
 */
public class SystemTimeConfiguration extends TimeConfiguration {
	
/**
 * 
 * Overridden method does same computes but with replacing <u>current time</u> the system time.
 * <br>
 * <br>
 * {@inheritDoc}
 * 
 */
	@Override
	public long countDifferenceTime() {

		differenceTime = System.nanoTime() - lastTime;
		
		appendTime = 0;
		
		return differenceTime;
	}
	
/**
 * 
 * Overridden method does same computes but with replacing <u>current time</u> the system time.
 * <br>
 * <br>
 * {@inheritDoc}
 * 
 */
	@Override
	public long appendDifferenceTime() {

		differenceTime += System.nanoTime() - lastTime;
		
		appendTime++;
		
		return differenceTime;
	}
	
/**
 * 
 * Sets system time for the current time in this object.
 * 
 */
	public void setCurrentTime() {
		
		setCurrentTime(System.nanoTime());
	}
	
/**
 * 
 * Sets system time for the last time in this object.
 * 
 */
	public void setLastTime() {
		
		setLastTime(System.nanoTime());
	}
}