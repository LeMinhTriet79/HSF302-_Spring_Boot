package org.minhtriet.sb.infra;

//@Component new tự động bởi spring, bởi ioc container
//cmt lại thì phải new qua @Bean ở chỗ @Configuration nhưng nay là @SpringBootApplication
public class ExcelGenerator {
    //SRP - Single Responsibility Principle - S trong SOLID
    //class chuyên làm một món mà nó giỏi - tính đơn trách nhiệm
    public void generateFile(String fileName){
        //TODO: logic generate file

        System.out.println("The " + fileName + " file has been generated");

        //Phải viết code gọi bean sau lệnh trên, lệnh trên khơởi tạo container
    }
    //đặt các @Bean chủ động


}
