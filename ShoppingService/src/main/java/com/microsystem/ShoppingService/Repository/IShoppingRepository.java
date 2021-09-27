package com.microsystem.ShoppingService.Repository;

import com.microsystem.ShoppingService.Model.ShoppingCart;

import org.springframework.data.repository.CrudRepository;

public interface IShoppingRepository extends CrudRepository<ShoppingCart, Integer> {

    public ShoppingCart findShoppingCartByUserName(String userName);
}
