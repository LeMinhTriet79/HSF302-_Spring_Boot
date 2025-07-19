package sum25.se181979.pehsf302trialexamse181979.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyAccount;

public interface SonyAccountRepository extends JpaRepository<SonyAccount, Integer> {
    SonyAccount findByPhoneAndPassword(String phone, String password); // phải là "findBy..."
}
