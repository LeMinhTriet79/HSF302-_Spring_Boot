package sum25.se181979.pehsf302trialexamse181979.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyProduct;

import java.util.List;

public interface SonyProductRepository extends JpaRepository<SonyProduct, Long> {
    List<SonyProduct> findTop3ByCategory_CateIDOrderByStockDesc(Integer cateID);
}
