package org.minhtriet.coffee.coffee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//là một bean, nhưng truyền, được new tự động, và vác hàm trong này dùng để map với một
//url khi user gõ trên trình duyệt
@RequestMapping("/api/coffees") //nếu user gọi localhost://api/coffees sữ đến class này phục vụ
public class CoffeeApiController {

    @GetMapping
    public String getMessage(){
        return "cà phê là thứ rất quan trọng cho lập trình viên" +
                "...Uống cà phê là pass môn";
    }

    @GetMapping("/acup")
    public Coffee getACup(){
        return new Coffee("JC", "Cà phê", 500000);
    }
}
