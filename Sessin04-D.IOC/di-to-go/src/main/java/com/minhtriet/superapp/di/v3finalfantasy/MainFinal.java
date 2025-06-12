package com.minhtriet.superapp.di.v3finalfantasy;



public class MainFinal {
    public static void main(String[] args) {
        //DI, IoC, POLYMORPHISM, SO CỦA SOLID
        NotiService smsSender = new SmsSender();
        NotiService emailSender = new EmailSender();

        //Muốn sài thằng nào thì chích vào thằng đó
        UserService userService = new UserService(emailSender);
        userService.registerUser();//đa hình ngầm bên trong hàm gửi noti

        //SMS qua mobi
        // C1: TẠO CLASS RỜI CỤ THỂ MOBISMS implement NotiService{...}
        //c2: ANONYMOUS CLASS
        //Class take away

        NotiService mobi = new NotiService() {
            @Override
            public void sendNoti() {
                System.out.println("(Mobi PHONE) mail was sent successfully");
            }
        }; // VIP
        UserService userService2 = new UserService(mobi);
        userService2.registerUser(); //
    }
}
