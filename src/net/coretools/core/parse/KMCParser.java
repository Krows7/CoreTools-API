package net.coretools.core.parse;

import static net.coretools.core.ArrayTools.elementArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import net.coretools.core.argument.Argument;
import net.coretools.core.argument.Arguments;

/**
 * 
 * 
 * 
 * @since 1.4.9
 * 
 * @author Krows
 *
 */
public class KMCParser extends AbstractParser {
	
/**
 * 
 * 
 * 
 * @since 1.4.9 (2'nd patch)
 * 
 * @author Krows
 *
 */
	public static class KMCElements extends Elements {
		
		public KMCElements(KMCParser other) {
			
			super(other);
		}
		
		@Override
		public String[] getIDTags(String id) {
		
			return elementArray(BEGIN_BRACKET + id + END_BRACKET, BEGIN_BRACKET + SLASH_SYMBOL + id + END_BRACKET);
		}
	}
	
	private final static String BEGIN_BRACKET = "<";
	private final static String END_BRACKET = ">";
	private final static String MARK_SYMBOL = "\"";
	private final static String SLASH_SYMBOL = "/";
	
	public KMCParser(String text) {

		super(text);
	}
	
	@Override
	public String[] getIDTags(String id) {
		
		if(isChecked) return super.getIDTags(id);
		
		return elementArray(BEGIN_BRACKET + id + END_BRACKET, BEGIN_BRACKET + SLASH_SYMBOL + id + END_BRACKET);
	}
	
	@Override
	public String[] getElementIDs() {
		
		if(isChecked) return super.getElementIDs();

		int begin = text.indexOf(BEGIN_BRACKET + SLASH_SYMBOL);
		int end = text.indexOf(END_BRACKET, begin);
		
		List<String> idList = new ArrayList<>();
		
		while(begin != - 1) {
			
			begin += 2;
			
			String id = text.substring(begin, end);
			
			if(!idList.contains(id)) idList.add(id);
			
			begin = text.indexOf(BEGIN_BRACKET + SLASH_SYMBOL, end);
			
			end = text.indexOf(END_BRACKET, begin);
		}
		
		return idList.toArray(new String[0]);
	}
	
	@Override
	public String[] getAttributesByID(String id) {
	
		if(isChecked) return super.getAttributesByID(id);
		
		String[] elements = getIDTags(id);
		
		List<String> resultList = new LinkedList<>();
		
		int begin = text.indexOf(elements[0].substring(0, elements[0].length() - 1));
		int end = text.indexOf(elements[1], begin);
		
		while(begin != - 1) {
			
			begin = text.indexOf(END_BRACKET, begin) + 1;
			
			resultList.add(text.substring(begin, end));
			
			begin = text.indexOf(elements[0].substring(0, elements[0].length() - 1), end);
			
			end = text.indexOf(elements[1], begin);
		}
		
		return resultList.toArray(new String[0]);
	}
	
	@Override
	public Arguments[] getAllArgumentsByID(String id) {
	
		if(isChecked) return super.getAllArgumentsByID(id);
		
		String element = getIDTags(id)[0];
		
		int begin = text.indexOf(element.substring(0, element.length() - 1));
		int end;
		
		List<Arguments> resultList = new LinkedList<>();
		
		while(begin != - 1) {
			
			begin += element.length() - 1;
			
			end = text.indexOf(END_BRACKET, begin);
			
			List<Argument> argumentList = new LinkedList<>();
			
			try(Scanner scanner = new Scanner(text.substring(begin, end))) {
				
				while(scanner.hasNext()) {
					
					String var = scanner.next();
					
					scanner.next();
					
					String value = scanner.next();
					
					if(value.startsWith(MARK_SYMBOL)) {
						
						value = value.substring(1);
						
						if(value.endsWith(MARK_SYMBOL)) {
							
							value = value.substring(0, value.length() - 1);
						} else {
						
							while(true) {
								
								value += " " + scanner.next();
								
								if(value.endsWith(MARK_SYMBOL)) {
									
									value = value.substring(0, value.length() - 1);
									
									break;
								}
							}
						}
					}
					
					argumentList.add(new Argument(var, value));
				}
			}
			
			begin = text.indexOf(element.substring(0, element.length() - 1), end);
			
			resultList.add(new Arguments(argumentList.toArray(new Argument[0]).clone()));
		}
		
		return resultList.toArray(new Arguments[0]);
	}
	
	@Override
	public Element[] getElementsByID(String id) {
	
		if(isChecked) return super.getElementsByID(id);
		
		String[] attributes = getAttributesByID(id);
		
		Arguments[] arguments = getAllArgumentsByID(id);
		
		List<Element> elementList = new ArrayList<>(attributes.length);
		
		for(int i = 0; i < attributes.length; i++) {
			
			elementList.add(new Element(id, attributes[i], arguments[i]));
		}
		
		return elementList.toArray(new Element[0]);
	}
	
	@Override
	public Element[] getAllElements() {
	
		if(isChecked) return super.getAllElements();
		
		List<Element> resultList = new ArrayList<>();
		
		String[] ids = getElementIDs();
		
		for(String id : ids) {
			
			Element[] elements = getElementsByID(id);
			
			for(Element element : elements) {
				
				resultList.add(element);
			}
		}
		
		return resultList.toArray(new Element[0]);
	}
}