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
 * @created 08.02.2022
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TaskStatusValidator.class)
public @interface ValidTaskStatus {

    String message() default "Status must take one of the values: TO_DO, IN_PROGRESS, DONE";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
