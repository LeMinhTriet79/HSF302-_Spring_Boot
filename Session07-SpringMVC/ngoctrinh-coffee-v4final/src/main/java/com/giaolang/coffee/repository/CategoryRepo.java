package com.giaolang.coffee.repository;

import com.giaolang.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//chính thức vào thê giới Spring Data > Spring JPA/Hibernate
public interface CategoryRepo extends JpaRepository<Category, Long> {
    //JpaRepository interface này cần 2 thông số:
    //Tên entity class, tương lai là table nào
    //Cột key có kiểu data type nào đó
    //nhờ 2 thông số này, Jpa/Hibernate phía hậu trường nó tự generate ra các hàm CRUD table Category
    //và hơn thế nữa: nó tự generate ra 1 loạt các hàm ứng với 1 loạt các câu SQL hay dùng trên 1 table
    //về cơ bản, bạn hầu như ko cần viết thêm các hàm để CRUD table
    //ứng với các where riêng của bạn, Spring JPA lo đc luôn các hàm này
    //-> để tận dụng cơ chế tự sinh hàm, bạn cần viết tên hàm theo chuẩn Spring JPA quy ước trước, tự Spring lo nốt câu JPQL/SQL cho bạn
    //-> kĩ thuật tự sinh hàm và câu query chỉ từ cách đặt tên hàm theo chuẩn thì gọi là: DERIVED QUERY METHODS, QUERY METHODS
    //KEYWORD: "QUERY METHODS IN SPRING DATA JPA"

    public List<Category> findCategoriesByNameContainingIgnoreCase(String name);  //where Name like '%ng%'

    //NHƯNG BẠN VẪN CÓ THỂ ĐỘ CÂU QUEYRY RIÊNG (JPQL, SQL NATIVE) ĐC LUÔN
}
