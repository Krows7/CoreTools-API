package net.coretools.core.time;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.coretools.core.MathConstants;

/**
 * 
 * Stopwatch class is representation of stopwatch for counting of time intervals.
 * 
 * @author Krows
 * 
 * @since 1.4.6 (3'rd patch)
 *
 */
public class Stopwatch implements MathConstants {
	
/**
 * 
 * StopwatchException class is thrown to indicate about problems in {@link Stopwatch} while using time.
 * 
 * @since 1.4.6 (3'rd patch)
 *
 * @author Krows
 * 
 */
	class StopwatchException extends RuntimeException {
		
/**
 * 
 * Serial Version UID.
 * 
 */
		private static final long serialVersionUID = 1L;
		
/**
 * 
 * Creates new {@link StopwatchException} with message string for detailing of exception.
 * 
 * @param message Message for detailing.
 * 
 * @see RuntimeException#RuntimeException(String)
 * @see Exception#getMessage()
 * 
 */
		public StopwatchException(String message) {

			super(message);
		}
	}
	
/**
 * 
 * Time configuration for counting of stopwatch.
 * 
 */
	private SystemTimeConfiguration time;
	
/**
 * 
 * Returns time when stopwatch was stopped if it was.
 * 
 */
	private double pausedTime;
	
/**
 * 
 * Indicates whether stopwatch is running.
 * 
 */
	private boolean running;
	
/**
 * 
 * Indicates whether stopwatch is paused.
 * 
 */
	private boolean paused;
	
/**
 * 
 * Indicates whether stopwatch is stopped.
 * 
 */
	private boolean stopped;
	
/**
 * 
 * Creates new stopwatch.
 *
 */
	public Stopwatch() {

		time = new SystemTimeConfiguration();
	}

	public void start() {
		
		if(running) return;
		
		time.setLastTime();
		
		setRun();
	}
	
	public double pause() {
		
		if(stopped) throw new StopwatchException("Stopwatch is stopped.");
		if(paused) return pausedTime;
		
		time.setCurrentTime();
		
		setPausedTime();
		setPause();
		
		return pausedTime;
	}
	
	public double stop() {
		
		if(stopped) return pausedTime;
		
		time.setCurrentTime();
		
		setStoppedTime();
		setStop();
		
		return pausedTime;
	}
	
	private void setPausedTime() {
		
		pausedTime = new BigDecimal((double) time.appendDifferenceTime() / BILLION).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}
	
	private void setStoppedTime() {
		
		pausedTime = new BigDecimal((double) time.countDifferenceTime() / BILLION).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}
	
	private void setPause() {
		
		running = false;
		
		paused = true;
		
		stopped = false;
	}
	
	private void setRun() {
		
		running = true;
		
		paused = false;
		
		stopped = false;
	}
	
	private void setStop() {
		
		running = false;
		
		paused = false;
		
		stopped = true;
	}
	
	public boolean isPaused() {
		
		return paused;
	}
	
	public boolean isStopped() {
		
		return stopped;
	}
	
	public boolean isRunning() {
		
		return running;
	}
	
	public long getTime() {
		
		return time.countDifferenceTime();
	}
	
	public double getSeconds() {
		
		return (double) getTime() / BILLION;
	}
	
	public String getTimeMessage() {
		
		return getSeconds() + " sec.";
	}
	
	public String toString(int radix) {
		
		double sec = getSeconds();
		
		return (sec + "").substring(0, radix + 1 + signAmount((int) sec)).concat(" sec.");
	}
	
	private static int signAmount(int num) {
		
		int index = 1;
		
		while(true) {
			
			if(num < Math.pow(10, index)) return index;
			
			index++;
		}
	}
	
	@Override
	public String toString() {
		
		return toString(3);
	}
}