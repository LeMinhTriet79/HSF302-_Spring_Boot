package com.huynqb.coffee.service;


import com.huynqb.coffee.repository.ProductRepo;
import com.huynqb.coffee.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class ProductService {
    //Gui/ controller ----service ---- repo ---Jpa/hibernate ---- jdbc ---- Table
    //Class này lo giao tiếp với Gui để cung cấp infor cho GUI
    // Nó cần nhờ repo trợ giúp

   // @Autowired //Field injection
    private ProductRepo repo;

    //  @Autowired  ko cần, vì class  có một contructor và tự tiêm vào đúng
    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    //Các Hàm Crud table
    public List<Product> findAll() {
        return repo.findAll();// class/interface Repo chưa có dòng code nào
                            //Hàm tự sinh trong repo
    }

    //dành cho link/edit
    public Product getProductById(String id) {
        return repo.findById(id).get();
    }

    //dành cho link post save sản phẩm khi mới và khi edit
    //key mới thì là insert, còn key cũ/key đang có là UPDATE
    public  void saveProduct(Product product) {
        repo.save(product);
    }

    public void deleteProductById(String id) {
        repo.deleteById(id);
    }

}
