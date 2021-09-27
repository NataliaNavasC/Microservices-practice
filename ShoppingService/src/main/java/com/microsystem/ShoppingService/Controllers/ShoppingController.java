package com.microsystem.ShoppingService.Controllers;

import com.microsystem.Request.PaymentRequest;
import com.microsystem.Request.ShoppingCartRequest;
import com.microsystem.ShoppingService.Model.Purchase;
import com.microsystem.ShoppingService.Model.ShoppingCart;
import com.microsystem.ShoppingService.Repository.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
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
    private IShoppingRepository shoppingRepository; 

    @Autowired
    private PurchaseController purchaseController;

    @Autowired
    Environment environment;

    @RequestMapping(
        value = "/status",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getStatus(){
        String port = environment.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @RequestMapping(
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart newShoppingCart){
        return this.shoppingRepository.save(newShoppingCart);
    }

    @RequestMapping(
        value = "/{username}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public ShoppingCart getShoppingCartByUsername(@PathVariable String username){
        return this.shoppingRepository.findShoppingCartByUserName(username);
    }

    @RequestMapping(
        value = "/{id}/services",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart addToShoppingCart(@PathVariable int id, @RequestBody ShoppingCartRequest idServiceToAdd){
        ShoppingCart shoppingCartToUpdate = this.shoppingRepository.findById(id).get();
        shoppingCartToUpdate.getServicesIds().add(idServiceToAdd.getShoppingCartId());
        return this.shoppingRepository.save(shoppingCartToUpdate);
    }

    @RequestMapping(
        value="/{id}/services",
        method=RequestMethod.DELETE,
        consumes = "application/json"
    )
    public void deleteFromShoppingCart(@PathVariable int id,@RequestBody ShoppingCartRequest serviceIdToEliminate) {
        ShoppingCart shoppingCartToUpdate = this.shoppingRepository.findById(id).get();
        shoppingCartToUpdate.getServicesIds().remove((Object)serviceIdToEliminate.getShoppingCartId());
        this.shoppingRepository.save(shoppingCartToUpdate);
    }

    @RequestMapping(
        value = "/{id}/payment",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public Purchase makePayment(@PathVariable int id, @RequestBody PaymentRequest paymentMethod){
        ShoppingCart shoppingCart = this.shoppingRepository.findById(id).get();
        //this.shoppingRepository.delete(shoppingCart);
        Purchase purchase =  purchaseController.createPurchase(shoppingCart, paymentMethod.getPaymentMethod());
        shoppingCart.getServicesIds().clear();
        this.shoppingRepository.save(shoppingCart);
        return purchase;
    }

    
}
