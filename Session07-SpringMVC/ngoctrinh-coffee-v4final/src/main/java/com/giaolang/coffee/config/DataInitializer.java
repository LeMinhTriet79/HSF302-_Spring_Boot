package com.giaolang.coffee.config;

import com.giaolang.coffee.entity.Account;
import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.service.AccountService;
import com.giaolang.coffee.service.CategoryService;
import com.giaolang.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//TỰ CHẠY 1 LẦN DUY NHẤT KHI KHI TOMCAT ĐC CHẠY, LÀ IOC CONTAINER NÓ CHẠY, DÙNG ĐỂ TẠO TABLE, TẠO SẴN DATA TRONG TABLE
//BÀI PE CHO SẴN TÊN TABLE, SẴN DATA, COPY DATA TỪ ĐỀ THI VÀO ĐÂY!!!
@Component  //mày phải là bean mới đc gọi
public class DataInitializer implements CommandLineRunner {

    //nhờ vả 3 service giúp tạo table, chèn sẵn data
    @Autowired
    private CategoryService cateService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        //TẠO OBJECT, NHỜ SERVICE ĐẨY XUỐNG
        //TẠO TABLE 1 TRƯỚC, N SAU (DO KHOÁ NGOẠI THAM CHIẾU KHOÁ CHÍNH)

        // Thêm tài khoản mẫu vào DB
        accountService.saveAccount(new Account("admin", "123"));
        accountService.saveAccount(new Account("user", "123"));

        Category cat1 = new Category("Trà sữa", "Uống trà sữa, hoài nghi pass môn này");
        Category cat2 = new Category("Cà phê", "Uống Cà phê Java top server 100");
        Category cat3 = new Category("Beer-tăng lực", "Uống bia trộn Java thì shock code thăng hoa");
        Category cat4 = new Category("Bánh kẹo", "Đời ngọt ngào mướt mượt như Ngọc Trinh");

        //xuống table hoy khi tomcat chạy
        cateService.saveCategory(cat1);
        cateService.saveCategory(cat2);
        cateService.saveCategory(cat3);
        cateService.saveCategory(cat4);


        // Tạo các sản phẩm mẫu, chú ý truyền id (String)
        Product p1 = new Product("P001", "Trà Sữa Trân Châu", 50, 32000);
        p1.setCate(cat1);

        Product p2 = new Product("P002", "Trà Sữa Matcha", 40, 34000);
        p2.setCate(cat1);

        Product p3 = new Product("P003", "Cà phê sữa đá", 100, 25000);
        p3.setCate(cat2);

        Product p4 = new Product("P004", "Cà phê đen", 60, 20000);
        p4.setCate(cat2);

        Product p5 = new Product("P005", "Bia Heineken", 80, 33000);
        p5.setCate(cat3);

        Product p6 = new Product("P006", "Red Bull", 100, 17000);
        p6.setCate(cat3);

        Product p7 = new Product("P007", "Bánh Snack", 120, 15000);
        p7.setCate(cat4);

        Product p8 = new Product("P008", "Kẹo Sôcôla", 200, 12000);
        p8.setCate(cat4);

        // Lưu Product vào DB
        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);
        productService.saveProduct(p4);
        productService.saveProduct(p5);
        productService.saveProduct(p6);
        productService.saveProduct(p7);
        productService.saveProduct(p8);
    }
}
