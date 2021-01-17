package net.coretools.core;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * Annotation reports about indecisive version of method or class. Therefore use them attentively.
 * 
 * @since 1.0.0 (old: 1.0)
 * 
 * @author Krows
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface OnDevelopment {
}