package com.giaolang.tobaccoshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String image; // Link hình ảnh thuốc lá tẩu
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}