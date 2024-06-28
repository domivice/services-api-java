package org.domivice.services.application.common.validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.regex.Pattern;

@Documented
@Constraint(validatedBy = ValidDisplayName.DisplayNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDisplayName {
    String message() default "Name contains some invalid characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class DisplayNameValidator implements ConstraintValidator<ValidDisplayName, String> {
        private static final String NAME_PATTERN = "^[A-Za-zàèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸåÅæÆœŒçÇðÐøØß0-9.()\\[\\]]+([ '-][A-Za-zàèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸåÅæÆœŒçÇðÐøØß0-9.()\\[\\]]+)*$";
        private Pattern pattern;

        @Override
        public void initialize(ValidDisplayName constraintAnnotation) {
            pattern = Pattern.compile(NAME_PATTERN);
        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if (s == null) {
                return true; // Null values are not validated here
            }
            return pattern.matcher(s).matches();
        }
    }
}
