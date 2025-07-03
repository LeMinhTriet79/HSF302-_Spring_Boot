package hsf302.sp25.se171588.service;

import hsf302.sp25.se171588.entity.SonyProduct;
import hsf302.sp25.se171588.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<SonyProduct> getAllProducts() {
        return productRepository.findAll();
    }
    public List<SonyProduct> getProductsByName(String name) {
        return productRepository.getSonyProductByProductNameContaining(name);
    }
}
