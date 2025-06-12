package com.minhtriet.superapp.di.v2setter;

public class UserService {
    //trao quyền new dependency cho người khác gọi là: IoC
    //object dependency được đưa từ bên ngoài vào qua: Contructor, hàm set, sờ trực tiếp thì gọi là DI

    //REFLECTION
    private MailSender mailSender;

    //nhận obj từ contructor đã vừa học

    //nhận obj qua set(), giống set() yob
       // chích qua còn đường set() bị vấn đề null ko gọi hàm này
    //chích qua contructer luôn đảm bảo rằng có depedency được đưa vào
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }


    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void registerAccount(String email){
     //   mailSender = new MailSender(); //full quyền
        mailSender.senNoti();
    }
}
