package sum25.se181979.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sum25.se181979.pojo.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByEmail(String email);
}
