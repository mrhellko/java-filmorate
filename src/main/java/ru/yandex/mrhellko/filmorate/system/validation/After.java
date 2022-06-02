package ru.yandex.mrhellko.filmorate.system.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AfterValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface After {
    String message() default "Должно быть позже некоторой даты";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();

    String pattern() default "yyyy-MM-dd";
}
