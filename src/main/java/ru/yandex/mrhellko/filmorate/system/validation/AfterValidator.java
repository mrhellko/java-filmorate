package ru.yandex.mrhellko.filmorate.system.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AfterValidator implements ConstraintValidator<After, LocalDate> {

    private LocalDate date;

    @Override
    public void initialize(After annotation) {
        date = LocalDate.parse(
                annotation.value(),
                DateTimeFormatter.ofPattern(annotation.pattern())
        );
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return value != null && value.isAfter(date);
    }
}
