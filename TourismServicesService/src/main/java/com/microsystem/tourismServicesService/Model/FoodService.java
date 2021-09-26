package com.microsystem.tourismServicesService.Model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class FoodService extends TourismService{
    
    private String foodType;

    public FoodService(){
        super.setServiceType("FOOD_SERVICE");
    }
    

    public FoodService(String foodType) {
        this.foodType = foodType;
        super.setServiceType("FOOD_SERVICE");
    }

    public FoodService(int id, String title, double price, String description, List<String> items, String serviceType,
            int providerId, String foodType) {
        super(id, title, price, description, items, serviceType, providerId);
        this.foodType = foodType;
        super.setServiceType("FOOD_SERVICE");
    }

    public String getType() {
        return foodType;
    }

    public void setType(String foodType) {
        this.foodType = foodType;
    }
}
