package net.coretools.core.parse;

import static net.coretools.core.ObjectTools.*;

import java.util.Arrays;
import java.util.Iterator;

import net.coretools.core.ObjectTools;
import net.coretools.core.argument.Argument;
import net.coretools.core.argument.Arguments;

/**
 * 
 * AbstractParser class is an abstract implementation of {@link Parser} for parsing texts.
 * 
 * @since 1.4.9
 * 
 * @author Krows
 *
 */
public class AbstractParser implements Parser {
	
/**
 * 
 * Text to parse.
 * 
 */
	protected String text;
	
/**
 * 
 * Parsed elements which contains in text.
 * 
 */
	protected Elements elements;
	
/**
 * 
 * Indicates whether text is checked and parsed or not.
 * 
 */
	protected boolean isChecked;
	
/**
 * 
 * Parses specified text and saves elements for interacting.
 * 
 * @param text Text to parse.
 *
 */
	public AbstractParser(String text) {
		
		this.text = text;
		
		this.isChecked = false;
		
		this.elements = new Elements(getAllElements());
		
		this.isChecked = true;
	}
	
	@Override
	public String getAttributeByID(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getAttributeByID(id));
	}
	
/**
 * 
 * {@inheritDoc} {@link AbstractParser} realization always returns null.
 * 
 */
	@Override
	public String[] getIDTags(String id) {
		
		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getIDTags(id));
	}

	@Override
	public String[] getElementIDs() {
		
		return valueOrNull(elements, elements.getElementIDs());
	}

	@Override
	public String[] getAttributesByID(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getAttributesByID(id));
	}

	@Override
	public Argument getArgumentByID(String id, String var) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getArgumentByID(id, var));
	}

	@Override
	public Arguments getArgumentsByID(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getArgumentsByID(id));
	}

	@Override
	public Arguments[] getAllArgumentsByID(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getAllArgumentsByID(id));
	}

	@Override
	public Element getElementByID(String id) {

		if(!containsID(id)) return null;
		
		return elements == null ? null : elements.getElementByID(id);
	}

	@Override
	public Element[] getElementsByID(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getElementsByID(id));
	}

	@Override
	public Element[] getAllElements() {

		return valueOrNull(elements, elements.getAllElements());
	}

	@Override
	public Iterator<String> getAttributeIterator(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getAttributeIterator(id));
	}

	@Override
	public Iterator<Arguments> getArgumentsIterator(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getArgumentsIterator(id));
	}

	@Override
	public Iterator<Element> getElementIterator(String id) {

		if(!containsID(id)) return null;
		
		return valueOrNull(elements, elements.getElementIterator(id));
	}

	@Override
	public Iterator<Element> getAllElementsIterator() {

		return valueOrNull(elements, elements.getAllElementsIterator());
	}

	@Override
	public boolean containsID(String id) {

		String[] ids = getElementIDs();
		
		return ids != null && ObjectTools.contains(id, ids);
	}
}