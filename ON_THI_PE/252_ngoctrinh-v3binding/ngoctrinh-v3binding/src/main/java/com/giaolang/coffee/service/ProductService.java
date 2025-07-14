package com.giaolang.coffee.service;

import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

//@Component
@Service
public class ProductService {
    //GUI/CONTROLLER --- SERVICE --- REPO --- JPA/HIBERNATE --- JDBC --- TABLE
    //class này lo giao tiếp với GUI để cung cấp info cho GUI
    //nó cần nh Repo trợ giúp

    //@Autowired                //FIELD INJECTION
    private ProductRepo repo;

    //@Autowire ko cần vì class có 1 ctor và tự tiêm vào đúng!!!
    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    //CÁC HÀM CRUD TABLE
    public List<Product> getAllProducts() {
        return repo.findAll(); //class/interface Repo chưa có dòng code nào
                               //hàm tự sinh trong repo
    }

    //dành cho link /edit
    public Product getProductById(String id) {
        return repo.findById(id).get();
    }

    //dành cho link post save sản phẩm khi tạo mới và khi edit
    public void saveProduct(Product product) {
        repo.save(product);
    }  //key mới -> là insert
       //key đang có -> là update

    public void deleteProductById(String id) {
        repo.deleteById(id);
    }

}
