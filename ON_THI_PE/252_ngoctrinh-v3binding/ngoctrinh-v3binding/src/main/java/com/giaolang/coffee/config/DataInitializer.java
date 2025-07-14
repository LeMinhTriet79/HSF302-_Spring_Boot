package com.giaolang.coffee.config;

import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.repository.CategoryRepo;
import com.giaolang.coffee.service.CategoryService;
import com.giaolang.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    //CHÍCH TIÊM SERVICE VÀO
    @Autowired
    //CategoryRepo categoryRepo;
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        //TẠO DATA TỰ ĐỘNG, CÓ SẴN KHI LOCALHOST:6969 BẮT ĐẦU RUN
        //1. TẠO SẴN VÀI CATE
        Category cate1 = new Category("Trà sữa", "Uống vào ko pass Java");
        Category cate2 = new Category("Cà phê", "Uống vào là uống Java, xanh rờn!!!");
        Category cate3 = new Category("Beer-nước ngọt", "Beer trộn Java thì gọi là gì?");
        Category cate4 = new Category("Bánh kẹo", "Vị ngọt pass môn");

        //CHUẨN BỊ PRODUCT
        Product p1c1 = new Product("TS01", "Trà sữa hàng xóm nấu", 100, 25_000);
        Product p2c1 = new Product("TS02", "Trà sữa Ngọc Trinh", 100, 30_000);

        Product p1c2 = new Product("CF01", "Cà phê Java vị nguyên bản", 100, 5_700_000);

        Product p2c2 = new Product("CF02", "Cà phê Java vị Ngọc Trinh", 100, 2_350_000);

        Product p3c2 = new Product("CF03", "Cà và phê Ngọc Trinh", 100, 2_350_000);

        cate1.addProduct(p1c1);  //Trà sữa có 2 món
        cate1.addProduct(p2c1);  //add vào list cate Trà sữa

        cate2.addProduct(p1c2);  //Cate Cà phê có 3 món, add vào
        cate2.addProduct(p2c2);
        cate2.addProduct(p3c2);


        categoryService.saveCategory(cate1);
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate3);
        categoryService.saveCategory(cate4);
    }
}
