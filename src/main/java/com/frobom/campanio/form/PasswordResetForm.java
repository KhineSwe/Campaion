package com.frobom.campanio.form;

import org.hibernate.validator.constraints.NotBlank;

public class PasswordResetForm {

    private String token;

    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @NotBlank(message = "Confirm Password cannot be empty.")
    private String confirmedPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

}
