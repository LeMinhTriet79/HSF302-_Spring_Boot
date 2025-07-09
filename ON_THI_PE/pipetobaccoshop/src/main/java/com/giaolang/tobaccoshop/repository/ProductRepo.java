// ProductRepo.java
package com.giaolang.tobaccoshop.repository;
import com.giaolang.tobaccoshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByActiveTrue();

}