package sum25.se181979.pehsf302trialexamse181979.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyProduct;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyProductRepository;

import java.util.List;

@Service
public class SonyProductService {
    @Autowired
    private SonyProductRepository productRepo;

    public List<SonyProduct> getAll() {
        return productRepo.findAll();
    }

    public SonyProduct getById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public SonyProduct save(SonyProduct product) {
        return productRepo.save(product);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<SonyProduct> getTop3ByCategory(Integer cateId) {
        return productRepo.findTop3ByCategory_CateIDOrderByStockDesc(cateId);
    }
}
