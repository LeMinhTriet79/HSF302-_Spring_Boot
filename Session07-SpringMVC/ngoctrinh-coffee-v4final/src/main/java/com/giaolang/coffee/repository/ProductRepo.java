package com.giaolang.coffee.repository;

import com.giaolang.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
    //ko cần viết hàm crud table Product vì ta xài derived query methods
}
