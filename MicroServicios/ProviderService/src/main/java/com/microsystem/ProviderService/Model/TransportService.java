package com.microsystem.ProviderService.Model;

import java.util.Date;
import java.util.List;

public class TransportService extends TourismService {

    private Date departureDate;
    private Date arrivalDate;
    private String transportType;
    private String depature;
    private String destination;

    public TransportService() {
        super.setServiceType("transport");
    }

    public TransportService(Date departureDate, Date arrivalDate, String transportType, String depature,
                            String destination) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.transportType = transportType;
        this.depature = depature;
        this.destination = destination;
        super.setServiceType("transport");
    }

    public TransportService(int id, String title, double price, String description, List<String> items,
                            String serviceType, Date departureDate, Date arrivalDate, String transportType,
                            String depature, String destination) {
        super(id, title, price, description, items, serviceType);
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.transportType = transportType;
        this.depature = depature;
        this.destination = destination;
        super.setServiceType("transport");
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
    public String getDepature() {
        return depature;
    }
    public void setDepature(String depature) {
        this.depature = depature;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }



}