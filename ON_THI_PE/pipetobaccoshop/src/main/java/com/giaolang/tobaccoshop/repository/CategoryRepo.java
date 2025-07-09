// CategoryRepo.java
package com.giaolang.tobaccoshop.repository;
import com.giaolang.tobaccoshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepo extends JpaRepository<Category, Long> {}