package com.microsystem.tourismServicesService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

@Entity
public class CountryInformation {

    @Id
    @GeneratedValue
    private int id;
    private String officialName;
    private String currency;
    private String capital;
    private String subRegion;
    //private String flag;
    private long population;
    private String timeZone;

    public CountryInformation(){

    }

    

    public CountryInformation(int id, String officialName, String currency, String capital, String subRegion, long population, String timeZone) {
        this.id = id;
        this.officialName = officialName;
        this.currency = currency;
        this.capital = capital;
        this.subRegion = subRegion;
        this.population = population;
        this.timeZone = timeZone;
    }


    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getOfficialName() {
        return officialName;
    }



    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }



    public String getCurrency() {
        return currency;
    }



    public void setCurrency(String currency) {
        this.currency = currency;
    }



    public String getCapital() {
        return capital;
    }



    public void setCapital(String capital) {
        this.capital = capital;
    }



    public String getSubRegion() {
        return subRegion;
    }



    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }



    public long getPopulation() {
        return population;
    }



    public void setPopulation(long population) {
        this.population = population;
    }



    public String getTimeZone() {
        return timeZone;
    }



    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

   
    
}
