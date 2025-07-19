package sum25.se181979.pehsf302trialexamse181979.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyCategory;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyCategoryRepository;

import java.util.List;

@Service
public class SonyCategoryService {
    @Autowired
    private SonyCategoryRepository cateRepo;

    public List<SonyCategory> getAll() {
        return cateRepo.findAll();
    }

    public SonyCategory getById(Integer cateId) {
        return cateRepo.findById(cateId).orElse(null);
    }
}
