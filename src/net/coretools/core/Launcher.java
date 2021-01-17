package net.coretools.core;

/**
 * Abstract class for launching programs. May can be extended for programming needs. 
 * Supports launch parameters given in constructor or method <code>{@link #launch()}</code>.
 * For example: launch parameters can be specified through <code>switch</code> operator.
 * 
 * <blockquote>
 * Example 1:
 * <pre>
 * Launcher launcher = new Launcher("debug") {
 * 
 * 	public void launch() {
 * 
 * 		for(String command : args) {
 * 
 * 			switch(command) {
 * 
 * 			case "debug" :
 * 
 * 				CoreSystem.debug(1);
 * </pre>
 * Example 2:
 * <pre>
 * public class ExampleLauncher extends Launcher {
 * 
 * 	public ExampleLauncher(String... args) {
 * 
 * 		super(args);
 * 		
 * 		for(String command : args) {
 * 
 * 			switch(command) {
 * 
 * 			case "debug" :
 * 
 * 				CoreSystem.debug(1);
 * </pre>
 * </blockquote>
 * 
 * @since 1.0.0 (old: 1.0)
 * 
 * @author Krows
 * 
 */
public abstract class Launcher {
	
/**
 * 
 * String array of launch parameters given in constructor.
 * 
 */
	protected String[] args;
	
/**
 * Constructor for creating the Launcher. For default launching the program needs to initialize void <code>main(String[] args)</code> and 
 * invoke method <code>{@link #launch()}</code>.
 * 
 * @param args Launch parameters given from any way. 
 * 
 */
	public Launcher(String... args) {
		
		this.args = args;
	}
	
/**
 * 
 * Method launches the program which beginning here and makes parameters given in constructor.
 * 
 * <blockquote>
 * Example:
 * <pre>
 * Launcher launcher = new Launcher() {
 * 
 * 	public void launch() {
 * 
 * 		GUISystem.createFrame();
 * </pre>
 * </blockquote>
 */
	public abstract void launch();
}