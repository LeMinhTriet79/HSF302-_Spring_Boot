package hsf302.sp25.se171588.repository;

import hsf302.sp25.se171588.entity.SonyCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<SonyCategories, Integer> {
}
