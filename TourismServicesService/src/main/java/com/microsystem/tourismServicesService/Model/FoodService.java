package com.microsystem.tourismServicesService.Model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class FoodService extends TourismService{
    
    private String type;

    public FoodService(){}
   
    public FoodService(String type) {
        this.type = type;
    }

    public FoodService(int id, String title, double price, String description, List<String> items, String type) {
        super(id, title, price, description, items);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
