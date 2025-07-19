package com.leminhtriet.coffe.service;

import com.leminhtriet.coffe.entity.Category;
import com.leminhtriet.coffe.repository.CategoryRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    //Gui/ controller --- service ---repo --spring jpa/hibernat ---Jdbc diriver --table
    //server lo crud table trong RAM
    //...
    //có qua cách tiêm repo
    @Autowired // có 1 đống hàm tự sinh cho crud cate
    private CategoryRepositoty categoryRepositoty;

    //tiêm qua contructer, ko cần Autowire, nếu class chỉ có 1 cst này!! tiêm ngay lúc new, chỉ có 1 đường new
    public CategoryService(CategoryRepositoty categoryRepositoty) {
        this.categoryRepositoty = categoryRepositoty;
    }

    //crud truyền thống, gọi hàm derived query mehods tự sinh ra của thằng REpo đc tiêm vào tự động
    public void save(Category o){
        categoryRepositoty.save(o);
    }
    //hàm xóa sửa, search: bài PE ko có yêu cầu thêm xóa sửa Category
    //MÀ YÊU CẦU LÀM: THÊM XÓA SỬA SEARCH SẢN PHẨM

    //CATE CHỈ ĐÓNG VAI TRÒ TREO ĐẦU DÊ BÁN THỊT HEO COMBO-BOX CHO LÚC TẠO MỚI,
    //EDIT SẢN PHẨM, SẢN PHẨM THUỘC NHÓM CATE NÀO, SV THUỘC MAJOR NÀO!!

    public List<Category> getAll(){
        return categoryRepositoty.findAll();//hàm tự sinh
        //dùng cho combobox treo đầu dê bán thịt heo
    }

}
