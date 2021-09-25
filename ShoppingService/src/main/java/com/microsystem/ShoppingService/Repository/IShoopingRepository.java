package com.microsystem.ShoppingService.Repository;

import com.microsystem.ShoppingService.Model.ShoppingCart;

import org.springframework.data.repository.CrudRepository;

public interface IShoopingRepository extends CrudRepository<ShoppingCart, Integer> {
}
