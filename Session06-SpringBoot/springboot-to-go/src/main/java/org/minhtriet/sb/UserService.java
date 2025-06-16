package org.minhtriet.sb;

public class UserService {
    //mock - làm giả các hàm để test xem chúng gọi nhau ko
    //các hàm CRUD, tên hàm đặt rất gần table
    //nếu mà sài JPA/Hibernate như đã học - xài thuần nhưng chưa dùng Spring data
    //thì phải tự viết JPQL (SQL style oop) - chỉ chơi với object
    //Select s from Student s;
    // Nếu xài Spring Data(Spring JPA - cho table, Spring MongoDB -> cho NoSQL)
    //đúng chuẩn phải nhận vào 1 @Entity...., đang làm mock, in gủa bộ kq
    public void save(){
        System.out.println("Spring Data/Spring JPA has been called to generate JQL...");
    }

    //getAll(), findByID(), update() remove() findByName()
}
