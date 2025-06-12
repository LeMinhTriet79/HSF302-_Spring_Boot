package com.minhtriet.superapp.di.v2setter;


public class MainSetter {
    public static void main(String[] args) {
       UserService userService = new UserService();
       userService.setMailSender(new MailSender()); // chích qua hàm set() giống .setYob(năm sinh khác);
       userService.registerAccount("hoangngoctrinhIdolAHIHI@gmail.com");
    }
}
