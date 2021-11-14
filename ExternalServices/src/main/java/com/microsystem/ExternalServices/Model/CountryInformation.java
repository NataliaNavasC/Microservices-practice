package com.microsystem.ExternalServices.Model;

import com.fasterxml.jackson.databind.JsonNode;

public class CountryInformation {
    private String officialName;
    private String currency;
    private String capital;
    private String subRegion;
    private String flag;
    private long population;
    private String timeZone;

    public CountryInformation(JsonNode root){
        this.officialName = root.get("name").get("official").asText();
        this.currency = root.get("currencies").fieldNames().next();
        this.capital = root.get("capital").get(0).asText();
        this.subRegion = root.get("subregion").asText();
        this.flag = root.get("flag").asText();
        this.population = root.get("population").asLong();
        this.timeZone = root.get("timezones").get(0).asText();
    }

    public String getOfficialName() {
        return officialName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCapital() {
        return capital;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public String getFlag() {
        return flag;
    }

    public long getPopulation() {
        return population;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
