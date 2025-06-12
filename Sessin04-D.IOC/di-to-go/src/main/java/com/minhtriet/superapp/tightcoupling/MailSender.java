package com.minhtriet.superapp.tightcoupling;

public class MailSender {
    //CLASS CHUYN PHỤ TRÁCH VIỆC GỬI MAIL, PRO TRONG CÔNG VIỆC CỦA MÌNH
    //GIUSP CHIA VIỆC ĐỘC LẬP - GOM CHUNG TRONG UserService, quá trải cho class đí và bạn dev phụ trách

    //pseudo code - code giả lập thôi
    public  void senNoti(){
        //Logic- xử lí gửi mail ở đây: khai báo thông số mail/pass, server, format email,...
        System.out.println( "Mail sent successfully");
    }

}
