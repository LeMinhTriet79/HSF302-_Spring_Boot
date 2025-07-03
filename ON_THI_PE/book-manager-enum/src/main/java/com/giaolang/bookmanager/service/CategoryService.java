package com.giaolang.bookmanager.service;

//GUI/PAGE --- SERVICE --- REPO --- HIBERNATE --- TABLE
//VÌ REPO ĐC TỰ ĐỘNG TẠO RA VÀ IMPLEMENT BỞI THƯ VIỆN SPRING DATA/JPA -> DO CÁC HÀM CRUD TRÊN 1 TABLE QUÁ QUEN, QUÁ BOILER PLATE

import com.giaolang.bookmanager.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giaolang.bookmanager.entity.Category;
import java.util.*;

//NẾU TA DÙNG HIBERNATE THUẦN, THÌ TA PHẢI TỰ LÀM CÁC HÀM CRUD - ĐÃ TỪNG HỌC
//CHO NÊN CÁI OBJECT REPO SẼ ĐC IOC CONTAINER QUẢN LÍ VÀ CHÍCH VÀO SERVICE
//SERVICE PHẢI TRỞ THÀNH BEAN, IOC PHẢI QUẢN LÍ CẢ THẰNG SERVICE THÌ NO1 MỚI CHÍCH VÀO ĐC
//@Component
@Service
public class CategoryService {
    //nhờ Repo CRUD
    @Autowired  //chích qua đường field injection
    private CategoryRepo repo; //biến thuộc interface

    //ko cần create, update và delete Cate, vì mình chỉ cần select * from Category để sau này còn fill vào dropdown Cate ở màn hình tạo mới Book

    public List<Category> getAllCates() {
        return repo.findAll();
    }


}
