package hsf302.sp25.se171588.repository;

import hsf302.sp25.se171588.entity.SonyAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<SonyAccounts, Integer> {
    SonyAccounts getUserByRole(int role);
    SonyAccounts getUserByEmailContainingAndPhoneContaining(String email, String phone);
    SonyAccounts getUserByEmail(String email);
}
