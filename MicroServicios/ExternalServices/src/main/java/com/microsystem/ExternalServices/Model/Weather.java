package com.microsystem.ExternalServices.Model;

import java.util.Date;

public class Weather {
    
    private long id;
    private Date date;
    private double maxTemp;  
    private double minTemp; 
    private double avgTemp;
    private String condition;

    public Weather() {
    
    }

    public Weather(long id, Date date, double maxTemp, double minTemp, double avgTemp, String condition) {
        this.id = id;
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.avgTemp = avgTemp;
        this.condition = condition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Weather [avgTemp=" + avgTemp + ", condition=" + condition + ", date=" + date + ", id=" + id
                + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + "]";
    }

    

}
