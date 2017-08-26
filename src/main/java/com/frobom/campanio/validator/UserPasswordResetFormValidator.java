package com.frobom.campanio.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.frobom.campanio.form.PasswordResetForm;

@Component("userPasswordResetFormValidator")
public class UserPasswordResetFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PasswordResetForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordResetForm user = (PasswordResetForm) target;
        if (!user.getPassword().equals(user.getConfirmedPassword())) {
            errors.rejectValue("confirmedPassword", "password.notMatched", "Passwords do not match.");
        }
    }
}
