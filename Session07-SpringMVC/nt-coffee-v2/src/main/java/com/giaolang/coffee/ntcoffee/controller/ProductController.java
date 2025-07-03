package com.giaolang.coffee.ntcoffee.controller;

import com.giaolang.coffee.ntcoffee.entity.Account;
import com.giaolang.coffee.ntcoffee.entity.Product;
import jakarta.servlet.http.HttpSession;
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


    @PostMapping("/products/save")
    public String saveProduct(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") double price, RedirectAttributes redirectAttributes) {
        // map truyền thống, 1 filed dưới form map thành 1 biến ở trên hàm post trong controller, tốn kém, code dài ở tham số hàm!!!

        // save thành công thì quay lại trang chính, liệt kê danh sách sản phẩm đã có thêm thứ vừa edit/create
        //return "products"; //.html
        // url giữ nguyên, resubmission của F5
        // model rỗng, thùng rỗng thậm chí còn không thèm đưa
        redirectAttributes.addFlashAttribute("message", "Sản phẩm đã được lưu thành công!");
        return "redirect:/products";
    }


    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("p", new Product());
        return "product-form";
    }


    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        //có trong tay id số mấy, thì vào database query lên, ta tạm thời hard-coded
        Product product;
        if (id.equalsIgnoreCase("NTCF1")) {
            product = new Product("NTCF1", "Cà phê vị Java", 30_000);
        }
        else if (id.equalsIgnoreCase("NTCF2")) {
            product = new Product("NTCF2", "Cà phê vị Ngọc Trinh", 40_000);
        }
        else
            product = new Product("NTCF3", "Cà phê vị Java mix Ngọc Trinh", 5_700_000);
        model.addAttribute("p", product);
        return "product-form";

    }


    @GetMapping({"/ngoctrinh", "/products"})
    public String list(Model model, HttpSession session) {
        List<Product> productList = List.of(
                new Product("NTCF1", "Cà phê vị Java", 30_000),
                new Product("NTCF2", "Cà phê vị Ngọc Trinh", 40_000),
                new Product("NTCF3", "Cà phê vị Java mix Ngọc Trinh", 5_700_000));
        //model.addAttribute("sentUser", username);
        model.addAttribute("products", productList);
        //model.addAttribute("sentUser", session.getAttribute("sentUser"));
        //có session lo giữ acc rồi!!!!!!!!!!!!!!!!!!!!
        Account acc = (Account)session.getAttribute("acc");

        model.addAttribute("role", acc.getRole());
        //gửi danh sách sản phẩm + role sang trang!!!
        //CÓ ROLE THÌ BẬT TẮT NÚT BẤM
        return "products";
    }
}
