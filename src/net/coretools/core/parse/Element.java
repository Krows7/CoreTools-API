package net.coretools.core.parse;

import net.coretools.core.argument.Arguments;

/**
 * 
 * @since 1.4.9 (2'nd patch)
 * 
 * @author Krows
 *
 */
public class Element {

	private String id;
	private String attribute;
	
	private Arguments arguments;

	public Element(String id, String attribute, Arguments arguments) {
		
		this.id = id;
		
		this.attribute = attribute;
		
		this.arguments = arguments;
	}
	
	public String getID() {
	
		return id;
	}
	
	public String getAttribute() {
	
		return attribute;
	}
	
	public Arguments getArguments() {
	
		return arguments;
	}
	
	@Override
	public String toString() {
	
		return String.format("%s[ID: %s; Attribute: %s; Arguments: %s]", getClass().getSimpleName(), id, attribute, arguments);
	}
}