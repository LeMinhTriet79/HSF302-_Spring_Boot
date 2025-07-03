package com.huynqb.coffee.service;

import com.huynqb.coffee.entity.Category;
import com.huynqb.coffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired // field injection
    private CategoryRepo categoryRepo;

    // HÀM CRUD NHƯ TRUYỀN THỐNG
    // BÀI PE THÌ CHỈ CẦN:
    // HÀM SAVE(), ĐỂ MÌNH SAVE DATA LÚC KHỞI ĐẦU
    // HÀM GETALL(), ĐỂ MÌNH CUNG CẤP CHO DROP-DOWN

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void saveCategory(Category category) {
        // nếu có id thì update, không có thì insert
        categoryRepo.save(category);
    }
}
