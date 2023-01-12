package com.jsr303validator.validation.mylistvalidate;

import com.jsr303validator.vo.DuplicateRequest;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ValidDuplicate.CheckDuplicateRequest.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE})
@Retention(RUNTIME)
public @interface ValidDuplicate {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "";

    class CheckDuplicateRequest implements ConstraintValidator<ValidDuplicate, DuplicateRequest> {

        @Override
        public void initialize(ValidDuplicate constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(DuplicateRequest duplicateRequest, ConstraintValidatorContext constraintValidatorContext) {
            System.out.println("-----------------------------------");
            return false;
        }
    }
}
