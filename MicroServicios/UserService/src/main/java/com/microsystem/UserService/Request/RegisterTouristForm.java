package com.microsystem.UserService.Request;

public class RegisterTouristForm{
    
    private String username;
    private String name;
    private int age;
    private String photo;
    private String password;
    private String description;

    public RegisterTouristForm() {
    }


    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public RegisterTouristForm(String username, String name, int age, String photo, String password,
            String description) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.password = password;
        this.description = description;
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


