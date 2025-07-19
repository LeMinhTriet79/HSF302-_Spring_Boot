package sum25.se181979.pehsf302trialexamse181979.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyAccount;
import sum25.se181979.pehsf302trialexamse181979.repository.SonyAccountRepository;

@Service
public class SonyAccountService {
    @Autowired
    private SonyAccountRepository accountRepo;

    // Hàm dùng để login
    public SonyAccount login(String phone, String password) {
        return accountRepo.findByPhoneAndPassword(phone, password);
    }
}
