package net.coretools.core.argument;

/**
 * 
 * Argument class is an implementation of arguments from command line to API environment. 
 * Like and an usual argument it may contains two things: variable and value. Also it supports single-variable arguments without value.
 * 
 * <blockquote>	Example 1:
 * 			<pre>Window window = new Window(new Argument("size", new int[] {1920, 1080}));</pre>
 * 				Example 2:
 * 			<pre>Window window = new Window(new Argument("-debug"));</pre>
 * </blockquote>
 * 
 * Also classes can accept in parameters several count of arguments:
 * 
 * <blockquote><pre>
 * public Calculator(Argument... args) {
 * 
 * 	...
 * }
 * 
 * ...
 * 
 * int result = new Calculator(new Argument("-strict"), new Argument("count", "5 / 2")).getResult();
 * </pre></blockquote>
 * 
 * @since 1.3.0 (old: 1.3)
 *
 * @author Krows
 * 
 */
public class Argument {
	
/**
 * 
 * Variable of the argument. Always must be not-null.
 * 
 */
	protected String var;
	
/**
 * 
 * Value of the argument. Can be null if this argument is single-variable.
 * 
 */
	protected Object value;
	
/**
 * 
 * Creates new single-variable {@link Argument} object which does not contain value object. 
 *
 * @param var Variable's name of the argument.
 *
 */
	public Argument(String var) {
		
		this(var, null);
	}
	
/**
 * 
 * Creates new {@link Argument} object which contains both objects: variable and value. 
 * Unlike from value which can be null, variable always must be not-null.
 * 
 * @param var Variable's name of the argument. It must be not-null.
 * @param value Value object of the argument. Can be null.
 * 
 * @throws ArgumentException If variable equals null or empty string.
 * 
 */
	public Argument(String var, Object value) {
	
		if(var == null || var.equals("")) throw new ArgumentException("Variable must not be null.");
		
		this.var = var;
		
		this.value = value;
	}
	
/**
 * 
 * Returns variable name of the argument. Always will be not-null.
 * 
 * @return Variable's name.
 *
 */
	public String getVariable() {
		
		return var;
	}
	
/**
 * 
 * Returns value object of the argument. Can be null.
 * 
 * @return Value's object.
 *
 */
	public Object getValue() {
		
		return value;
	}
	
/**
 * 
 * Returns information about this argument. This includes variable and value of the argument.
 * <blockquote>
 * For example:
 * <br>
 * <br>{@code net.coretools.core.argument.Argument[variable: color; value: red]}
 * </blockquote>
 * 
 * @return {@inheritDoc}
 * 
 */
	@Override
	public String toString() {

		return String.format("%s[variable: %s; value: %s]", getClass().getName(), var, value);
	}
}