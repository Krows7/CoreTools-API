package net.coretools.core.argument;

import java.util.Arrays;

import net.coretools.core.ObjectTools;

/**
 * 
 * Values class is container with variable objects for {@link Arguments} object and not only.
 * 
 * @since 1.3.0 (old: 1.3)
 *
 * @author Krows
 * 
 */
public class Variables {
	
/**
 * 
 * Contains string for returning in the {@link #toString()} method.
 * 
 */
	private String toString;
	
/**
 * 
 * String array contains all variable objects.
 * 
 */
	protected String[] vars;
	
/**
 * 
 * Creates new {@link Variables} object with all specified String objects.
 * 
 * @param vars Variable String objects for containing.
 *
 */
	public Variables(String... vars) {
		
		if(vars == null || vars.length == 0 || ObjectTools.contains(null, vars) || ObjectTools.contains("", vars)) throw new ArgumentException("Variable must be not-null.");
		
		this.vars = vars;
		
		toString = Arrays.asList(vars).toString();
	}
	
/**
 * 
 * Returns string array with all attached variables.
 * 
 * @return String array of all variables.
 * 
 */
	public String[] getVariables() {
		
		return vars;
	}
	
/**
 * 
 * Returns information about variable objects in this {@link Variables} object.
 * 
 * @return {@inheritDoc}
 * 
 */
	@Override
	public String toString() {

		return toString;
	}
}