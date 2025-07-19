package com.leminhtriet.coffe.repository;

import com.leminhtriet.coffe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
    //không cần viết các hàm crud table product vì ta cần derived query
}
