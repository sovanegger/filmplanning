package cz.tomsovsky.bc.filmplanning.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotace, která při použití u atributu zjištuje, je-li jeho hodnota
 * jedinečná a není-li již obsažena v databázi.
 * 
 * @author Martin Tomšovský
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldUniquenessValidator.class)
@Documented
public @interface FieldUniqueness {
	
	Field[] fields();
	
	String message() default "";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
