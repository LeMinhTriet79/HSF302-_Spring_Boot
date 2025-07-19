package sum25.se181979.pehsf302trialexamse181979.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyAccount;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyCategory;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyProduct;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyAccountRepository;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyCategoryRepository;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyProductRepository;



import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private SonyAccountRepository accountRepo;
    @Autowired
    private SonyCategoryRepository categoryRepo;
    @Autowired
    private SonyProductRepository productRepo;

    @Override
    public void run(String... args) throws Exception {
        // Chỉ thêm dữ liệu nếu các bảng đang trống
        if (accountRepo.count() == 0 && categoryRepo.count() == 0 && productRepo.count() == 0) {
            // Thêm Accounts
            accountRepo.save(new SonyAccount("0905111111", "@1", 1));
            accountRepo.save(new SonyAccount("0905222222", "@1", 2));
            accountRepo.save(new SonyAccount("0905333333", "@1", 3));

            // Thêm Categories
            SonyCategory c1 = categoryRepo.save(new SonyCategory("HeadPhone", "active"));
            SonyCategory c2 = categoryRepo.save(new SonyCategory("Cameras", "active"));
            SonyCategory c3 = categoryRepo.save(new SonyCategory("TVs", "active"));

            // Thêm Products
            productRepo.save(new SonyProduct(
                    "Alpha 1 II - Full-frame Mirrorless", 6000, 3,
                    LocalDate.parse("2025-03-03").atStartOfDay(), c2));
            productRepo.save(new SonyProduct(
                    "Alpha 7C II – Full-frame", 2000, 5,
                    LocalDate.parse("2025-04-04").atStartOfDay(), c2));
            productRepo.save(new SonyProduct(
                    "BRAVIA 8 OLED 4K HDR TV", 2500, 10,
                    LocalDate.parse("2025-01-01").atStartOfDay(), c3));
            productRepo.save(new SonyProduct(
                    "LinkBuds Fit Truly Wireless Noise Canceling", 180, 15,
                    LocalDate.parse("2025-03-03").atStartOfDay(), c1));
        }
    }
}