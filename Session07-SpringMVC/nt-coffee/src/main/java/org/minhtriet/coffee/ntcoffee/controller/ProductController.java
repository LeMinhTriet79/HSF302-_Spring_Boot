package org.minhtriet.coffee.ntcoffee.controller;

import jakarta.servlet.http.HttpSession;
import org.minhtriet.coffee.ntcoffee.entity.Account;
import org.minhtriet.coffee.ntcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    //Cứ một hàm là một thùng

    @PostMapping("/products/save")
    public String saveProduct(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") double price, RedirectAttributes redirectAttributes ) {
        //map truyền thống, 1 fiel dưới form map thành 1 biến ở trên hàm post trong controller, tốn kém, code dài, tốn kém, code dài ở tham số hàm.

        //Save thành công đi đâu?
        //quay lại trang chính, liệt kê các danh sách sản phẩm đã có thêm thứ vừa edit/create
        List<Product> productList = List.of(new Product("1", "Coffee Indonesia", 20000),
                new Product("2", "Cà phê Ả Rập", 15000),
                new Product("3", "Coffee Latte", 18000)

        );
        // model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
        // model.addAttribute("sentUser", session.getAttribute("sentUser"));
        //có session lo giữ acc rồi
        Account acc = (Account) session.getAttribute("acc");
        model.addAttribute("role", acc.getRole());

        // return "products";
        // url giữ nguyên, resubmision của F5
        //model rỗng
        redirectAttributes.addAttribute("message", "Đã cập nhật thành công");
        return "redirect:/products";


    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("p", new Product());
        return "product-form";
    }


    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        //có trong tay id số mấy rồi thì vào database query lên, ta tạm thời hardcode
        Product product;
        if(id.equalsIgnoreCase("1")){
            product = new  Product("1", "Coffee Indonesia", 20000);
        } else if (id.equalsIgnoreCase("2")) {
            product =  new Product("2", "Cà phê Ả Rập", 15000);
        }else {
            product = new Product("3", "Coffee Latte", 18000);
        }
        model.addAttribute("p", product);
        return "product-form";
    }

    @GetMapping("/textabc"")
    public String list(Model model, HttpSession session) {
        List<Product> productList = List.of(new Product("1", "Coffee Indonesia", 20000),
                new Product("2", "Cà phê Ả Rập", 15000),
                new Product("3", "Coffee Latte", 18000)

        );
       // model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
       // model.addAttribute("sentUser", session.getAttribute("sentUser"));
        //có session lo giữ acc rồi
        Account acc = (Account) session.getAttribute("acc");
        model.addAttribute("role", acc.getRole());


        //gửi danh sách sản phẩm + role sang trang!!!
        // Có role thì bật tắt nút bấm
        return "products";
    }
}
