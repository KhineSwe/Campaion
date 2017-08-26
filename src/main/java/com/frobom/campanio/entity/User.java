package com.frobom.campanio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class User extends Person {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @Transient
    private String confirmedPassword;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = {
	    @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
		    @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private Role role;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
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

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
