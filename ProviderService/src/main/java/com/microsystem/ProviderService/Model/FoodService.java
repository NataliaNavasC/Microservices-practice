package com.microsystem.ProviderService.Model;

import java.util.List;

public class FoodService extends TourismService{

    private String foodType;

    public FoodService(){
        super.setServiceType("food");
    }


    public FoodService(String foodType) {
        this.foodType = foodType;
        super.setServiceType("food");
    }

    public FoodService(int id, String title, double price, String description, List<String> items, String serviceType, String foodType) {
        super(id, title, price, description, items, serviceType);
        this.foodType = foodType;
        super.setServiceType("food");
    }

    public String getType() {
        return foodType;
    }

    public void setType(String foodType) {
        this.foodType = foodType;
    }
}
