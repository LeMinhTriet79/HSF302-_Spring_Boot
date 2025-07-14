package com.giaolang.coffee.service;

import com.giaolang.coffee.entity.Category;
import com.giaolang.coffee.repository.CategoryRepo;
import com.giaolang.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired  //field injection
    private CategoryRepo categoryRepo;

    //HÀM CRUD NHƯ TRUYỀN THỐNG
    //BÀI PE THÌ CHỈ CẦN:
    // HÀM SAVE(), ĐỂ MÌNH SAVE DATA LÚC KHỞI ĐẦU
    // HÀM GETALL(), ĐỂ MÌNH CUNG CẤP CHO DROP-DOWN

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }
}
