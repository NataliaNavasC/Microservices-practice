package com.microsystem.ShoppingService.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.microsystem.ShoppingService.Model.Purchase;
import com.microsystem.ShoppingService.Model.Service;
import com.microsystem.ShoppingService.Model.ShoppingCart;
import com.microsystem.ShoppingService.Repository.IPurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PurchaseController {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Purchase createPurchase(ShoppingCart shoppingCart, String paymentMethod){
        List<Integer> services = new ArrayList<>();
        for(int s: shoppingCart.getServicesIds()){
            services.add(s);
        }
        double totalPurchase = calculateTotalPurchase(services);
        Purchase newPurchase = new Purchase(0, shoppingCart.getUserName(), "In progress", paymentMethod, totalPurchase, services);
        return this.purchaseRepository.save(newPurchase);
    }

    private double calculateTotalPurchase(List<Integer> servicesIds){
        double total = 0;
        List<Service> servicesOnCart = getServicesById(servicesIds);
        for (Service service : servicesOnCart) {
            total += service.getPrice();
        }
        return total;
    }

    private List<Service> getServicesById(List<Integer> servicesIds){
        List<Service> servicesOnShoppingCart = new ArrayList<Service>();
        for (int id : servicesIds) {
            Service response = restTemplate.getForObject("http://tourismservices-service/tourism-services/{id}", Service.class, id);
            servicesOnShoppingCart.add(response);
        }
        return servicesOnShoppingCart;
    }
}
