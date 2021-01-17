package net.coretools.core;

import net.coretools.core.OnQuestion.Status;
import net.coretools.core.argument.Argument;
import net.coretools.core.argument.ArgumentBlock;
import net.coretools.core.argument.Arguments;
import net.coretools.core.argument.VariableDescription;

/**
 * 
 * ThreadTools class contains method for working with threads.
 * 
 * @since 1.0.0 (old: 1.0)
 * 
 * @author Krows
 * 
 */
public final class ThreadTools {
	
/**
 * 
 * Variables which supports in this class. Next arguments available:
 * <blockquote>
 * "DAEMON" [boolean] - Sets the thread to daemon. Boolean values are accepted.<br>
 * "-START" - Sets auto start into the thread.
 * </blockquote>
 * 
 */
	private final static VariableDescription[] VARIABLES = {new VariableDescription("DAEMON", "Sets the thread to daemon. Boolean values are accepted."),
															new VariableDescription("-START", "Sets auto start into the thread.")};  
	
/**
 * 
 * {@link ArgumentBlock} which contains supported arguments in this class. Next arguments available:
 * <blockquote>
 * "DAEMON" [boolean] - Sets the thread to daemon. Boolean values are accepted.<br>
 * "-START" - Sets auto start into the thread.
 * </blockquote>
 * 
 */
	public final static ArgumentBlock ARGUMENT_BLOCK = new ArgumentBlock(VARIABLES);
	
/**
 * 
 * Closed constructor.
 * 
 */
	private ThreadTools() {
		
	}
	
/**
 * 
 * This method creates new {@link Thread} which contains {@link Script} and ready to launch it at start. Supports arguments. 
 * Available arguments contains in {@link #ARGUMENT_BLOCK}.
 * 
 * @param script Script which will be launched in thread when it will starts.
 * @param args Arguments for method.
 * 
 * @return New Thread with script which tooled with arguments.
 * 
 */
	@OnQuestion(status = Status.EDIT, description = "Change and add new arguments.")
	public static Thread createThread(Script script, Argument... args) {
		
		Arguments arguments = new Arguments(args);
		
		ARGUMENT_BLOCK.checkVariables(arguments.getVariables());
		
		Thread thread = new Thread(() -> script.execute());
		thread.setDaemon((boolean) arguments.getValueOrOther("DAEMON", false));
		
		if(arguments.containsArgument("-START")) thread.start();
		
		return thread;
	}
}