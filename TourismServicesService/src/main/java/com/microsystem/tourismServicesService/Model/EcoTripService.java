package com.microsystem.tourismServicesService.Model;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class EcoTripService extends TourismService {
    
    private int duration;
    private boolean hasGuide;
    private String location;

    public EcoTripService() {
        super.setServiceType("ecoTrip");
    }

    public EcoTripService(int duration, boolean hasGuide, String location) {
        this.duration = duration;
        this.hasGuide = hasGuide;
        this.location = location;
        super.setServiceType("ecoTrip");
    }
    
    public EcoTripService(int id, String title, double price, String description, List<String> items,
            String serviceType, int providerId, int duration, boolean hasGuide, String location) {
        super(id, title, price, description, items, serviceType, providerId);
        this.duration = duration;
        this.hasGuide = hasGuide;
        this.location = location;
        super.setServiceType("ecoTrip");
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isHasGuide() {
        return hasGuide;
    }

    public void setHasGuide(boolean hasGuide) {
        this.hasGuide = hasGuide;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}

