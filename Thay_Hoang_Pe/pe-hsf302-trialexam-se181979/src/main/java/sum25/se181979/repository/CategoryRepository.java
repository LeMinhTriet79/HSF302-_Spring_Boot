package sum25.se181979.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sum25.se181979.pojo.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
