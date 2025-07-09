package com.giaolang.tobaccoshop.service;

import com.giaolang.tobaccoshop.entity.Product;
import com.giaolang.tobaccoshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    // Thêm hàm tìm kiếm theo tên (phục vụ chức năng tìm kiếm sản phẩm)
    public List<Product> searchByName(String keyword) {
        return productRepo.findByNameContainingIgnoreCase(keyword);
    }
}
