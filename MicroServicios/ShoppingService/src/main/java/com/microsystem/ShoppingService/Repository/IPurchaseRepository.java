package com.microsystem.ShoppingService.Repository;

import com.microsystem.ShoppingService.Model.Purchase;

import org.springframework.data.repository.CrudRepository;

public interface IPurchaseRepository extends CrudRepository<Purchase, Integer> {
    
}
