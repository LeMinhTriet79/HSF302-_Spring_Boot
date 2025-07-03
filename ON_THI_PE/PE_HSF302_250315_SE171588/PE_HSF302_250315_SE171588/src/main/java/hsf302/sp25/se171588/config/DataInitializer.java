package hsf302.sp25.se171588.config;

import hsf302.sp25.se171588.entity.SonyAccounts;
import hsf302.sp25.se171588.entity.SonyCategories;
import hsf302.sp25.se171588.entity.SonyProduct;
import hsf302.sp25.se171588.repository.AccountsRepository;
import hsf302.sp25.se171588.repository.CategoriesRepository;
import hsf302.sp25.se171588.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.sql.Date;

import static hsf302.sp25.se171588.entity.SonyAccounts.AccountStatus.ACTIVE;
import static hsf302.sp25.se171588.entity.SonyAccounts.AccountStatus.INACTIVE;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        accountsRepository.save(new SonyAccounts("1234", ACTIVE,"0905111111","admin@sony.com","Admin",1));
        accountsRepository.save(new SonyAccounts("1234",INACTIVE,"0905111112","admin1@sony.com","Admin",1));
        accountsRepository.save(new SonyAccounts("1234",ACTIVE,"0905222222","staff@sony.com","Staff",2));
        accountsRepository.save(new SonyAccounts("1234",ACTIVE,"0905333333","manager@sony.com","Manager",3));
        accountsRepository.save(new SonyAccounts("1234",ACTIVE,"0905444444","customer@sony.com","Customer",4));
        accountsRepository.save(new SonyAccounts("1234",INACTIVE,"0902444444","customer1@sony.com","Customer1",4));

        SonyCategories categories1=new SonyCategories("HeadPhone","/headphon","active");
        categoriesRepository.save(categories1);

        SonyCategories categories2=new SonyCategories("Cameras","/cameras","active");

        categoriesRepository.save(categories2);

        SonyCategories categories3=new SonyCategories("TVs","/tivi","active");

        categoriesRepository.save(categories3);
        productRepository.save(new SonyProduct("Alpha 1 II - Full-frame Mirrorless",6000,3, Date.valueOf("2025-03-03") ,Date.valueOf("2025-03-03"),categories2));

        productRepository.save(new SonyProduct("Alpha 7C II – Full-frame",2000,5,Date.valueOf("2025-03-03") ,Date.valueOf("2025-03-03"),categories2));

        productRepository.save(new SonyProduct("BRAVIA 8 OLED 4K HDR TV",2500,10,Date.valueOf("2025-03-03") ,Date.valueOf("2025-03-03"),categories3));

        productRepository.save(new SonyProduct("LinkBuds Fit Truly Wireless Noise Canceling",180,15,Date.valueOf("2025-03-03") ,Date.valueOf("2025-03-03"),categories1));
    }
}
