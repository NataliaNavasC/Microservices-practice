package com.microsystem.ShoppingService.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private int id;
    private String paymentMethod;
    private String status;
    private int total;
    @OneToMany
    private List<Service> services;

    public ShoppingCart(int id, String paymentMethod, String status, int total, List<Service> services) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.total = total;
        this.services = services;
    }

    public ShoppingCart() {
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
