package ru.itis.javalab.api.validation;

import ru.itis.javalab.api.enums.ProjectStatus;
import ru.itis.javalab.api.enums.TaskStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 08.02.2022
 */

public class TaskStatusValidator
        implements ConstraintValidator<ValidTaskStatus, TaskStatus> {

    @Override
    public void initialize(ValidTaskStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TaskStatus s, ConstraintValidatorContext constraintValidatorContext) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
