package net.coretools.core.argument;

/**
 * 
 * VariableDescription class is container of argument variable with its description.
 * 
 * @since 1.3.0 (old: 1.3)
 *
 * @author Krows
 * 
 */
public class VariableDescription {
	
/**
 * 
 * String variable of an argument. It cannot be null. Also the argument with this variable may not exists.
 * 
 */
	protected String var;
	
/**
 * 
 * String description of argument variable. Can be null.
 * 
 */
	protected String description;
	
/**
 * 
 * Creates new {@link VariableDescription} object which contains variable and its description. 
 * Unlike the description which can be null, variable always must be not-null. 
 * The variable does not need to be declared in any {@linkplain Argument argument}. 
 * The variable description is assigned regardless from the argument and can be used regardless from it.
 * <br>
 * <br> 
 * Notice: If description is null then it will be converted to empty string.
 * 
 * @param var Variable name.
 * @param description Description of the variable.
 * 
 * @throws NullPointerException If variable equals null or empty string.
 * 
 */
	public VariableDescription(String var, String description) {
		
		if(var == null || var.equals("")) throw new NullPointerException("Variable must not be null.");
		
		this.var = var;
		
		this.description = description == null ? "" : description;
	}
	
/**
 * 
 * Returns name of argument variable. Also the argument with this variable may not exists.
 * 
 * @return Name of the variable.
 *
 */
	public String getVariable() {
		
		return var;
	}
	
/**
 * 
 * Returns description of the variable. 
 * 
 * @return Description of the variable.
 *
 */
	public String getDescription() {
		
		return description;
	}
	
/**
 * 
 * Returns result of similarity of both objects. There is several options:
 * <blockquote>
 * 1. If objects have the same reference then returns true.
 * <br>
 * 2. If specified object is instance of {@link VariableDescription} then compares variables and descriptions of both objects.
 * <br>
 * 3. Otherwise returns false.
 * </blockquote>
 * 
 * @param obj Object to check similarity with this object.
 * 
 * @return Result of comparing objects. With more details see general description.
 * 
 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		if(obj instanceof VariableDescription) return equals((VariableDescription) obj);
		
		return false;
	}
	
/**
 * 
 * Returns result of comparing two {@link VariableDescription} objects (this and specified). Objects must have same variable names and descriptions.
 * If one of objects have not description then second object must not contain too.
 * 
 * @param o Second VariableDescription object to compare.
 * 
 * @return Result of comparing objects. With more details see general description.
 *
 */
	private boolean equals(VariableDescription o) {
		
		return var.equals(o.var) && description == null ? o.description == null : description.equals(o.description);
	}
	
/**
 * 
 * Returns information about this {@link VariableDescription} object which includes variable and its description.
 * 
 * @return {@inheritDoc}
 * 
 */
	@Override
	public String toString() {

		return String.format("[%s: %s]", var, description);
	}
}