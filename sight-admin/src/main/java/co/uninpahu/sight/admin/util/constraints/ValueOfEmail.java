package co.uninpahu.sight.admin.util.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ANNOTATION_TYPE, TYPE_USE, METHOD, PARAMETER, FIELD, CONSTRUCTOR})
@Retention(RUNTIME)
@Constraint(validatedBy = ValueOfEmailValidator.class)
public @interface ValueOfEmail {
    String message() default "El formato del correo está incorrecto";
    Class<?> [] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
