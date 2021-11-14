package com.microsystem.UserService.Model;

public class TouristDTO {

    private String username;
    private String name;
    private int age;
    private String photo;
    private String description;

    public TouristDTO() {
    }

    

    public TouristDTO(String username, String name, int age, String photo, String description) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.description = description;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
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
}
