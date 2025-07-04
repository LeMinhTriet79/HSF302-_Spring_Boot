package com.huynqb.coffee.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category") // tên bảng trong CSDL
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(100)")
    private String description;

    // MỐI QUAN HỆ VỚI PRODUCT..., 1 - N
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cate")
    private List<Product> productList = new ArrayList<>();

    // CHO 1 SẢN PHẨM NÀO ĐÓ THUỘC VỀ CATEGORY NÀY
    public void addProduct(Product o) {
        productList.add(o);
        // chính trong object o cũng phải lưu thêm: tôi product đã lưu số anh cate nào
        o.setCate(this);
    }

    public void removeProduct(Product o) {
        productList.remove(o);
        // tôi product đã không còn thuộc về cate nào
        o.setCate(null);
    }

    public Category() {
    }

    public Category(String name, String description) {
        // this.id = id; key tu tang, khong can dung
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
