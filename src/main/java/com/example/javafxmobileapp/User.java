package com.example.javafxmobileapp;

/**
 * User class used to create and confirm user info in User object.
 */
public class User {

    private Long id;
    private String email;
    private String name;
    private String password;

        public User() {
    }
    /**
     *
     * @param email needed for creating account.
     * @param name  username for logging-in.
     * @param password for confirming right user try logging in on right username and password.
     */
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
