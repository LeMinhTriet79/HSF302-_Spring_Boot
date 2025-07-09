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
        return productRepo.findByActiveTrue();
    }

    public Product findById(Long id) {
        Product p = productRepo.findById(id).orElse(null);
        if (p != null && !p.isActive()) return null;
        return p;
    }

    public void save(Product product) {
        productRepo.save(product);
    }

    // "Xóa mềm": chỉ đổi active = false
    public void deleteById(Long id) {
        Product p = findById(id);
        if (p != null) {
            p.setActive(false);
            productRepo.save(p);
        }
    }


    // Thêm hàm tìm kiếm theo tên (phục vụ chức năng tìm kiếm sản phẩm)
    public List<Product> searchByName(String keyword) {
        return productRepo.findByNameContainingIgnoreCase(keyword);
    }
}
