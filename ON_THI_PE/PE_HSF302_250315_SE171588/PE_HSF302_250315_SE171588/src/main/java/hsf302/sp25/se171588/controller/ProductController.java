package hsf302.sp25.se171588.controller;

import hsf302.sp25.se171588.entity.SonyProduct;
import hsf302.sp25.se171588.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
//    @Autowired
//    private CategoriesService categoriesService;
    @GetMapping
    public String bookPage(Model model, HttpSession session){
        auth(session);
        List<SonyProduct> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
    private void auth(HttpSession session){
        if(session.getAttribute("role") == null){
            throw new SecurityException("Unauthorized access");
        }
    }
    @GetMapping("/search")
    public String search(Model model, HttpSession session, @RequestParam String keyword){
        List<SonyProduct> products = productService.getAllProducts();
        if(keyword!=null && !keyword.isEmpty()){
            products=productService.getProductsByName(keyword);
            model.addAttribute("keyword", keyword);
        } else{
            products=productService.getAllProducts();
        }
        model.addAttribute("products", products);
        return "products";
    }
}
