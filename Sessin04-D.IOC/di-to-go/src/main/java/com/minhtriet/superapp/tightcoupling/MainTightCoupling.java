package com.minhtriet.superapp.tightcoupling;

public class MainTightCoupling {
    //psvm
    public static void main(String[] args) {
        UserService userService = new UserService();
        //trong cái userService đã có sẵm object MailSender đc new rồi
        userService.registerAccount("<vantamvo@gmail.com>");

        //Câu hỏi : tui muốn dùng sms thì sao??? code thêm, nhng sửa code đến đâu, sửa nhiều class hay ít class
        //không nêu MailSender ngầm ngầm được hay không??
        //Vì đôi khi App ta, phần mail sender chỉ đang chơi google mail đ gửi
        // Giờ tui muốn dùng Yahoo, MS mail để gửi
    }
}
