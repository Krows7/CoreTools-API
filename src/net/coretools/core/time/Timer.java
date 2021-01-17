package net.coretools.core.time;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.coretools.core.MathConstants;
import net.coretools.core.Script;
import net.coretools.core.ThreadTools;
import net.coretools.core.argument.Argument;

/**
 * 
 * 
 * @author Krows
 * 
 * @since 1.4.6 (3'rd patch)
 *
 */
public class Timer implements MathConstants {

	private long delay;
	
	private Script script;
	
	private SystemTimeConfiguration time;
	
	private Thread thread;
	
	private volatile boolean isRunning;
	
	public Timer(long delay, Script script) {
		
		this.delay = delay * MILLION;
		
		this.script = script;
		
		this.time = new SystemTimeConfiguration();
	}
	
	public Timer start() {
		
		thread = ThreadTools.createThread(() -> {
			
			isRunning = true;
			
			time.setLastTime();
			
			while(isRunning) {
				
				if(System.nanoTime() - time.getLastTime() > delay) {
					
					isRunning = false;
					
					script.execute();
				}
			}
		}, new Argument("DAEMON", true), new Argument("-START"));
		
		return this;
	}
	
	public Timer restart() {
		
		isRunning = false;
				
		if(thread != null) thread.interrupt();
		
		return start();
	}
	
	public Timer setDelay(int delay) {
		
		this.delay = (long) delay * (long) MILLION;
		
		return this;
	}
	
	public boolean isRunning() {
		
		return isRunning;
	}
	
	public int getDelay() {
		
		return (int) (delay / MILLION);
	}
	
	public double leftTime() {
		
		if(isRunning) {
			
			double left = (delay - (double) System.nanoTime() + (double) time.getLastTime()) / BILLION;
			
			return new BigDecimal(left).setScale(3, RoundingMode.HALF_UP).doubleValue();
		}
		
		return 0.0;
	}
}