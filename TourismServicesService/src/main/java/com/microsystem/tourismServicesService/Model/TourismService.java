package com.microsystem.tourismServicesService.Model;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TourismService {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private double price;
    private String description;
    @ElementCollection
    private List<String> items;

    
    public TourismService() {
    }
    
    public TourismService(int id, String title, double price, String description, List<String>items) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.items = items;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
}
