package net.coretools.core;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * OnQuestion annotation indicates about that the reason of stay of the type, field or method is questionable.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface OnQuestion {
	
/**
 * 
 * Status enum is used for indicating {@link OnQuestion} annotation the expected event with element which was indicated by that annotation.
 * 
 * @since 1.5.0
 *
 * @author Krows
 * 
 */
	public enum Status {
		
/**
 * 
 * Indicates that the element is expected will be removed.
 * 
 */
		REMOVE,
		
/**
 * 
 * Indicates that the element is expected will be renamed.
 * 
 */
		RENAME,
		
/**
 * 
 * Indicates that the element expected will be replace to another class or package.
 * 
 */
		REPLACE,
		
/**
 * 
 * Indicates that the logic of the element is expected will be edited.
 * 
 */
		EDIT;
	}
	
/**
 * 
 * Expected status of the element. See {@link Status}.
 * 
 */
	public Status status();
	
/**
 * 
 * Description of the expected event with element. It can be empty string.
 * 
 */
	public String description() default "";
}