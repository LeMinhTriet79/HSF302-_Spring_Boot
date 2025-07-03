package com.giaolang.coffee.service;

import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //gui-controller -- service --- repo --- spring jpa/hibernate --- jdbc driver --- table
    //CLASS TRUNG TÂM BÀI THI PE
    //CRUD TABLE PRODUCT
    //TIÊM REPO VÀO XÀI HÀM tự sinh

    @Autowired
    private ProductRepo productRepo;

    //phục vụ cho việc show toàn bộ sản phẩm trong trang products.html
    public List<Product> getAllProducts() {
        return productRepo.findAll(); //hàm tự sinh
    }

    //phuc vụ cho nút save sản phẩm khi tạo mới, và edit
    //xài chung hàm: JPA nó check id nếu là mới thì là insert
    //                                      cũ thì là update
    public void saveProduct(Product o) {
        productRepo.save(o); //hàm tự sinh
    }

    //link xoá sản phẩm
    public void deleteProduct(Product o) {
        productRepo.delete(o); //hàm tự sinh
    }

    //search...


    //HÀM KHÁC...
}
