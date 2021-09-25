package com.microsystem.ShoppingService.Controllers;

import com.microsystem.ShoppingService.Model.Purchase;
import com.microsystem.ShoppingService.Model.ShoppingCart;
import com.microsystem.ShoppingService.Repository.IShoopingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(
    value = "shopping-cart"
)
public class ShoppingController {

    @Autowired
    private IShoopingRepository shoopingRepository; 

    @Autowired
    private PurchaseController purchaseController;

    @RequestMapping(
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart newShoppingCart){
        return this.shoopingRepository.save(newShoppingCart);
    }

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public ShoppingCart getShoppingCartById(@PathVariable int id){
        return this.shoopingRepository.findById(id).get();
    }

    @RequestMapping(
        value = "/{id}/services",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart addToShoppingCart(@PathVariable int id, @RequestBody int idServiceToAdd){
        ShoppingCart shoppingCartToUpdate = this.shoopingRepository.findById(id).get();
        shoppingCartToUpdate.getServicesIds().add(idServiceToAdd);
        return this.shoopingRepository.save(shoppingCartToUpdate);
    }

    @RequestMapping(
        value="/{id}/services",
        method=RequestMethod.DELETE,
        consumes = "application/json"
    )
    public void deleteFromShoppingCart(@PathVariable int id,@RequestBody int serviceIdToEliminate) {
        ShoppingCart shoppingCartToUpdate = this.shoopingRepository.findById(id).get();
        shoppingCartToUpdate.getServicesIds().remove(serviceIdToEliminate);
        this.shoopingRepository.save(shoppingCartToUpdate);
    }

    @RequestMapping(
        value = "/{id}/payment",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public Purchase makePayment(@PathVariable int id, @RequestBody String paymentMethod){
        ShoppingCart shoppingCart = this.shoopingRepository.findById(id).get();
        return purchaseController.createPurchase(shoppingCart, paymentMethod);
    }

    
}
