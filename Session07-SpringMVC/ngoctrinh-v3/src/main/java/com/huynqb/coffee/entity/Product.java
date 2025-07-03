package com.huynqb.coffee.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name", columnDefinition = "Nvarchar(50)", nullable = false)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    //Relationship many to one - Nhiều sản phẩm có thể thuộc 1 loại category
    //                          1 Category cí thể có nhiều sản phẩm

    @ManyToOne
    @JoinColumn(name = "category") //cột khóa ngoại, phần DB
                                //Phần OOP
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {}

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
