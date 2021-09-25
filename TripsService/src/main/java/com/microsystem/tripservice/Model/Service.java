package com.microsystem.tripservice.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private double price;
    private String description;
    //private List<String> items;

    public Service(int id, String title, double price, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        //this.items = items;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
