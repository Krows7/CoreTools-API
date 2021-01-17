package net.coretools.core.argument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.coretools.core.ObjectTools;

/**
 * 
 * Arguments class is a container with arguments included to it. 
 * 
 * @since 1.3.0 (old: 1.3) 
 *
 * @author Krows
 *
 */
public class Arguments {
	
/**
 * 
 * {@link Map} contains data of the attached arguments. As key included variable and as value included argument value.
 * 
 */
	private Map<String, Object> argMap;
	
/**
 * 
 * Contains string for returning in the {@link #toString()} method.
 * 
 */
	private String toString;
	
/**
 * 
 * Creates new {@link Arguments} object with specified {@link Argument} objects.
 * 
 * @param arguments Argument array for containing in the Arguments object.
 *
 */
	public Arguments(Argument... arguments) {
		
		this(Arrays.asList(arguments));
	}
	
/**
 * 
 * Creates new {@link Arguments} object with specified Collection which contains {@link Argument} objects.
 * 
 * @param arguments Argument collection with Argument objects for containing in the Arguments object.
 *
 */
	public Arguments(Collection<Argument> arguments) {
		
		if(arguments == null) throw new NullPointerException("Argument collection must be not-null.");
		
		argMap = new HashMap<>();
		
		for(Argument argument : arguments) {
			
			if(argument == null) throw new NullPointerException("Argument in array must be not-null.");
			
			argMap.put(argument.var, argument.value);
		}
		
		toString = getToStringMessage();
	}
	
/**
 * 
 * Creates new {@link Arguments} object with {@link Argument} objects created by specified {@link Variables} and {@link Values}.
 * 
 * @param vars Variables object which contains argument variables for recreating.
 * @param values Values object which contains argument values for recreating.
 *
 */
	public Arguments(Variables vars, Values values) {
		
		this(vars.vars, values.values);
	}
	
/**
 * 
 * Creates new {@link Arguments} object with {@link Argument} objects created by specified variable array and value array.
 * 
 * @param vars String array which contains argument variables for recreating.
 * @param values Object array which contains argument values for recreating.
 *
 */
	public Arguments(String[] vars, Object[] values) {
		
		if(vars == null) throw new NullPointerException("Variable array must be not-null.");
		if(values == null) throw new NullPointerException("Value array must be not-null.");
		if(vars.length != values.length) throw new ArgumentException("The number of variables is not equal to the number of values.");
		if(ObjectTools.contains(null, vars) || ObjectTools.contains("", vars)) throw new ArgumentException("Variables must be not-null.");
		
		argMap = new HashMap<>();
		
		for(int i = 0; i < vars.length; i++) {
			
			argMap.put(vars[i], values[i]);
		}
		
		toString = getToStringMessage();
	}
	
/**
 * 
 * Creates new {@link Arguments} object with {@link Argument} objects created by data from specified {@link Map}.
 * 
 * @param map Map object which as key contains argument variables and as value contains argument values.
 *
 */
	public Arguments(Map<String, Object> map) {
		
		if(map == null) throw new NullPointerException("Argument map must be not-null.");
		if(map.containsKey("") || map.containsKey(null)) throw new ArgumentException("Variable must be not-null.");
		
		this.argMap = map;
		
		toString = getToStringMessage();
	}
	
/**
 * 
 * Returns new {@link Arguments} object contained arguments which contains in specified Arguments object and in specified {@link ArgumentBlock} object.
 * 
 * @param arguments Arguments object contained arguments.
 * @param block ArgumentBlock object contained arguments which needs to add to the new Argument object. 
 * 
 * @return new Arguments object contained arguments which contains in specified Arguments object and in specified ArgumentBlock object.
 * 
 */
	public static Arguments adaptArguments(Arguments arguments, ArgumentBlock block) {
		
		List<Argument> resultList = new ArrayList<>();
		
		String[] variables = arguments.getVariables();
		
		for(String var : variables) if(block.containsVariables(var)) resultList.add(new Argument(var, arguments.getValue(var)));
		
		return new Arguments(resultList.toArray(new Argument[0]));
	}
	
/**
 * 
 * Returns new {@link Argument} object with specified variable and value contained by this variable key. 
 * If variable equals null or empty string and also if the variable does not contain in this {@link Arguments} object then throws ArgumentException.
 * 
 * @param var Variable of argument.
 * 
 * @return New Argument object contained specified variable and value related to it by key in this Arguments object.
 * 
 * @see ArgumentException
 * 
 */
	public Argument getArgument(String var) {
		
		checkVariable(var);
		
		return new Argument(var, argMap.get(var));
	}
	
/**
 * 
 * Returns string array which contains all argument variables contained in this {@link Arguments} object.
 * 
 * @return String array with all argument variables which contains in this object.
 *
 */
	public String[] getVariables() {
		
		return argMap.keySet().toArray(new String[0]);
	}
	
/**
 * 
 * Returns object array which contains all argument values contained in this {@link Arguments} object.
 * 
 * @return Object array with all argument values which contains in this object.
 *
 */
	public Object[] getValues() {
		
		return argMap.values().toArray();
	}
	
/**
 * 
 * Returns {@link Argument} array created by data from this {@link Arguments} object.
 * 
 * @return Argument array contained in this {@link Arguments} object.
 *
 */
	public Argument[] getArguments() {
		
		List<Argument> resultList = new ArrayList<>();
		
		for(String var : getVariables()) {
			
			resultList.add(new Argument(var, argMap.get(var)));
		}
		
		return resultList.toArray(new Argument[0]);
	}
	
/**
 * 
 * Returns value object by specified variable. 
 * If variable equals null or empty string and also if the variable does not contain in this {@link Arguments} object then throws ArgumentException.
 * 
 * @param var Variable for finding the value.
 * 
 * @return Value object related by specified variable.
 * 
 * @see ArgumentException
 *
 */
	public Object getValue(String var) {
		
		checkVariable(var);
		
		return argMap.get(var);
	}
	
/**
 * 
 * Returns value object by specified variable or it does not contain in this {@link Arguments} object then returns specified object.
 * 
 * @param var Variable for finding the value.
 * @param object Object which returns if specified variable does not contain.
 * 
 * @return Value object related by specified variable or specified object if it does not contain.
 * 
 */
	public Object getValueOrOther(String var, Object object) {
		
		return argMap.get(var) != null ? argMap.get(var) : object;
	}
	
/**
 * 
 * Returns result of containing specified variable in this {@link Arguments} object. If it contains then returns true, otherwise returns false.
 * 
 * @param var Variable for contain checking.
 * 
 * @return True if specified variable contains, otherwise returns false.
 *
 */
	public boolean containsArgument(String var) {
		
		return argMap.containsKey(var);
	}
	
/**
 * 
 * Returns specified object by result of containing specified variable in this {@link Arguments} object. 
 * If it contains then returns {@code ifTrue} object, otherwise returns {@code ifFalse} object.
 * 
 * @param var Variable for contain checking.
 * @param ifTrue Object returns if specified variable contains.
 * @param ifFalse Object returns if specified variable does not contain.
 * 
 * @return {@code ifTrue} object if variable contains, otherwise returns {@code ifFalse} object.
 *
 */
	public Object containsArgument(String var, Object ifTrue, Object ifFalse) {
		
		return containsArgument(var) ? ifTrue : ifFalse;
	}
	
/**
 * 
 * Returns number of contained arguments in this {@link Arguments} object.
 * 
 * @return Number of contained arguments in this Arguments object.
 *
 */
	public int getSize() {
	
		return argMap.size();
	}
	
/**
 * 
 * Returns information about contained arguments in this {@link Arguments} object.
 * Each argument submitted like a block which contains all argument data. 
 * Each data block contains name of argument variable and argument value.
 * <blockquote>
 * For example:
 * 
 * [[argument: -start; value: null], [argument: color; value: RED]]
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
 * Checks specified variable for containing in this {@link Arguments} object. If it does not contains the throws ArgumentException.
 * 
 * @param var Variable for checking.
 * 
 * @see ArgumentException
 * 
 */
	private void checkVariable(String var) {
		
		if(!containsArgument(var)) throw new ArgumentException("The \"" + var + "\" argument is not include in these arguments");
	}
	
/**
 * 
 * Returns string which contains all argument data in blocks in {@link Collection#toString()} style.
 * <blockquote>
 * For example:
 * 
 * [[argument: -start; value: null], [argument: color; value: RED]]
 * </blockquote> 
 * 
 * @return String with all argument data.
 *
 */
	private String getToStringMessage() {
		
		Iterator<String> iterator = argMap.keySet().iterator();
		
		if(!iterator.hasNext()) return "[]";
		
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		
		while(true) {
			
			String var = iterator.next();
			
			builder.append(String.format("[argument: %s; value: %s]", var, argMap.get(var)));
			
			if(!iterator.hasNext()) return builder.append("]").toString();
			
			builder.append(", ");
		}
	}
}