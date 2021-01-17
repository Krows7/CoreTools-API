package net.coretools.core.argument;

import java.util.Arrays;

/**
 * 
 * Values class is container with value objects for {@link Arguments} object and not only.
 * 
 * @since 1.3.0 (old: 1.3)
 *
 * @author Krows
 * 
 */
public class Values {

/**
 * 
 * Contains string for returning in the {@link #toString()} method.
 * 
 */
	private String toString;
	
/**
 * 
 * Object array contains all value objects.
 * 
 */
	protected Object[] values;
	
/**
 * 
 * Creates new {@link Values} object with all specified objects.
 * 
 * @param values Value objects for containing.
 *
 */
	public Values(Object... values) {
	
		this.values = values;
		
		toString = Arrays.asList(values).toString();
	}
	
/**
 * 
 * Returns object array with all attached values.
 * 
 * @return Object array of all values.
 * 
 */
	public Object[] getValues() {
		
		return values;
	}
	
/**
 * 
 * Returns information about value objects in this {@link Values} object.
 * 
 * @return {@inheritDoc}
 * 
 */
	@Override
	public String toString() {

		return toString;
	}
}