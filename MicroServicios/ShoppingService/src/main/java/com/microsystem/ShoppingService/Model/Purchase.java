package com.microsystem.ShoppingService.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Purchase {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String status;
    private String paymentMethod;
    private double total;
    @ElementCollection
    private List<Integer> servicesIds;

    public Purchase(int id, String userName, String status, String paymentMethod, double total,
            List<Integer> servicesIds) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.servicesIds = servicesIds;
    }

    public Purchase() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Integer> getServicesIds() {
        return servicesIds;
    }

    public void setServicesIds(List<Integer> servicesIds) {
        this.servicesIds = servicesIds;
    }

}
