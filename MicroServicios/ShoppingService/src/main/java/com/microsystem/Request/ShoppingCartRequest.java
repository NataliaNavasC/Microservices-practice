package com.microsystem.Request;


/**
 * ShoppingCartRequest
 */
public class ShoppingCartRequest {
    private int shoppingCartId;
    
    public ShoppingCartRequest() {}

    public ShoppingCartRequest(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
    
}