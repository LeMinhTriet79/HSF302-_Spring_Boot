package org.minhtriet.sb;

//Muốn class này sẽ tự chạy khi Spring Boot bắt đầu tại container, bắt đầu new các Bean
//Tự chạy mang ý nghĩa nó tạo Table, chèn data Insert vào table để có sẵn data
//ví dụ app bắt đầu chạy trong tomcat, thì có sẵn account admin trong table!
//danh mục tỉnh thành phải có trước, ta làm code fist

//run 1 lần thôi
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//@Order để chỉ xem runner nào chạy trước
public class DataInitializer implements CommandLineRunner {

    //HÀM NÀY ĐC SPRINGBOOT TỰ GỌI 1 LẦN DUY NHẤT!!! KHI NEW BEAN - DEPENDENCY
    @Override
    public void run(String... args) throws Exception {
        //đÚNG CHUẨN LÀ GỌI sERVICE, SERVICE GỌI REPO, REPO GỌI JPA
        //SPRING DATA -> SPRING JPA -> JPA -> HIBERNATE
        System.out.println("create TABLE AND INSERT INTO ... SUCCESSFULY");
    }
}
