package com.minhtriet.spring.ioc.v3beanduplication;

public class HelloMessage {
    private String mediumType;

    //  SMS, EMAIL
    public HelloMessage(String mediumType) {
        this.mediumType = mediumType;
    }

        public void sayHello(String msg) {
            System.out.println("Sent from\n" + mediumType);
            System.out.println("V3: The message below comes HelloMessage object\n" + msg);
        }

}
