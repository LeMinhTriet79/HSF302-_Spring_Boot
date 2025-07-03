package com.huynqb.coffee.config;

import com.huynqb.coffee.entity.Category;
import com.huynqb.coffee.entity.Product;
import com.huynqb.coffee.service.CategoryService;
import com.huynqb.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataInitializer implements CommandLineRunner {

    //CHÍCH TIÊM
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        //TẠO DATA TỰ ĐỘNG, CÓ SẴN KHI LOCALHOST:.... BẮT ĐẦU RUN
        Category cate1 = new Category("Cà Phê Ả Rập", "Hương Vị Dịu Nhẹ Của Bạch Đậu Khấu");
        Category cate2 = new Category("Trà xanh", "Uống dô tươi tỉnh sản khoái");
        Category cate3 = new Category("Bánh kẹo", "Ăn nhiều quá sâu răng");
        Category cate4 = new Category("Bia Saigon", "say xỉn li bì");

        categoryService.saveCategory(cate1);
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate3);
        categoryService.saveCategory(cate4);

        //Chuẩn bị product
        // CHUẨN BỊ PRODUCT
        Product p1 = new Product("P001", "Trà sữa trân châu", 100, 30000);
        Product p2 = new Product("P002", "Trà sữa matcha", 150, 35000);
        Product p3 = new Product("P003", "Trà trái cây dưa hấu", 200, 40000);
        Product p4 = new Product("P004", "Trà thảo mộc gừng", 250, 45000);

        Product p5 = new Product("P005", "Cà phê Arabic", 250, 18000);

        cate2.addProduct(p1);
        cate2.addProduct(p2);
        cate2.addProduct(p3);
        cate2.addProduct(p4);
        cate1.addProduct(p5);


        // Lưu lại sau khi add Product (để cascade update)
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate1);
    }
}
