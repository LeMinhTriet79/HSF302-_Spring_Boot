package com.huynqb.coffee.repository;

import com.huynqb.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {

}
