package com.kevin;

import com.kevin.Product;

public class OrderItem extends Product {
    int qty; //數量

    public OrderItem(Product product, int qty) {
        this.qty = qty;
        id = product.id;
        name = product.name;
        price = product.price;
        category = product.category;
    }


    public OrderItem(Product product) {
        id = product.id;
        name = product.name;
        price = product.price;
        category = product.category;

    }
}
