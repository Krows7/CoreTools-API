package net.coretools.core.argument;

/**
 * 
 * ArgumentException is thrown to indicate that in argument contains illegal objects or they are not at all. Details of the exception usually indicated in the message.
 * 
 * @since 1.3.0 (old: 1.3)
 * 
 * @author Krows
 * 
 */
public class ArgumentException extends RuntimeException {
	
/**
 * 
 * Serial version UID for serialization.
 * 
 */
	private static final long serialVersionUID = 1L;

/**
 * 
 * Creates new {@link ArgumentException} without detail message.
 *  
 * @see RuntimeException#RuntimeException()
 * 
 */
	public ArgumentException() {

		super();
	}
	
/**
 * 
 * Creates new {@link ArgumentException} with message string for detailing of exception.
 * 
 * @param message Message for detailing.
 * 
 * @see RuntimeException#RuntimeException(String)
 * @see Exception#getMessage()
 * 
 */
	public ArgumentException(String message) {
		
		super(message);
	}
}