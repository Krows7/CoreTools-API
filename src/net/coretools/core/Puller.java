package net.coretools.core;

import net.coretools.core.OnQuestion.Status;

/**
 * 
 * Puller interface contains one method which pull from T type E type(It can be field, method, constructor, computing and etc.).
 * 
 * @since 1.1.0 (old: 1.1)
 * 
 * @author Krows
 *
 * @param <T> Input type.
 * @param <E> Output type.
 * 
 */
@FunctionalInterface
@Deprecated
@OnQuestion(status = Status.REMOVE, description = "For this interface there is an alternative in the form of *Function* interface.")
public interface Puller<T, E> {
	
/**
 * 
 * This method applies to T object and takes E object. 
 * 
 * <blockquote>
 * For example:
 * <pre>
 * Puller&#706;Ball, Color&#707; puller = new Puller&#706;&#707;() {
 * 	
 * 	public Color pull(Ball ball) {
 * 		
 * 		return ball.getColor();
 * 	}
 * };
 * 
 * Puller&#706;Ball, Color&#707; puller = value -&#62; value.getColor();
 * 
 * doSomething(value -&#62; value.getColor());
 * </pre>
 * </blockquote>
 * 
 * @param t Input object.
 * 
 * @return Pulled object.
 * 
 */
	public E pull(T t);
}