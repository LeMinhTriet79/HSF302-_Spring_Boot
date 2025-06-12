package com.minhtriet.spring.noioc;

public class MainNoIoc {
    public static void main(String[] args) {
        //khoong chơi IOC, Inversion of controll, nghĩa là bạn phả tự lo tạo ra các Object Dependency trong code của bạn
        //ta muốn in câu chào, ta phải tự new object HelloMessage
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.sayHello("Hello no Ioc, We create object manually!");
        //Code truyền thống, tự new trong chỗ nào đó
    }
}
