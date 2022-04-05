package com.alexeykuznetsov.currency.pojo;

import com.alexeykuznetsov.currency.model.Role;

import java.util.Set;

public class SignupRequest {
    private String username;
    private Set<String> roleSet;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<String> roleSet) {
        this.roleSet = roleSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
