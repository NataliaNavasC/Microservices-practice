package com.microsystem.TouristService.Model;

import javax.persistence.*;

@Entity
public class Tourist {
    @Id
    @GeneratedValue
    private int ID;
    @Column(unique = true)
    private String username;
    private String name;
    private int age;
    private String photo;
    private String description;

    public Tourist() {
    }
    

    public Tourist(int iD, String username, String name, int age, String photo, String description) {
        ID = iD;
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


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
