package sum25.se181979.pehsf302trialexamse181979.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyAccount;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyCategory;
import sum25.se181979.pehsf302trialexamse181979.pojo.SonyProduct;
import sum25.se181979.pehsf302trialexamse181979.service.SonyCategoryService;
import sum25.se181979.pehsf302trialexamse181979.service.SonyProductService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/products")
public class SonyProductController {
    @Autowired
    private SonyProductService productService;

    @Autowired
    private SonyCategoryService categoryService;

    // Kiểm tra đăng nhập và phân quyền
    private boolean checkAdmin(HttpSession session) {
        SonyAccount acc = (SonyAccount) session.getAttribute("user");
        return acc != null && acc.getRoleID() == 1;
    }
    private boolean checkStaffOrAdmin(HttpSession session) {
        SonyAccount acc = (SonyAccount) session.getAttribute("user");
        return acc != null && (acc.getRoleID() == 1 || acc.getRoleID() == 2);
    }

    // Hiển thị danh sách sản phẩm (sau đăng nhập)
    @GetMapping
    public String list(Model model, HttpSession session) {
        if (!checkStaffOrAdmin(session)) return "redirect:/login";
        List<SonyProduct> products = productService.getAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    // Trang thêm mới sản phẩm (Admin)
    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (!checkAdmin(session)) return "redirect:/login";
        model.addAttribute("product", new SonyProduct());
        model.addAttribute("categories", categoryService.getAll());
        return "product-add";
    }

    // Xử lý thêm mới sản phẩm (Admin)
    @PostMapping("/add")
    public String addProduct(
            @ModelAttribute("product") SonyProduct product,
            HttpSession session,
            Model model
    ) {
        if (!checkAdmin(session)) return "redirect:/login";

        // VALIDATE ĐẦY ĐỦ (như yêu cầu đề)
        if (product.getProductName() == null || product.getProductName().trim().length() < 5 || product.getProductName().trim().length() > 50
                || product.getPrice() == null || product.getPrice() < 100
                || product.getStock() == null || product.getStock() < 0 || product.getStock() > 1000
                || product.getCategory() == null) {
            model.addAttribute("error", "Thông tin sản phẩm không hợp lệ!");
            model.addAttribute("categories", categoryService.getAll());
            return "product-add";
        }
        product.setCreatedAt(LocalDateTime.now());
        productService.save(product);
        return "redirect:/products";
    }

    // Trang sửa sản phẩm (Admin)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (!checkAdmin(session)) return "redirect:/login";
        SonyProduct product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        return "product-edit";
    }

    // Xử lý sửa sản phẩm (Admin)
    @PostMapping("/edit/{id}")
    public String editProduct(
            @PathVariable("id") Long id,
            @ModelAttribute("product") SonyProduct product,
            HttpSession session,
            Model model
    ) {
        if (!checkAdmin(session)) return "redirect:/login";

        // VALIDATE y như thêm mới
        if (product.getProductName() == null || product.getProductName().trim().length() < 5 || product.getProductName().trim().length() > 50
                || product.getPrice() == null || product.getPrice() < 100
                || product.getStock() == null || product.getStock() < 0 || product.getStock() > 1000
                || product.getCategory() == null) {
            model.addAttribute("error", "Thông tin sản phẩm không hợp lệ!");
            model.addAttribute("categories", categoryService.getAll());
            return "product-edit";
        }

        SonyProduct oldProduct = productService.getById(id);
        oldProduct.setProductName(product.getProductName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStock(product.getStock());
        oldProduct.setCategory(product.getCategory());
        // oldProduct.setCreatedAt(oldProduct.getCreatedAt()); // giữ nguyên ngày tạo
        productService.save(oldProduct);
        return "redirect:/products";
    }

    // Xóa sản phẩm (Admin)
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, HttpSession session) {
        if (!checkAdmin(session)) return "redirect:/login";
        productService.delete(id);
        return "redirect:/products";
    }

    // Thống kê: Top 3 sản phẩm tồn kho cao nhất mỗi danh mục (Admin)
    @GetMapping("/top3")
    public String top3EachCategory(Model model, HttpSession session) {
        if (!checkAdmin(session)) return "redirect:/login";
        List<SonyCategory> categories = categoryService.getAll();
        // Map category -> top 3 product list
        model.addAttribute("categories", categories);
        model.addAttribute("productService", productService); // Truy cập được trong thymeleaf
        return "product-top3";
    }
}