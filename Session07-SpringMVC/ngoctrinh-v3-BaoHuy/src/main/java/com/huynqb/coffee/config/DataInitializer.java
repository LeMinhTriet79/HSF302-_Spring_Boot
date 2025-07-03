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
    //                               more action implement run

    // CHÍCH TIÊM SERVICE VÀO
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        // TẠO DATA TỰ ĐỘNG, CÓ SẴN KHI LOCALHOST:8080 BẮT ĐẦU
        Category cate1 = new Category("Trà sữa", "Uống vào thì pass java");
        Category cate2 = new Category("Cà Phê", "Uống vào thì pass java");
        Category cate3 = new Category("Beer-nước ngọt", "Beer trộn java thì gọi là gì");
        Category cate4 = new Category("Bánh Kẹo", "Vị ngọt pass môn");


        categoryService.saveCategory(cate1);
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate3);
        categoryService.saveCategory(cate4);


        Product p1c2 = new Product("TS01", "Cà phê vị nguyên bản", 312, 5_700_000);
        Product p2c2 = new Product("CF02", "Cà phê vị thơm ngon", 12, 10_700_000);
        Product p3c3 = new Product("TS01", "Cà phê vị gì đó ", 312, 6_000_000);

        cate1.addProduct(p1c2);
        cate2.addProduct(p2c2);
        cate3.addProduct(p3c3);

    }




}
