package com.microsystem.ShoppingService.Controllers;

import com.microsystem.ShoppingService.Model.ShoppingCart;
import com.microsystem.ShoppingService.Repository.IShoopingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {
    @Autowired
    private Environment environment;

    @Autowired
    private IShoopingRepository shoopingRepository;

    @RequestMapping(
        value = "purchase/{id_user}",
        method = RequestMethod.POST
    )
    public void createPurchase(@PathVariable int id_user){
        
    }

    @RequestMapping(
        value = "shopping-cart",
        method = RequestMethod.POST,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart newShoppingCart){
        return this.shoopingRepository.save(newShoppingCart);
    }

    @RequestMapping(
        value = "shopping-cart",
        method = RequestMethod.GET
    )
    public ShoppingCart getShoppingCart(){
        return this.shoopingRepository.findById(1).get();
    }

    @RequestMapping(
        value = "shopping-cart",
        method = RequestMethod.PUT,
        consumes = "application/json",
        produces = "application/json"
    )
    public ShoppingCart updateShoppingCart(@RequestBody ShoppingCart shoppingCartUpdated){
        ShoppingCart shoppingCartToUpdate = this.shoopingRepository.findById(shoppingCartUpdated.getId()).get();
        shoppingCartToUpdate.setPaymentMethod(shoppingCartUpdated.getPaymentMethod());
        shoppingCartToUpdate.setServices(shoppingCartUpdated.getServices());
        shoppingCartToUpdate.setTotal(shoppingCartUpdated.getTotal());
        return this.shoopingRepository.save(shoppingCartToUpdate);
    }
}
