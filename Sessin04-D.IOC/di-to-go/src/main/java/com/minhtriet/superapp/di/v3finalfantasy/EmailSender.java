package com.minhtriet.superapp.di.v3finalfantasy;

public class EmailSender implements NotiService {
    @Override
    public void sendNoti() {
        System.out.println("(Gmail) mail was sent successfully");
    }
}
