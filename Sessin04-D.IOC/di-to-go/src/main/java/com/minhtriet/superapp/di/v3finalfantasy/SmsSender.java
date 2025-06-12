package com.minhtriet.superapp.di.v3finalfantasy;

public class SmsSender implements NotiService {
    @Override
    public void sendNoti() {
        System.out.println("(VIETTEL) sms was sent successfully");
    }
}
