package com.giaolang.coffee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Name is requiredd - tên sản phẩm không được bỏ trống")//Khác với not null, vì nó
    //ép nhập ký tự có nghĩa

    @Size(min = 5, max = 100, message = "Tên phải dài từ 5 đến 100 ký tự")
    @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Mỗi từ phải bắt đầu hoa, chỉ chứa chữ (Unicode), không số/ký tự đặc biệt, không khoảng trắng thừa"
    )
    private String name;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    @Min(value = 5, message = "quantity is in the range of 5...100")
    @Max(value = 100, message = "quantity is in the range of 5...100")
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    //RELATIONSHIP MANY TO ONE - NHIỀU SẢN PHẨM CÓ THỂ THUỘC 1 CATEGORY
    //                           1 CATEGORY CÓ THỂ CÓ NHIỀU SẢN PHẨM
    @ManyToOne
    @JoinColumn(name = "CateId")  //cột khoá ngoại, phần DB
    private Category cate;        //phần OOP

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
