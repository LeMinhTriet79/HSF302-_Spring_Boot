package com.giaolang.bookmanager.repository;

import com.giaolang.bookmanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
