package com.huynqb.coffee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product") // tên bảng trong CSDL
public class Product {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    // RELATIONSHIP MANY TO ONE - NHIỀU SẢN PHẨM THUỘC 1 CATEGORY
    //                            1 CATEGORY CÓ THỂ CÓ NHIỀU SẢN PHẨM
    @ManyToOne
    @JoinColumn(name = "CateId") // Tên cột trong bảng Product để lưu trữ khóa ngoại, phần DB
    private Category cate; // phần OOP

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public Product() {
    }

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
