package com.example.app.questionsservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    private int serviceId;
    private String username;
    private String description;
    private String response;

    public Question() {
    }

    public Question(int serviceId, String username, String description, String response) {
        this.serviceId = serviceId;
        this.username = username;
        this.description = description;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() { return serviceId; }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
