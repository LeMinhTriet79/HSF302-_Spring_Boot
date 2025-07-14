package com.giaolang.coffee.repository;

import com.giaolang.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,String> {

    //mặc định JPA sẽ cung cấp cho bạn rất nhiều hàm, tự nó code luôn cho bạn
    //bạn chỉ cần đặt tên hàm theo 1 quy tắc, dính đến tên field, là sẽ có hàm luôn

    // SPRING JPA CUNG CẤP 2 LOẠI HÀM MÀ BẠN KHÔNG CẦN PHẢI CODE
    //1 HÀM CÓ SẴN CỨ VIỆC DÙNG NGAY BÊN SERVICE, KHÔNG CẦN KHAI BÁO TÊN HÀM Ở ĐÂY
    //BUID - IN - METHOD - SAVE(), findAll(),...

    //2. Hàm tự sinh ra theo cách bạn gõ tên hàm theo cú pháp
    //derived query method
    //Bạn cần gõ tên hàm bạn muốn tạo ở đây, không cần viết code
    public List<Product> searchAllByNameContainingIgnoreCase(String keyword);
    //tự sinh cái hàm select * from product where name like %keyword%
}
