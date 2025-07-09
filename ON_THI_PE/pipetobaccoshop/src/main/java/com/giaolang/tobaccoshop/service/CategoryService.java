package com.giaolang.tobaccoshop.service;

import com.giaolang.tobaccoshop.entity.Category;
import com.giaolang.tobaccoshop.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> cat = categoryRepo.findById(id);
        return cat.orElse(null);
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
