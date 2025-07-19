package com.leminhtriet.coffe.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "Id", columnDefinition = "char(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "Nvarchar(50)", nullable = false)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    //Mapping mối quan hệ giữa Category ---< Product
    //1 product bất kì đều thuộc về 1 cate

    @ManyToOne
    @JoinColumn(name = "CateId")//Góc nhìn DB:cột Fk trỏ sang table Cate
    private Category cate; //góc nhìn OOP: biến này link sang Cate nào

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
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
}
