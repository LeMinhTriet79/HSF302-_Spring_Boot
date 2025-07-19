package com.leminhtriet.coffe.config;

import com.leminhtriet.coffe.entity.Category;
import com.leminhtriet.coffe.entity.Product;
import com.leminhtriet.coffe.repository.ProductRepository;
import com.leminhtriet.coffe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//TỰ CHẠY MỘT LẦN DUY NHẤT KHI TOMCAT ĐƯỢC CHẠY
//DÙNG ĐỂ TẠO SẴN DATA TRONG TABLE, SẴN DATA, COPY DATA TỪ ĐỀ THI VÀO ĐÂY
@Component
public class DataInitializer implements CommandLineRunner {

    // nhờ vả 2 service giúp xuống tạo table, chèn sẵn data
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
    //TẠO OBJECT NHỜ SERVICE ĐẨY XUỐNG
        // TẠO TABLE 1 TRƯỚC, N SAU (DO KHÓA NGOẠI THAM CHIẾU KHÓA CHÍNH)
        Category cat1 = new Category("Trà Sữa","Uống trà sữa");
        Category cat2 = new Category("Cà Phê","Uống CÀ PHÊ JAVA");
        Category cat3 = new Category("BEER-TĂNG LỰC","Uống bia trộn Java sốc code Java");
        Category cat4 = new Category("Bánh Kẹo","Đời ngọt ngào lào xào tiếng gió");

        //TẠO DỮ LIỆU CHO TABLE PRODUCT, PRODUCT PHẢI THUỘC VỀ MỘT CATE NÀO ĐÓ

        Product p1c1 = new Product("TS01", "Trà sữa hàng xóm nấu", 79, 25_000);
        Product p2c1 = new Product("TS02", "Trà sữa Thầy Hòàng nấu", 79, 35_000);
        cat1.addProduct(p1c1);
        cat1.addProduct(p2c1);

        Product p1c2 = new Product("CF01", "Cà phê nguyên bản vị Java", 79, 17_000);
        Product p2c2 = new Product("CF02", "Cà phê do nhà Thầy Hoàng bán", 79, 20_000);
        Product p3c2 = new Product("CF03", "Cà phê Ả Rập với bạch đậu khấu", 50, 29_000);

        cat2.addProduct(p1c2);
        cat2.addProduct(p2c2);
        cat2.addProduct(p3c2);
        //xuống table thôi

        categoryService.save(cat1);
        categoryService.save(cat2);
        categoryService.save(cat3);
        categoryService.save(cat4);





    }
}
