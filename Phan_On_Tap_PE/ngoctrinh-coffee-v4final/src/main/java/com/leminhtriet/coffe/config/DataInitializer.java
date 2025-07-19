package com.leminhtriet.coffe.config;

import com.leminhtriet.coffe.entity.Category;
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

        //xuống table thôi

        categoryService.save(cat1);
        categoryService.save(cat2);
        categoryService.save(cat3);
        categoryService.save(cat4);

        

    }
}
