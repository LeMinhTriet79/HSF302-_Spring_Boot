package com.minhtriet.spring.di;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //@Component
public class UserRepo {
    //class rất giỏi crud table Account/User, nờ JpaUtil....
    //mock/ làm giả hàm getAll()
//    public List <User> getAll(){
//        //...
//    }
    public void getAll(){
        //Code thật phải vào table lấu và trả về List<User>
        System.out.println("Here is the list of user");
    }
}
