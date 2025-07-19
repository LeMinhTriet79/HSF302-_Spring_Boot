package sum25.se181979.pehsf302trialexamse181979.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "SonyAccounts")
public class SonyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    @Column(length = 13, nullable = false)
    private String phone;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer roleID;

    // Getter, Setter, Constructor mặc định

    public SonyAccount() {
    }

    public SonyAccount(String phone, String password, Integer roleID) {
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
}
