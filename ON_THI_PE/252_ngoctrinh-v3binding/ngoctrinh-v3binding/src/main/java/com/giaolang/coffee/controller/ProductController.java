package com.giaolang.coffee.controller;

import com.giaolang.coffee.entity.Product;
import com.giaolang.coffee.service.CategoryService;
import com.giaolang.coffee.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //bean luôn
public class ProductController {

    //NHỜ SERVICE GIÚP LÁY FULL DATA TỪ TABLE
    //TỰ SERVICE CHƠI VỚI REPO. NGUYÊN LÝ SRP
    @Autowired
    private ProductService productService;

    @Autowired  //phục vụ cho danh sách treo đầu dê...
    private CategoryService categoryService;

//    @GetMapping("/products")
//    public String showProducts(Model model) {
//
//        List<Product> productList = productService.getAllProducts();
//
//        model.addAttribute("prods", productList);
//
//        //thùng hàng đi kèm trang chứa full sản phầm từ table
//        return "products"; //.html
//    }
@GetMapping("/products")
public String showProducts(@RequestParam(name = "kw", required = false, defaultValue = "") String keyword, Model model) {
    List<Product> productList;
    if (keyword.equals("")) {
        //show full
        productList = productService.getAllProducts();

        model.addAttribute("prods", productList);
    }else {
        //search theo keyword thôi, thiếu hàm search rồi
        productList = s //where like!!!!!!
    }


    //thùng hàng đi kèm trang chứa full sản phầm từ table
    return "products"; //.html
}

    //link edit đc nhấn
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") String id, Model model) {

        //có id rồi, where và ném thằng này về trang form - detail
        Product product = productService.getProductById(id);

        //                         Product selectedOne = product; ở trên
        model.addAttribute("selectedOne", product);

        model.addAttribute("cates", categoryService.getAllCategories());

        //thùng hàng đi kèm trang chứa full sản phầm từ table
        return "product-form"; //.html
    }
    //link new đc nhân
    @GetMapping("/products/new")
    public String newProduct(Model model) {

        //constructor rỗng tạo 1 object mang giá trị default ở các field bên trong
        //chuỗi là rỗng, số là 0, boolean là sai
        model.addAttribute("selectedOne", new Product());

        model.addAttribute("cates", categoryService.getAllCategories());
        //thùng hàng đi kèm trang chứa full sản phầm từ table
        return "product-form"; //.html
    }

    //button save đc nhấn
    @PostMapping("/products/save")
    //làm ko khéo, 1 đống @RequestParam map từng field ở form vào từng biến ở tham số hàm
    //public String saveProduct(@RequestParam("name") String name, @Res....) {
    public String saveProduct(@Valid @ModelAttribute("selectedOne") Product product, BindingResult result, Model model) {
        //@Valid phải đứng trước lệnh @ModelAttribute, đứng trước lệnh gom data từ object dưới, html gửi lên, mang ý nghĩa
        //tui sẽ check xem data anh gởi từ html lên có hợp lệ như khai báo trong entity hay không
        //nếu không hợp lệ, gom lỗi vào trong object @BindingResult
        //biến gom lỗi phải nằm ngay sau @ModelAttribute

        // Nếu có lỗi nhập thì vòng lại màn hình product-form in câu chửi, và yêu cầu sửa

        if(result.hasErrors()) {
            //đưa lại cái danh sách cate


            model.addAttribute("cates", categoryService.getAllCategories());
            return "product-form";// quay trở lại màn hình show lỗi
        }


        //gọi service save hoy, tạm bỏ qua key trùng, validation
        productService.saveProduct(product);

        return "redirect:/products"; //url nhen, ko phải tên trang!!!
    }      //gọi url mới, đổi url trên browser, tránh resubmission

    //link delete đc nhấn
    //link edit đc nhấn
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id, Model model) {

        productService.deleteProductById(id);

        //thùng hàng đi kèm trang chứa full sản phầm từ table
        return "redirect:/products"; //.html
    }
    //link n
    //link search đc nhấn

}
