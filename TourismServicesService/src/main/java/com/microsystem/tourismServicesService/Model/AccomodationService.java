package com.microsystem.tourismServicesService.Model;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;

@Entity
public class AccomodationService extends TourismService {
    
    private Date checkInDate;
    private Date checkOutDate;
    private String location;

    public AccomodationService(){
        super.setServiceType("accomodation");
    }
    
    public AccomodationService(Date checkInDate, Date checkOutDate, String location) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
        super.setServiceType("accomodation");
    }

    

    public AccomodationService(int id, String title, double price, String description, List<String> items,
            String serviceType, int providerId, Date checkInDate, Date checkOutDate, String location) {
        super(id, title, price, description, items, serviceType, providerId);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
        super.setServiceType("accomodation");
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    
}
