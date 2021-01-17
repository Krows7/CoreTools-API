package net.coretools.core.argument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.coretools.core.ArrayTools;
import net.coretools.core.CollectionTools;

/**
 * 
 * ArgumentBlock class is a container of descriptions for argument variables.
 * 
 * @since 1.3.0 (old: 1.3)
 * 
 * @author Krows
 * 
 */
public final class ArgumentBlock {
	
/**
 * 
 * Contains string for returning in the {@link #toString()} method.
 * 
 */
	private String toString;
	
/**
 * 
 * {@link Map} contains data of the attached arguments. 
 * As key included variable and as value included {@link VariableDescription} object of certain variable.
 * 
 */
	private Map<String, VariableDescription> descriptionMap;

/**
 * 
 * Creates new {@link ArgumentBlock} object with empty collection of variables and its descriptions.
 * 
 */
	private ArgumentBlock() {
		
		descriptionMap = new HashMap<>();
		
		toString = getToStringMessage();
	}
	
/**
 * 
 * Creates new {@link ArgumentBlock} object with collection of specified variables and empty descriptions.
 * 
 * @param vars Variables for containing. 
 * 
 */
	public ArgumentBlock(String... vars) {
		
		this(CollectionTools.createPulledElementArray(vars, value -> new VariableDescription(value, "")));
	}
	
/**
 * 
 * Creates new {@link ArgumentBlock} object with collection of specified {@link VariableDescription} objects.
 * 
 * @param vars VariableDescription object array for containing.
 * 
 * @throws NullPointerException If size of array equals 0 or if one of object from array equals null.
 * 
 */
	public ArgumentBlock(VariableDescription... vars) {

		this();
		
		if(vars.length == 0) throw new NullPointerException("Amount of variables equals 0.");
		
		ArrayTools.forEach(vars, var -> descriptionMap.put(Objects.requireNonNull(var, "Variable must not be null.").var, var));
		
		toString = getToStringMessage();
	}
	
/**
 * 
 * Checks specified {@link Argument} objects for containing in this {@link ArgumentBlock} object. 
 * If one of arguments does not contain then throws ArgumentException.
 * 
 * @param arguments Argument array for contain checking.
 * 
 * @throws ArgumentException If one of specified arguments does not contain in this ArgumentBlock object.
 * 
 * @see #checkVariables(String...)
 * 
 */
	public void checkArguments(Argument... arguments) {
		
		ArrayTools.forEach(arguments, var -> checkVariables(var.var));
	}
	
/**
 * 
 * Checks specified variables for containing in this {@link ArgumentBlock} object. 
 * If one of variables does not contain then throws ArgumentException.
 * 
 * @param vars Variables for contain checking.
 * 
 * @throws ArgumentException If one of specified variables does not contain is this ArgumentBlock object.
 * @throws NullPointerException If one of specified variables equals null.
 *
 */
	public void checkVariables(String... vars) {
		
		for(String var : vars) if(!descriptionMap.containsKey(Objects.requireNonNull(var, "Variables must not be null."))) throw new ArgumentException("The \"" + var + "\" argument is not supported with this argument block.");
	}
	
/**
 * 
 * Returns result of contain checking specified {@link Argument} objects in this {@link ArgumentBlock} object. 
 * If all of Argument objects is contained then returns true, otherwise returns false.
 * 
 * @param arguments Argument array for contain checking.
 * 
 * @return True if all Argument objects from specified array is contained, otherwise returns false.
 * 
 * @throws NullPointerException If one of specified arguments equals null.
 *
 */
	public boolean containsVariables(Argument... arguments) {
		
		for(Argument argument : arguments) if(!containsVariables(Objects.requireNonNull(argument, "Argument must not be null.").var)) return false;
		
		return true;
	}
	
/**
 * 
 * Returns result of contain checking specified strings from array in this {@link ArgumentBlock} object. 
 * If all of strings is contained then returns true, otherwise returns false.
 * 
 * @param vars Variable string array for contain checking.
 * 
 * @return True if all variables from specified array is contained, otherwise returns false.
 * 
 * @throws NullPointerException If one of specified variables equals null.
 *
 */
	public boolean containsVariables(String... vars) {
		
		for(String var : vars) if(!descriptionMap.containsKey(Objects.requireNonNull(var, "Variable must not be null."))) return false;
		
		return true;
	}
	
/**
 * 
 * Returns {@link VariableDescription} object array which contains in this {@link ArgumentBlock} object.
 * 
 * @return VariableDescription object array which contains in this ArgumentBlock object.
 *
 */
	public VariableDescription[] getVariableDescriptions() {
		
		return descriptionMap.values().toArray(new VariableDescription[0]);
	}
	
/**
 * 
 * Returns information about contained {@link VariableDescription} objects in this {@link Arguments} object.
 * Each VariableDescription object submitted like a block which contains all description data. 
 * Each data block contains name of argument variable and variable description.
 * <blockquote>
 * For example:
 * 
 * [[-start: Starts the program.], [color: Sets color to player.]]
 * </blockquote> 
 * 
 * @return {@inheritDoc}
 * 
 */
	@Override
	public String toString() {
		
		return toString;
	}
	
/**
 * 
 * Creates new {@link ArgumentBlock} object with empty collection of variables and its descriptions.
 * 
 * @return new ArgumentBlock object with empty collection of variables and its descriptions.
 *
 */
	public static ArgumentBlock createEmptyArgumentBlock() {
		
		return new ArgumentBlock();
	}
	
/**
 * 
 * Returns string which contains all argument data in blocks in {@link Collection#toString()} style.
 * <blockquote>
 * For example:
 * 
 * [[-start: Starts the program.], [color: Sets color to player.]]
 * </blockquote> 
 * 
 * @return String with all argument data.
 *
 */
	private String getToStringMessage() {
		
		if(descriptionMap.isEmpty()) return "[]";
		
		return descriptionMap.values().toString();
	}
}