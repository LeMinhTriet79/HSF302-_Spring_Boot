package com.giaolang.bookstore.service;

import com.giaolang.bookstore.entity.Book;
import com.giaolang.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    //phục vụ cho việc show toàn bộ sách trong trang books.html
    public List<Book> getAllBooks() {

        //return bookRepo.findAll(); //hàm tự sinh
        return bookRepo.getAllByOrderByCreatedAtDesc();
    }

    //phuc vụ cho nút save Book khi tạo mới, và edit
    //xài chung hàm: JPA nó check id nếu là mới thì là insert
    //                                      cũ thì là update
    public void saveBook(Book o) {

        bookRepo.save(o); //hàm tự sinh
    }

    //edit 1 Book, ta phải get đc Book này và đẩy sang model của book-form
    public Book getBookById(Long id) {

        return bookRepo.findById(id).get();
    }                     //hàm tự sinh

    //link xoá Book
    public void deleteBookt(Book o) {
        bookRepo.delete(o); //hàm tự sinh
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id); //hàm tự sinh
    }

    //search...
    public List<Book> searchBooksByNameOrAuthor(String keyword) {

        return bookRepo.searchAllByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCase(keyword, keyword);
    }

    //HÀM KHÁC... KIỂM TRA SỰ TỒN TẠI CỦA 1 ROW BOOK THEO ID
    //            THAY VÌ TÌM 1 DÒNG, TRẢ RA NULL HAY DÒNG TÌM THẤY
    public boolean existsBook(Long id) {
        return bookRepo.existsById(id);
    }                   //hàm tự sinh của JPA Repo

}
