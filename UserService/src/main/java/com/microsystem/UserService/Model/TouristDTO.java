package com.microsystem.UserService.Model;

public class TouristDTO {

    private String username;
    private String name;
    private int age;
    private String photo;

    public TouristDTO() {
    }

    public TouristDTO(String username, String name, int age, String photo) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.photo = photo;
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
}
