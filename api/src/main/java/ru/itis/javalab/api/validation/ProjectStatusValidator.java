package ru.itis.javalab.api.validation;

import ru.itis.javalab.api.enums.ProjectStatus;
import ru.itis.javalab.api.enums.TaskStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Киямдинов Ильдар
 * @project test_akvelon
 * @created 07.02.2022
 */

public class ProjectStatusValidator
        implements ConstraintValidator<ValidProjectStatus, ProjectStatus> {

    @Override
    public void initialize(ValidProjectStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ProjectStatus s, ConstraintValidatorContext constraintValidatorContext) {
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
