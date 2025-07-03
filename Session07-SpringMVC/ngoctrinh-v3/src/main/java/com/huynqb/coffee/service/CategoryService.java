package com.huynqb.coffee.service;

import com.huynqb.coffee.entity.Category;
import com.huynqb.coffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

     @Autowired
      private CategoryRepo categoryRepo;
     // Hàm Crud như truyền thống
    //Bài PE thì chỉ cần:
    //Hàm save(), để mình save data lúc khởi đầu
    //Hàm GetAll(), để mình cung cấp cho Drop-down

//    public List<Category> getAllCategories() {
//        return categoryRepo.findAll();
//    }
//
//    public void saveCategory(Category category) {
//        categoryRepo.save(category);
//    }
//
//    public void deleteProductById(Category category) {
//        categoryRepo.delete(category);
//    }

    // Lấy tất cả category cho drop-down
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    // Lưu category (dùng khi khởi tạo data hoặc thêm mới)
    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    // Xóa category theo entity
    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }

    // Xóa category theo ID (thường dùng hơn)
    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }





}
