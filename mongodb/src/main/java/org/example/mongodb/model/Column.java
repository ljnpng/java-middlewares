package org.example.mongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author neo
 */
//@Target(ElementType.FIELD)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(value = RUNTIME)
public @interface Column {

    String value() default "";
}
