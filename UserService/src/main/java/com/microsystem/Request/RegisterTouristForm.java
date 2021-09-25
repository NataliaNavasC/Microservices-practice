package com.microsystem.Request;

public class RegisterTouristForm{
    
    private String username;
    private String name;
    private int age;
    private String photo;
    private String password;

    public RegisterTouristForm() {
    }

    public RegisterTouristForm(String username, String name, int age, String photo, String password) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}


