package com.microsystem.ShoppingService.Model;

import java.util.List;

public class Service {
    private int id;
    private String title;
    private double price;
    private String description;
    private List<String> items;
    private String serviceType;
    private int providerId;

    public Service() {}
    
    public Service(int id, String title, double price, String description, List<String> items, String serviceType,
            int providerId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.items = items;
        this.serviceType = serviceType;
        this.providerId = providerId;
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

    public void setTitle(String title) {
        this.title = title;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    
}
