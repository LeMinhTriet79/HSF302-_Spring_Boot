package com.leminhtriet.coffe.service;

import com.leminhtriet.coffe.entity.Product;
import com.leminhtriet.coffe.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //gui/controller - service --repo -- spring jpa/hiber ---jdbc drivr --table
    //class trung tâm bài thi pe
    //crud table product
    //tiêm repo vào

    @Autowired
    private ProductRepository productRepository;

    //phục vụ cho việc show toàn bộ sản phẩm trong trang products.html
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    //phục vụ cho nút save sản phẩm khi tạo mới, và edit
    //xài chung hàm : jpa nó check id nu mới là insert cũ thì là update

    public void save(Product o){
        productRepository.save(o);
    }

    public void delete(Product o){
        productRepository.delete(o);
    }
    //search
}
