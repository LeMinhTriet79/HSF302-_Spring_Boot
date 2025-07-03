package com.giaolang.bookmanager.config;

import com.giaolang.bookmanager.entity.Book;
import com.giaolang.bookmanager.entity.BookStatus;
import com.giaolang.bookmanager.entity.Category;
import com.giaolang.bookmanager.entity.UserAccount;
import com.giaolang.bookmanager.repository.AccountRepo;
import com.giaolang.bookmanager.repository.BookRepo;
import com.giaolang.bookmanager.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//class này tự chạy khi run app, vậy nó phải đc new, new tự động -> bean
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepo accountRepo; //tự động new ngầm 1 class Repo có sẵn các method CRUD đc khai báo trong interface chuẩn

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BookRepo bookRepo;
    //DI THEO STYLE DÙNG FIELD INJECTION

    @Override
    public void run(String... args) throws Exception {
        //ta gọi Service hoặc Repo để chèn sẵn data
        //app chạy thằng này xong, có data, và ta gõ url localhost:/ hoac localhost:/login để vào màn hình login, gõ account đc chèn sẵn từ hàm này

        //CHÈN DATA VÀO TABLE ACCOUNT
        accountRepo.save(new UserAccount("ad@bs.com", "a1", 1));
        accountRepo.save(new UserAccount("st@bs.com", "s1", 2));
        accountRepo.save(new UserAccount("mb@bs.com", "m1", 3));
        //phải gõ data new theo đề thi

        Category cat1 = new Category("Soft Skills", "Sách kĩ năng mềm");
        Category cat2 = new Category("IT", "Sách CNTT");
        Category cat3 = new Category("History", "Sách lịch sử");

        categoryRepo.save(cat1);  //add Book từ cate, chèn Cha là Con tự xuống, học rồi
        categoryRepo.save(cat2);
        categoryRepo.save(cat3);

        //CHÈN BOOK, NHỚ CÓ CATE
        bookRepo.save(new Book("Quẳng gánh lo đi kì nào cx mở môn", "Author 1", 50, cat1));
        bookRepo.save(new Book("Đời ngắn đừng ngủ dài", "Author 2", 50.5, cat1));

        bookRepo.save(new Book("Spring Boot for dummies", "Author 3", 60, cat2));
        bookRepo.save(new Book("SQL Server in action", "Author 4", 70, cat2));
        bookRepo.save(new Book("Việt Nam sử lược", "Trần Trọng Kim", 80, cat3));


    }
}
