package com.minhtriet.superapp.di.v3finalfantasy;

public interface NotiService {
    //interface là những class cha, những câu lạc bộ chỉ chứa hàm ko code(sau này có hàm có code) là hàm abstract. CLB chỉ nói về luật chơi của CLB
    //anh em tham gia CLB (các class implement) thì thực thi luật chơi
    //CLB đua xe, nhiệm vụ của anh em là implement mọi hình thức đua

    public void sendNoti(); //ko có code
    //Để thằng SMS lo code theo kiểu gửi tin nhắn
    //để thằng Email lo code theo kiểu gửi EMail
    //thằng class nào lo vụ viết code cho hàm này , gọi là imlement, concrete class

    //interface sinh ra để thống nhất cách đặt tên hàm cho 1 nhóm class
    //chỉ cần gọi tnee 1 làm, anh em thường hưởng ứng --> tính đa hình PolyMorphism
    //rảnh ko biết làm gì thì đọc cuốn sách Design Patterns của Gof gang of Four

}
