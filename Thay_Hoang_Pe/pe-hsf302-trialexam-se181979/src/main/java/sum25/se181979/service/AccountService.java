package sum25.se181979.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se181979.pojo.Account;
import sum25.se181979.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public Account authenticate(String email, String password) {

        //Có nên where luôn bên repo email và pass hay ko?
        Account acc = accountRepo.findByEmail(email);

        if (acc == null) {
            return null; //TODO: return DTO đặc biệt mang ý nghĩa 1 email ko tồn tại, ném ngoại lệ X nào đó đại diện email ko tồn tại
        }

        if (!acc.getPassword().equals(password)) { //TODO: decode password
            return null; //TODO: return DTO đb mang ý nghĩa sai pass, ngoại lệ Y
        }

        //if thêm acc.getActive() == false...

        //chặn luôn role 3 - tay member bon chen vào login CẤM!!!
        if (acc.getRole() == 3) {
            return null; //TODO: 1 DTO hoặc ngoại lệ Z
        }

        return acc; //MLEM, account với role = 1, 2 ĐƯỢC TRẢ VỀ
    }

    //DÀNH CHO CODE FIRST, VÀ DATA INITIALIZER, KO CẦN LÀM MÀN HÌNH TẠO MỚI ACCOUNT
    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

}
