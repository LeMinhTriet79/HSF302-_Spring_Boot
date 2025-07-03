package com.giaolang.coffee.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id; //key tự tăng phải là Long wrapper (long)

    @Column(name = "Name",columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;         //id và name dành cho drop-down, combo-box xổ xuống!!!

    @Column(name = "Description",columnDefinition = "NVARCHAR(100)")
    private String description; //gây nhiễu

    //MAPPING MỐI QUAN HỆ 1 - N
    //1 CATE ---< CÓ NHIỀU PRODUCT - List<Product>
    @OneToMany(mappedBy = "cate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    //các hàm để bổ sung sản phẩm vào cate, hay cho sản phẩm ra khỏi cate
    //list product của cate này ban đầu là rỗng, từ từ vào / ra
    public void addProduct(Product o) {
        productList.add(o); //o bạn vào danh sách của cate tớ
        //vế ngược lại, bạn o cx phải flex rằng đã ghé tớ, thuộc về đội tớ
        o.setCate(this);
    }

    public void removeProduct(Product o) {
        productList.remove(o);
        o.setCate(null);
    }

    public Category() {
    }

    //key tự tăng phải loại thằng key ra khỏi constructor
    public Category(String name, String description) {
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
