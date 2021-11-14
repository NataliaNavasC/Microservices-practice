package com.microsystem.tourismServicesService.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AccomodationService extends TourismService {
    
    private Date checkInDate;
    private Date checkOutDate;
    private String city;
    private String location;
    private String weatherResourceLink;
    private String mapResourceLink;
    @OneToOne(cascade=CascadeType.ALL)
    private CountryInformation countryInformation;

    public AccomodationService(){
        super.setServiceType("accomodation");
    }
    
    public AccomodationService(Date checkInDate, Date checkOutDate, String city, String location, String weatherResourceLink, String mapResourceLink, CountryInformation countryInformation) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
        this.weatherResourceLink = weatherResourceLink;
        this.mapResourceLink = mapResourceLink;
        this.city = city;
        this.countryInformation = countryInformation;
        super.setServiceType("accomodation");
    }

    

    public AccomodationService(int id, String title, double price, String description, List<String> items,
            String serviceType, int providerId, Date checkInDate, Date checkOutDate, String city, String location, String weatherResourceLink, String mapResourceLink, CountryInformation countryInformation) {
        super(id, title, price, description, items, serviceType, providerId);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.location = location;
        this.weatherResourceLink = weatherResourceLink;
        this.mapResourceLink = mapResourceLink;
        this.countryInformation = countryInformation;
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
    public String getWeatherResourceLink() {
        return weatherResourceLink;
    }
    public void setWeatherResourceLink(String weatherResourceLink) {
        this.weatherResourceLink = weatherResourceLink;
    }

    public String getMapResourceLink() {
        return mapResourceLink;
    }

    public void setMapResourceLink(String mapResourceLink) {
        this.mapResourceLink = mapResourceLink;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryInformation getCountryInformation() {
        return countryInformation;
    }

    public void setCountryInformation(CountryInformation countryInformation) {
        this.countryInformation = countryInformation;
    }
    
    
    
}
