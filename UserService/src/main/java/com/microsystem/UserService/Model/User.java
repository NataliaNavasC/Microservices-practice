package com.microsystem.UserService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class User {

    @GeneratedValue
    private long id;
    private String username;
    private String password;

    public User(){}

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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

    
}
