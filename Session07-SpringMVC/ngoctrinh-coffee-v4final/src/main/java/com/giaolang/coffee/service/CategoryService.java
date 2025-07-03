package com.giaolang.coffee.service;

import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class CategoryService {

    //GUI/CONTROLLER --- SERVICE --- REPO --- SPRING JPA/HIBERNATE --- JDBC DRIVER - - TABLE
    //SERVICE LO CRUD TABLE TRONG RAM,
    // LO LOGIC XỬ LÍ VỚI ENTITY/DTO, VÍ DỤ TÍNH VOUCHER, KHUYẾN MÃI, GỌI CỔNG THANH TOÁN, GỬI MAIL NOTI...
    //NẾU LO VIỆC CRUD TABLE THÌ PHẢI NHỜ VÀ REPO
    //BẢN CHẤT LÀ PHẢI KHAI BÁO REPO, NEW REPO(), GỌI HÀM REPO.
    //NHƯNG REPO HIỆN NAY ĐANG LÀ INTERFACE, VÀ LÀ BEAN, CHO NÊN TA SẼ NHỜ
    //IOC CONTAINER CHÍCH TIÊM VÀO SERVICE
    //VẬY SERVICE ĐC TIÊM REPO VÀO, VẬY SERVICE CX PHẢI LÀ BEAN
    //@Component, @Service, @Repository, @Controller, @RestController

    //tiêm repo, có 3 cách
    @Autowired  //có 1 đống hàm tự sinh cho CRUD Cate rồi nhen - xài hoy - query method trong biến cateRepo, chấm thoy, mặn mà luôn
    private CategoryRepo cateRepo;

    //tiêm qua constructor
    //ko cần @Autowire nếu class chỉ có 1 cst này!!! tiêm ngay lúc new, chỉ có 1 đường new
    public CategoryService(CategoryRepo cateRepo) {
        this.cateRepo = cateRepo;
    }

    //CRUD TRUYỀN THỐNG, GỌI HÀM DERIVED QUERY METHODS TỰ SINH CỦA THẰNG REPO ĐC TIÊM VÀO TỰ ĐỘNG ĐỘNG
    public void saveCategory(Category o) {
        cateRepo.save(o);  //hàm tự sinh
    }

    //hàm xoá, sửa, search: BÀI PE KO CÓ YÊU CẦU THÊM XOÁ SỬA CATEGORY
    //MÀ YÊU CẦU LÀM: THÊM XOÁ SỬA SEARCH SẢN PHẨM

    //CATE CHỈ ĐÓNG VAI TREO ĐẦU DÊ, BÁN THỊT HEO COMBO-BOX CHO LÚC TẠO MỚI, EDIT SẢN PHẨM, SẢN PHẨM THUỘC NHÓM CATE NÀO, SV THUỘC MAJOR NÀO!!!
    public List<Category> getAllCategories() {
        return cateRepo.findAll(); //hàm tự sinh, câu JPQL: SELECT c FROM CATEGORY c;  //ngầm sẽ là SELECT * FROM CATEGORY
    } //dùng cho combobox treo đầu dê...

    //CÁC HÀM KHÁC: SEND-NOTI(), VOUCHER()...
}
