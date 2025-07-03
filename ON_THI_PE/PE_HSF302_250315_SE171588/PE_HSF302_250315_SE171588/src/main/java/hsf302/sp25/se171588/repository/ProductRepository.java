package hsf302.sp25.se171588.repository;

import hsf302.sp25.se171588.entity.SonyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<SonyProduct, Integer> {
    List<SonyProduct> getSonyProductByProductNameContaining(String productName);
}
