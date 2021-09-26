package com.microsystem.tourismServicesService.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class AccomodationService extends TourismService {
    
    private Date checkInDate;
    private Date checkOutDate;
    private Location location;

    public AccomodationService(){}

    
    public AccomodationService(int id, String title, double price, String description, List<String> items,
            Date checkInDate, Date checkOutDate, Location location) {
        super(id, title, price, description, items);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
    }


    public AccomodationService(Date checkInDate, Date checkOutDate, Location location) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
    }


    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }


    
}
