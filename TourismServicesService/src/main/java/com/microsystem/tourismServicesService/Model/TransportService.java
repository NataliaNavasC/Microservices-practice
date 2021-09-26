package com.microsystem.tourismServicesService.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class TransportService extends TourismService {
    
    private Date departureDate;
    private Date arrivalDate;
    private String transportType;
    private Location depature;
    private Location destination;

    public TransportService() {}

    public TransportService(int id, String title, double price, String description, List<String> items,
            Date departureDate, Date arrivalDate, String transportType, Location depature, Location destination) {
        super(id, title, price, description, items);
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.transportType = transportType;
        this.depature = depature;
        this.destination = destination;
    }
    
    public TransportService(Date departureDate, Date arrivalDate, String transportType, Location depature,
            Location destination) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.transportType = transportType;
        this.depature = depature;
        this.destination = destination;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public String getTransportType() {
        return transportType;
    }
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
    public Location getDepature() {
        return depature;
    }
    public void setDepature(Location depature) {
        this.depature = depature;
    }
    public Location getDestination() {
        return destination;
    }
    public void setDestination(Location destination) {
        this.destination = destination;
    }

    
    
}
