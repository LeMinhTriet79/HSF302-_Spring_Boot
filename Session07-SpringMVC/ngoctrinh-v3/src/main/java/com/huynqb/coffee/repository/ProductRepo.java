package com.huynqb.coffee.repository;

import com.huynqb.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
    //mặc định Jpa sẽ cung cấp cho bạn rất nhiều hàm, tự nó code luôn, chỉ cần đặt tên hàm theo 1 quy tắc
    //dính đến teedn field, là sẽ có hàm luôn


}
