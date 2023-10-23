package com.nike.validation;

public abstract class BaseValidator {
    BaseValidator validator;

    protected BaseValidator() {
    }

    public void changeValidator(BaseValidator validator) {
        this.validator = validator;
    }
}
