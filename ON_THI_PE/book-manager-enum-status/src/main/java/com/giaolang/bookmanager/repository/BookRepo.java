package com.giaolang.bookmanager.repository;

import com.giaolang.bookmanager.entity.Book;
import com.giaolang.bookmanager.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BookRepo extends JpaRepository<Book, Long> {

    //SPRING JPA TỰ ĐỘNG GENERATE RA CÁC HÀM CRUD TABLE BOOK, VÀ NHỮNG HÀM
    //SEARCH/QUERY HAY HO, LINH HOẠT MIỄN LÀ BẠN ĐẶT TÊN HÀM THEO QUY TẮC
    //MÀ NÓ CÓ THỂ SUY LUẬN ĐC
    //KEYWORD: "DERIVED METHOD, DERIVED QUERY IN SPRING JPA"
    //VÍ DỤ HÀM CÓ  TỪ findAllBy <phia sau sẽ nối với tên các cột, and or luôn, search gần đúng luôn. Mỗi cột ứng với 1 tham số đưa vào>!!!

    public List<Book> findAllByTitleContainingOrAuthorContaining(String keyword1, String keyword2);
    //ko cần viết code vì là interface, tự IoC Container và JPA implement giùm mình

    public List<Book> findAllByTitleContainingAndStatus(String keyword1, BookStatus keyword2);
}
