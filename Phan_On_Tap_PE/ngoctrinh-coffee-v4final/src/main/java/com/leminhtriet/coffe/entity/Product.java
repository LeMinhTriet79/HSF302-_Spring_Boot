package com.leminhtriet.coffe.entity;

public class Product {

    private String id;

    private String name;

    private int quantity;

    private double price;

    public Product() {}

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
