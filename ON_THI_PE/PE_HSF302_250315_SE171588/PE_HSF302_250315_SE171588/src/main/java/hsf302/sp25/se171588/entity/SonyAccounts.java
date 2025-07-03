package hsf302.sp25.se171588.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SonyAccounts")
public class SonyAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private AccountStatus status;
    private int role;

    public SonyAccounts(String password, AccountStatus status, String phone, String email, String fullName, int role) {
        this.password=password;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.role = role;;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

//    public void setAccountID(int accountID) {
//        this.accountID = accountID;
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public SonyAccounts() {
    }
    public enum AccountStatus{
        ACTIVE,INACTIVE;
    }
    @Override
    public String toString() {
        return "SonyAccounts{" +
                "accountID=" + accountID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", Phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", role=" + role +
                '}';
    }
}
