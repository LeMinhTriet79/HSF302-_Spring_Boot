package com.huynqb.coffee.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "Nvarchar(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "Nvarchar(100)")
    private String description;

    //Mối quan hệ với Product..... 1 - N
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cate")
//    private List<Product> productList = new ArrayList<>();

    // MỐI QUAN HỆ VỚI PRODUCT..., 1 - N

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

    //Chjo một sản phẩn nào đó thuộc về category này
    public void addProduct(Product o) {
        productList.add(o);
        //Chính trong object o cũng phải lưu phải lưu thêm: tôi product đã lưu đố anh
        o.setCategory(this);
    }

    public void removeProduct(Product o) {
        productList.remove(o);
        o.setCategory(null);
    }


    public Category( String name, String description) {

        this.name = name;
        this.description = description;
    }
    public Category() {}

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
