package com.huynqb.coffee.service;

import com.huynqb.coffee.entity.Product;
import com.huynqb.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component
@Service
public class ProductService {
    // GUI/CONTROLLER --- SERVICE --- REPO --- JPA/HIBERNATE --- JDBC --- TABLE
    // class này lo giao tiếp với GUI để cung cấp info cho GUI
    // nó cần nhờ Repo trợ giúp

    // @Autowired // FIELD INJECTION
    private ProductRepo repo;

    // Constructor Injection (@Autowire không cần vì class có 1 constructor và tự tiêm vào đúnh)
    public ProductService (ProductRepo repo) {
        this.repo = repo;
    }

    // CÁC HÀM CRUD TABLE
    public List<Product> getAllProducts() {
        // gọi repo để lấy danh sách sản phẩm
        return repo.findAll(); // class/interface Repo chưa có dòng code nào
                               // hàm tự sinh trong repo
    }

    // Dành cho link/edit
    public Product getProductById(String id) {
        return repo.findById(id).get();
    }

    // Dành cho link post save sản phẩm khi tạo mới và khi edit
    public void saveProduct(Product product) {
        // gọi repo để lưu sản phẩm
        repo.save(product); // nếu có id thì update, không có thì insert
    }

    public void deleteProductById(String id) {
        // gọi repo để xóa sản phẩm
        repo.deleteById(id); // nếu có id thì xóa, không có thì báo lỗi
    }
}
