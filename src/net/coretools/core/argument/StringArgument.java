package net.coretools.core.argument;

/**
 * 
 * StringArgument class is an overridden {@link Argument} class which takes as values String objects.
 * 
 * @since 1.3.0 (old: 1.3)
 *
 * @author Krows
 * 
 * @see Argument
 * 
 */
public class StringArgument extends Argument {

/**
 * 
 * Overridden object contains String values.
 * 
 */
	protected String value;
	
/**
 * 
 * Creates new single-variable {@link StringArgument} object which does not contain value object. 
 *
 * @param var Variable's name of the argument.
 *
 */
	public StringArgument(String var) {
		
		this(var, null);
	}
	
/**
 * 
 * Creates new {@link StringArgument} object which contains both objects: variable and value. 
 * Unlike from value which can be null, variable always must be not-null. In {@link StringArgument} class the value object overridden to {@link String}.
 * 
 * @param var Variable's name of the argument. It must be not-null.
 * 
 * @param value Value string of the argument. Can be null.
 * 
 */
	public StringArgument(String var, String value) {
		
		super(var, value);
	}
	
/**
 * 
 * Returns value string object of the argument. Can be null.
 * 
 * @return String value of this argument.
 * 
 */
	@Override
	public String getValue() {
		
		return value;
	}
}