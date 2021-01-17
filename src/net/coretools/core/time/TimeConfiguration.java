package net.coretools.core.time;

/**
 * 
 * TimeConfiguration class usually is used in counting time for while loop code blocks. 
 * But it can be used in different situations.
 * 
 * @author Krows
 * 
 * @since 1.0.0 (old: 1.0)
 *
 */
public class TimeConfiguration {
	
/**
 * 
 * Contains last updated number. 
 * 
 */
	protected long lastTime;
	
/**
 * 
 * Contains current time on last update.
 * 
 */
	protected long currentTime;
	
/**
 * 
 * Contains difference number(delta) of {@link #lastTime} and {@link #currentTime}.
 * 
 */
	protected long differenceTime;
	
/**
 * 
 * Contains number count of append times before flushing.
 * 
 */
	protected long appendTime;
	
/**
 * 
 * Returns difference time between current time and last checked time. Preliminarily both time stages must be checked through other methods.
 * 
 * @return Difference time.
 * 
 */
	public long getDifferenceTime() {
		
		return differenceTime;
	}
	
/**
 * 
 * Allows check difference time manually. 
 * But this manipulation can corrupt time stage logic if this difference time will be incorrect wrong with respect to current time and last checked time.
 * 
 * @param differenceTime difference time between current time and last checked time.
 * 
 */
	public void setDifferenceTime(long differenceTime) {
		
		this.differenceTime = differenceTime;
		
		appendTime = 0;
	}
	
/**
 * 
 * Returns current time if it checked. Otherwise return null.
 * 
 * @return Current time.
 * 
 */
	public long getCurrentTime() {
		
		return currentTime;
	}
	
/**
 * 
 * Counts difference time between current time and last checked time and return its.
 * 
 * @return Difference time.
 * 
 */
	public long countDifferenceTime() {
		
		differenceTime = currentTime - lastTime;
		
		appendTime = 0;
		
		return differenceTime;
	}
	
/**
 * 
 * Clears difference time between current time and last checked time. Also clears number of appending difference time. Return 0.
 * 
 * @return 0.
 * 
 */
	public long clearDifferenceTime() {
		
		differenceTime = 0;
		
		appendTime = 0;
		
		return differenceTime;
	}
	
/**
 * 
 * Appends to old difference time new difference time relatively to current time and last checked time. 
 * Also increment number of appending difference time. Returns appended difference time.
 * 
 * @return Appended difference time.
 * 
 */
	public long appendDifferenceTime() {
		
		differenceTime += currentTime - lastTime;
		
		appendTime++;
		
		return differenceTime;
	}
	
/**
 * 
 * Allows check current time. It needs for creating time stage logic. 
 * 
 * @param currentTime current time for counting.
 * 
 */
	public void setCurrentTime(long currentTime) {
		
		this.currentTime = currentTime;
	}
	
/**
 * 
* Returns last checked time if it checked. Otherwise return null.
* 
* @return Last checked time.
* 
*/
	public long getLastTime() {
		
		return lastTime;
	}
	
/**
* 
* Allows check last time. It needs for creating time stage logic. 
* 
* @param lastTime last checked time for counting.
* 
*/
	public void setLastTime(long lastTime) {
		
		this.lastTime = lastTime;
	}
	
/**
 * 
 * Returns number of appending difference time. 
 * Otherwise if difference time never was appended or was used {@link #clearDifferenceTime()} method returns 0.
 * 
 * @return number of appending difference time or 0 if it was cleared.
 * 
 */
	public long getAppendTime() {
		
		return appendTime;
	}
}