package com.giaolang.bookmanager.repository;

import com.giaolang.bookmanager.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<UserAccount, String> {
    //coi nhu có săn các hàm CRUD table UserAccount và các hàm độ!!! mà ko cần code nhiều
    //giả sử table UserAccount có cột id, fullName, email, password, phone
    //bên Service hay nơi nào dùng AccountRepo, nơi đó phải khai báo biến
    //AccountRepo repo;  //thằng repo là object đc IoC new, inject
    //repo tự đc sinh ra 1 đống hàm, hàm này viết theo 1 quy tắc là coi như
    //Spring JPA tự đẻ ra hàm tương ứng
    //ví dụ có hàm
    //findByFullName(String name)  findByFullNameAndPhone() findByFullNameOrPhone()




}
