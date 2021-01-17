package net.coretools.core.parse;

import java.util.Iterator;

import net.coretools.core.argument.Argument;
import net.coretools.core.argument.Arguments;

/**
 * 
 * Parser interface is main object of the package which is using for working with parsing of texts or codes. 
 * The basic realization of the interface is {@link AbstractParser}. 
 * 
 * @since 1.4.9
 * 
 * @author Krows
 *
 */
public interface Parser {
	
/**
 * 
 * Returns string attribute data of first element found in text with same ID that and specified ID. 
 * If text doesn't contain element with the ID then returns null.
 * 
 * @param id Element ID.
 * 
 * @return Attribute from element with specified ID.
 * 
 */
	public String getAttributeByID(String id);
	
/**
 * 
 * Returns element tags formalized for current text format.
 * 
 * @param id Element ID.
 * 
 * @return String element tags. If parser is basic then returns null.
 * 
 */
	public String[] getIDTags(String id);
	
/**
 * 
 * Returns all element IDs found in the text. 
 * 
 * @return Text's element IDs.
 * 
 */
	public String[] getElementIDs();
	
/**
 * 
 * Returns attribute data of all elements found in text with same ID that and specified ID. 
 * Order of attributes is beginning from text start to end. If text doesn't contain element with the ID then returns null.
 * 
 * @param id Element ID.
 * 
 * @return Attributes from elements with specified ID.
 * 
 */
	public String[] getAttributesByID(String id);
	
	public Argument getArgumentByID(String id, String var);
	
/**
 * 
 * Returns {@link Arguments} object which contains all arguments from first element found in text with same ID that ID from parameter. 
 * If text doesn't contain element with the ID returns null.
 * 
 * @param id Element ID.
 * 
 * @return Arguments from element with ID from parameter.
 * 
 */
	public Arguments getArgumentsByID(String id);
	
	public Arguments[] getAllArgumentsByID(String id);
	
	public Element getElementByID(String id);
	
	public Element[] getElementsByID(String id);
	
	public Element[] getAllElements();
	
	public Iterator<String> getAttributeIterator(String id);
	
	public Iterator<Arguments> getArgumentsIterator(String id);
	
	public Iterator<Element> getElementIterator(String id);
	
	public Iterator<Element> getAllElementsIterator();
	
	public boolean containsID(String id);
}