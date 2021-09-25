package com.microsystem.ProviderService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    private int id_Provider;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String webPage;
    private String socialNetwork;

    public Provider(){

    }

    public Provider(String phoneNumber, String webPage, String socialNetwork) {
        //TODO: Analizar y arrojar errores
        this.phoneNumber = phoneNumber;
        this.webPage = webPage;
        this.socialNetwork = socialNetwork;
    }

    public int getID() {
        return id_Provider;
    }

    public void setID(int ID) {
        this.id_Provider = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
