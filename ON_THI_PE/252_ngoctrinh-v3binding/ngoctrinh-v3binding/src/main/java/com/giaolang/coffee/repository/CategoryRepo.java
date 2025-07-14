package com.giaolang.coffee.repository;

import com.giaolang.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {


}
