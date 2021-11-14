package com.microsystem.ShoppingService.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String userName;
    @ElementCollection
    private List<Integer> servicesIds;

    public ShoppingCart(int id, String userName, List<Integer> servicesIds) {
        this.id = id;
        this.userName = userName;
        this.servicesIds = servicesIds;
    }

    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getServicesIds() {
        return servicesIds;
    }

    public void setServicesIds(List<Integer> servicesIds) {
        this.servicesIds = servicesIds;
    }

}
