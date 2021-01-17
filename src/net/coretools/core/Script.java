package net.coretools.core;

import net.coretools.core.OnQuestion.Status;

/**
 * 
 * Script interface contains one method which works as applied script.
 * 
 * <blockquote> Example:
 * <pre>
 * public static void doScript(Script script) {
 * 
 * 	script.execute();
 * }
 * 
 * public Builder() {
 * 
 * 	doScript(() -&#62; System.out.println("Script"));
 * }
 * </pre>
 * </blockquote>
 * 
 * @since 1.0.0 (old: 1.0)
 *
 * @author Krows
 * 
 */
@FunctionalInterface
@OnQuestion(status = Status.EDIT, description = "Remove or inherit from java.lang.Runnable")
public interface Script {

/**
 * 
 * Executes the script.
 * 
 */
	public void execute();
}