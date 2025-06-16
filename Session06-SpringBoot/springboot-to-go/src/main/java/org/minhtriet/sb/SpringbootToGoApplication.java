package org.minhtriet.sb;

import org.minhtriet.sb.infra.ExcelGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//bao gồm @cònigulation
//bao gồm @ComponentScan
//Clas này là nơi khai bái các bean - các dependency được new, là những class có @Componen, @Service, @Repository, chính là AppConfig mình đã học
//Các dependency có thể new theo 2 cách: tự đppjng hoàn toàn
//chủ động new với @Bean
//nó giúp tự động cấu hình Web, tomcat, CSDL,...
public class SpringbootToGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootToGoApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(ExcelGenerator.class, args);
        ExcelGenerator excelGenerator  = (ExcelGenerator) ctx.getBean("excelGenerator");
        excelGenerator.generateFile("TUI_NO_KHONG_DAM_HUA.xlsx ");
    }
    @Bean ("excelGenerate")
    public ExcelGenerator excelGenerator(){
        return new ExcelGenerator();
    }
}


