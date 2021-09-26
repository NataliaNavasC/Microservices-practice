package com.microsystem.tourismServicesService.Model;

import java.util.List;

public class EcoTripService extends TourismService {
    
    private int duration;
    private boolean hasGuide;
    private Location location;

    public EcoTripService() {
    }

    public EcoTripService(int id, String title, double price, String description, List<String> items, int duration,
            boolean hasGuide, Location location) {
        super(id, title, price, description, items);
        this.duration = duration;
        this.hasGuide = hasGuide;
        this.location = location;
    }
    public EcoTripService(int duration, boolean hasGuide, Location location) {
        this.duration = duration;
        this.hasGuide = hasGuide;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
    
}

