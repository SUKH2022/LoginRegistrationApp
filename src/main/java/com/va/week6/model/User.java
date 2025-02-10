package com.va.week6.model;

import java.sql.Date;

/*
 * @author - Sukhpreet Saini
 * @date - 10/2/2025
 * Description - Assignment1_webdynimicApp 
 * 
 */

public class User {
    private String username;
    private String password;
    private String email;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}