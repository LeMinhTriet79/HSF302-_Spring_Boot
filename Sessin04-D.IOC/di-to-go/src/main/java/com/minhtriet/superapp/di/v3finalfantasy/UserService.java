package com.minhtriet.superapp.di.v3finalfantasy;

public class UserService {
    // thay vì phụ thuộc vào thằng cụ thể , ta phụ thuộc vào thứ chung chung giúp ta dễ dàng chơi đa dạng muốn mà không cần sửa code phụ thuộc interface, là ứng với nguyên lí
    //O: open to extension, close to modification
    //    cứ thêm sms thoải mái mà không cần sửa UserSevice
//    private SmsSender smsSender;
//    private EmailSender emailSender;
    //kiểu này gọi là tight coupling
    //mai mốt mà thêm fireBase, đè class Service sửa thêm

    private NotiService notiService; // bạn muốn Sms, email, firebase....thoải mái không sửa code nữa

    //đưa bên ngoài vào, DI qua contructor
    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }

    //Xài thoi
    public void registerUser(){
        notiService.sendNoti();
        //đa hình, hoặc sms, hoặc email, hoặc firebase!!!
        //Gọi 1 chạy ra nhiều hướng đa hình dạng
    }
}
