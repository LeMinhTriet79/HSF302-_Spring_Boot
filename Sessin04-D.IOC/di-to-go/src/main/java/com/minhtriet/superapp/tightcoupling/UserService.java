package com.minhtriet.superapp.tightcoupling;

import java.lang.classfile.attribute.ModuleMainClassAttribute;

public class UserService {

    //Nhiệm vụ liên quan đến User Enity class, thông tin người dùng của app
    //bao gồm : thêm user, xóa(xóa mềm - set trạng thái bằng false/true, không làm lệnh xóa thật)
    //                    sửa, tìm kiếm,...
    //                    Crud sẽ nhờ thằng Repo nó lo

    // Tuy nhiên phần thêm user add() còn cần thêm 1 việc;
    //gửi mail hoặc gửi tin nhắn đến hộp mail/sim của user!!
    //không dính đến table user!!!!!

    //Gửi mail, gửi sms ko dính đến UserRepo
    //Mà là những xử lí khác, vào hộp mail, tạo mail,send, vào tổng đài, send sms số phone đăng kí...
    //Hàm gửi Mail, hàm gửi sms để ở đâu?
    //Có trong 5 nguyên lý nang cao của oop: s.o.l.i.d
    //S và O
    //S (srp): single resposibility principle: đơn trách nhiệm trong việc thiết kế, 1 class chỉ nên tập trung vào việc nó mạnh nhất, 1 CLASS KHÔNG ÔM ĐỒM CÓ CÔNG VIỆC CỦA NHIỀU LÃNH VỰC KHÁC NHAU
    //1 CLASS NẾU CẦN THAY ĐỔI, CHỈ NÊN CÓ 1 LÚ DO - CHỈ NÊN THAY ĐỔI Ở 1 THỨ NÀO ĐÓ
    //                         KO CÓ NHIỀU CHỖ/NHIỀU CƠ HỘI ĐỂ CÓ THỂ THAY ĐỔI

    //TÁCH GỬI MAIL VÀ SMS RA 2 CLASS RIÊNG BIỆT, MỖI THẰNG HÃY GIỎI CÔNG VIỆC CỦA RIÊNG CHÍNH MÌNH - NGUYÊN LÝ SRP/ĐƠN TRÁCH NHIỆM

    //GUI gọi đến ----controller gọi đến----service gọi đến ----repo(crud thật) gọi đến ---infra(em,emf) ---- table thật

    //Cần khai báo một object lo việc chuyên gởi mail
    //class service phụ thuộc vào class MailSender trong vụ gửi mail
    //Class MailSender  gọi là dependency của class UserService
    //class A cần class B làm giúp việc mà B giỏi (SRP), thì B gọi là Dependency của A
    //làm sao sài B trong A:
    //Khai báo B trong A, B objB
    //2. new B()          B objB = new B();
    //ta đang full quyền control object B, object dependency

    private MailSender mailSender; // mailSender là depedency của UserService; chủ động new để có object mà dùng, gọi là TIGHT COUPLING, DIRECT CONTROL nghĩa là UserService phụ thuộc chặt chẽ vào MailSender, chủ động tạo object (direct control) - ngược lại IoC - Inversion of Controll!!!
    public UserService() {
        this.mailSender = new MailSender(); // Initialize the mailSender in the constructor
    }

    // email của người đăng kí
    public void registerAccount(String email){
        // mình làm những việc, xử lí logic gì đó: kiểm tra email trùng trong table
        // chèn xuống table... qua UserRepository

        //việc quan trọng gửi mail
        System.out.println("Send email to in service: " + email + "");
        mailSender.senNoti();
    }

}
