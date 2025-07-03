package com.huynqb.coffee.repository;

import com.huynqb.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
    // JpaRepository đã có sẵn các phương thức như save, findById, findAll, deleteById, v.v.
    // Có thể thêm các phương thức tùy chỉnh nếu cần thiết


}
