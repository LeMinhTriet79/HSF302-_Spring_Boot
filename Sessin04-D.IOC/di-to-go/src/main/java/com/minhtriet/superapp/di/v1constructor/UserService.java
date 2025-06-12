package com.minhtriet.superapp.di.v1constructor;



public class UserService {

    //private MailSender mailSender = new MailSender(); // hard-coded dependency, code truyền thống, chủ động khai báo tạo obj dependency

    private MailSender mailSender;//ko new mà chờ đưa từ bên ngoài vào chích tiêm từ bên ngoài , new đâu đó đem vào đây

    //DI chính là kĩ thuật đưa một obj phụ thuộc ở bên ngoài đưa vào trong nơi cần nó, new B() đưa vào class A thông qua Contructor, A không tự new ngầm bên trong
    public UserService(MailSender mailSender) {
        this.mailSender = mailSender;
        //this.yob = yob;
    }

    //Có 3 cách chích/tiêm một object mà ta ko chủ động new
    //qua field = ???
    //qua setter()
    //dùng  framework chích tiêm vào

//    public UserService() {
//        this.mailSender = new MailSender(); // Initialize the mailSender in the constructor
//    }



    public void registerAccount(String email){
        // mình làm những việc, xử lí logic gì đó: kiểm tra email trùng trong table
        // chèn xuống table... qua UserRepository

        //việc quan trọng gửi mail
        System.out.println("Send email to in service: " + email + "");
        mailSender.senNoti();
    }

}
