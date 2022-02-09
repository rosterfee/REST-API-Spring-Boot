package ru.itis.javalab.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 07.02.2022
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ProjectStatusValidator.class)
public @interface ValidProjectStatus {

    String message() default "Status must take one of the values: NOT_STARTED, ACTIVE, COMPLETED";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
