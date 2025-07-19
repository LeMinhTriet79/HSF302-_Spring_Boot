package com.leminhtriet.coffe.repository;

import com.leminhtriet.coffe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepositoty extends JpaRepository<Category,Long> {
    //JapaRepo interface này cần 2 thông số:
    //Tên entity class, tương lai là table nào
    //Cột key có kiểu data type nào đó
    //nhờ 2 thông số này thằng Jpa/hibernate phía hậu trường
    //nó tự generate ra các hàm Crud table category
    //và hơn thế nữa: nó tự generate ra hàng loạt các hàm ứng với 1 loạt các
    //câu SQL hay dùng trên 1 table
    //về cơ bản, bạn hầu như không cần viết thêm các hàm để crud table
    //ứng với các where riêng của bạn, Spring JPA lo được luôn các hàm này
    //-> để tận dụng cơ hệ tự sinh hàm, bạn cần viết tên hàm theo chuẩn Spring JPA quy chuẩn trước
    //tự Srping lo hết câu JPQL/jpa

    //....

    public List<Category> findCategoriesByNameContainingIgnoreCase(String name);
    //Nhưng bạn có thể độ câu Query Riêng
}
