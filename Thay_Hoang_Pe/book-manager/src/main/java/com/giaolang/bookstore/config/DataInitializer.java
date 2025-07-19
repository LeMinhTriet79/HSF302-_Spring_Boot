package com.giaolang.bookstore.config;

import com.giaolang.bookstore.entity.Account;
import com.giaolang.bookstore.entity.Book;
import com.giaolang.bookstore.entity.Category;
import com.giaolang.bookstore.service.AccountService;
import com.giaolang.bookstore.service.BookService;
import com.giaolang.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryService cateService;

    @Override
    public void run(String... args) throws Exception {

        accountService.saveAccount(new Account("ad@az.com", "ad", 1));
        accountService.saveAccount(new Account("st@az.com", "st", 2));
        accountService.saveAccount(new Account("mb@az.com", "mb", 3));

        //TẠO OBJECT, NHỜ SERVICE ĐẨY XUỐNG
        //TẠO TABLE 1 TRƯỚC, N SAU (DO KHOÁ NGOẠI THAM CHIẾU KHOÁ CHÍNH)
        Category cate1 = new Category("Đam mĩ", "...");
        Category cate2 = new Category("Kĩ năng sống", "...");
        Category cate3 = new Category("Tuổi hồng", "...");

        //ta tạo dữ liệu book, mỗi book thì phải thuộc về cate nào đó
        cate1.addBook(new Book("Tashiro, Cậu Đúng Thật Là!", "Yamada", 10, 98_000));
        cate1.addBook(new Book("Tình Ta Đơm Hoa Giữa Hạ", "Kotaro", 10, 76_000));

        cate2.addBook(new Book("Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 10, 95_000));
        cate2.addBook(new Book("Mình Là Nắng Việc Của Mình Là Chói Chang", "Kazuko Watanable", 10, 76_000));

        cate3.addBook(new Book("Tôi Thương Mà Em Đâu Có Hay", "Đoàn Thạch Biền", 10, 50_000));

        //xuống table hoy khi tomcat chạy, CASCADE ALL
        //NGHĨA LÀ TABLE 1 ĐI XUỐNG THÌ TABLE N XUỐNG LUÔN!!! VÀ LIST SÁCH BỊ DOMINO XUỐNG THEO LUÔN
        cateService.saveCategory(cate1);
        cateService.saveCategory(cate2);
        cateService.saveCategory(cate3);
    }
}
