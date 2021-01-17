package net.coretools.core;

import static net.coretools.core.CollectionTools.createModifiableListOf;
import static net.coretools.core.CollectionTools.removeElementsFromBegin;
import static net.coretools.core.CollectionTools.removeElementsFromEnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * The SystemTools class is used to simplify common development things relatively console, objects, threads, and etc.
 * 
 * @since 1.0.0 (old: 1.0)
 * 
 * @author Krows
 * 
 */
@OnDevelopment
public final class SystemTools {
	
/**
 * 
 * Closed constructor.
 * 
 */
	private SystemTools() {

	}
	
/**
 * 
 * Prints in the system InputStream class used stack trace.
 * 
 */
	@OnDevelopment
	public static void printStack() {

		printStack(0);
	}
	
/**
 * 
 * Prints in the system InputStream class certain number of elements from used stack trace.
 * 
 * @param elementCount Number of needed count of stack trace elements.
 * 
 */	
	@OnDevelopment
	public static void printStack(int elementCount) {
		
		Collection<StackTraceElement> elementList = removeElementsFromBegin(3, createModifiableListOf(Thread.currentThread().getStackTrace()));
		
		removeElementsFromEnd(elementCount, elementList).forEach(System.out::println);
	}
	
/**
 * 
 * Creates deep clone of the object and returns Serializing modified clone of object. 
 * 
 * @param <T> Any generic type.
 * 
 * @param object object for deep cloning. This objects must implement {@link java.io.Serializable}.
 * 
 * @return Clone created with java Serializing tools.
 * 
 */
	@OnDevelopment
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T createClone(T object) {
		
		try {
			
			ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
			objectOutput.writeObject(object);
	
			ByteArrayInputStream byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
			
			ObjectInputStream objectInput = new ObjectInputStream(byteInput);
			
			return (T) objectInput.readObject();
		} catch(IOException e) {
			
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}