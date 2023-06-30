package com.example.membership.tools.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DateFormat, Date> {

    private static String DATE_PATTERN = "";

    @Override
    public void initialize(DateFormat constraintAnnotation) {
        DATE_PATTERN = constraintAnnotation.format();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(value.toString());
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
}
