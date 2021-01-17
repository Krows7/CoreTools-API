package net.coretools.core.parse;

import static java.util.Arrays.asList;
import static net.coretools.core.ArrayTools.appendArrays;
import static net.coretools.core.CollectionTools.createPulledElementArray;
import static net.coretools.core.CollectionTools.createPulledElementList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.coretools.core.ArrayTools;
import net.coretools.core.argument.Argument;
import net.coretools.core.argument.Arguments;

/**
 * 
 * @since 1.4.9 (2'nd patch)
 * 
 * @author Krows
 *
 */
public class Elements implements Parser {
	
	private Map<String, List<Element>> elementMap;
	
	public Elements(Element... elements) {
		
		elementMap = new HashMap<>();
		
		ArrayTools.forEach(elements, e -> elementMap.computeIfAbsent(e.getID(), (k) -> new ArrayList<>(elements.length)).add(e));
	}
	 
	public Elements(Parser other) {

		this(other.getAllElements());
	}

	@Override
	public String getAttributeByID(String id) {

		if(!containsID(id)) return null;
		
		return elementMap.get(id).get(0).getAttribute();
	}

	@Override
	public String[] getIDTags(String id) {

		return null;
	}

	@Override
	public String[] getElementIDs() {

		return elementMap.keySet().toArray(new String[0]);
	}

	@Override
	public String[] getAttributesByID(String id) {

		if(!containsID(id)) return null;
		
		return createPulledElementArray(elementMap.get(id), value -> value.getAttribute());
	}

	@Override
	public Argument getArgumentByID(String id, String var) {

		if(!containsID(id)) return null;
		
		return elementMap.get(id).get(0).getArguments().getArgument(var);
	}

	@Override
	public Arguments getArgumentsByID(String id) {

		if(!containsID(id)) return null;
		
		return elementMap.get(id).get(0).getArguments();
	}

	@Override
	public Arguments[] getAllArgumentsByID(String id) {

		if(!containsID(id)) return null;
		
		return createPulledElementArray(elementMap.get(id), value -> value.getArguments());
	}
	
	@Override
	public Element getElementByID(String id) {
	
		if(!containsID(id)) return null;
		
		return elementMap.get(id).get(0);
	}

	@Override
	public Element[] getElementsByID(String id) {

		if(!containsID(id)) return null;
		
		return elementMap.get(id).toArray(new Element[0]);
	}

	@Override
	public Element[] getAllElements() {

		return appendArrays(createPulledElementArray(elementMap.values(), value -> value.toArray(new Element[0])));
	}

	@Override
	public Iterator<String> getAttributeIterator(String id) {

		if(!containsID(id)) return null;
		
		return createPulledElementList(elementMap.get(id), value -> value.getAttribute()).iterator();
	}

	@Override
	public Iterator<Arguments> getArgumentsIterator(String id) {

		if(!containsID(id)) return null;
		
		return createPulledElementList(elementMap.get(id), value -> value.getArguments()).iterator();
	}

	@Override
	public Iterator<Element> getElementIterator(String id) {
		
		if(!containsID(id)) return null;
		
		return elementMap.get(id).iterator();
	}

	@Override
	public Iterator<Element> getAllElementsIterator() {

		return asList(appendArrays(createPulledElementArray(elementMap.values(), value -> value.toArray(new Element[0])))).iterator();
	}

	@Override
	public boolean containsID(String id) {

		String[] ids = getElementIDs();
		
		return ids != null && Arrays.asList(ids).contains(id);
	}
}