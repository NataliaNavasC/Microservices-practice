package com.microsystem.TouristService.Model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int ID;
    @Column(unique = true)
    private String username;
    private String name;
    private int age;
    private String password;
    private String photo;

    public Customer() {
    }

    public Customer(int ID, String username, String name, int age, String password, String photo) {
        this.ID = ID;
        this.username = username;
        this.name = name;
        this.age = age;
        this.password = password;
        this.photo = photo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
