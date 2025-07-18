package com.adrar.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PastOrPresentYearValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PastOrPresentYear {
    String message() default "{javax.validation.constraints.PastOrPresentYear.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int min() default 1800;
}

