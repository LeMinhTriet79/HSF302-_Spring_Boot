package com.giaolang.bookstore.controller;

import com.giaolang.bookstore.entity.Account;
import com.giaolang.bookstore.entity.Book;
import com.giaolang.bookstore.service.BookService;
import com.giaolang.bookstore.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller //1. Chịu trách nhiệm hứng các url từ trình duyệt (GET, POST...)
               //hứng data gửi lên cho server,
               //2. Gọi hàm xử lí
               //3. Return lại tên trang web, hoặc 1 url khác (redirect)
public class BookController {

    //tiêm bookService qua nhiều cách: field, constructor, setter
    @Autowired
    private BookService bookService; //tự IOC Container của Spring new, tiêm

    //tiêm thêm CateService để lấy danh sách Cates để show trong màn hình book-form
    //ta xài full data của bảng 1 trong mối quan hệ 1-N, để show ra drop-down
    @Autowired
    private CategoryService categoryService; //tự IoC

    @GetMapping("/books")   //CONTROLLER
    public String showList(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model, HttpSession ss) {  //MODEL, thùng chứa info sẽ gửi cho trang trước khi render

        //TODO: CODE CÒN BAD SMELLS (ROBERT C. MARTIN -> SOLID, CLEAN CODE)
        //TODO: REFACTOR, TÁCH HÀM, TỐI ƯU CODE

        Account acc = (Account) ss.getAttribute("loggedInUser");
        if (acc == null) {
            //chưa login, vì tìm ko thấy info đã login nằm trong quảng trường, thùng dài lâu session
            return "redirect:/login";
        }

        //kiểm tra keyword có hay ko, c thì search gần đúng - LIKE, RELATIVE SEARCH
        if (!keyword.equals("")) {
            model.addAttribute("books", bookService.searchBooksByNameOrAuthor(keyword));
        }
        else {
            //ko có thì show full
            //                List<Book> books = bookService.getAllBooks()
            model.addAttribute("books", bookService.getAllBooks());  //gửi ds book đọc từ table, vào thùng cho view dùng
        }

        return "books";  //.html  VIEW
        //kèm cái thùng chứa data, nhờ Thymeleaf engine trộn, mix, merge, render, đưa cho Tomcat bản hoàn chỉnh thuần HTML
    }

    @GetMapping("/books/edit/{id}")   //CONTROLLER
    public String edit(@PathVariable("id") Long id, Model model, HttpSession ss) {  //MODEL, thùng chứa info sẽ gửi cho trang trước khi render

        //TODO: CODE CÒN BAD SMELLS (ROBERT C. MARTIN -> SOLID, CLEAN CODE)
        //TODO: REFACTOR, TÁCH HÀM, TỐI ƯU CODE

        Account acc = (Account) ss.getAttribute("loggedInUser");
        if (acc == null) {
            //chưa login, vì tìm ko thấy info đã login nằm trong quảng trường, thùng dài lâu session
            return "redirect:/login";
        }

        //role = 2, 1, 3 => ENUM!!! Role.STAFF
        if (acc.getRole() == 2) { //staff mà bày đặt edit
            //đã login, nhưng coi chừng role staff gõ url trực tiếp là giết, login đi
            return "redirect:/books";
        }

        //               Book  selectedOne = bookService.getBookById(id);
        model.addAttribute("selectedOne", bookService.getBookById(id));  //gửi ds book đọc từ table, vào thùng cho view dùng

        //gửi thêm danh sách cate để xổ danh sách treo đầu dê lấy thịt heo
        //                                        show cate name, nhưng lấy cate id
        //                                        vì ta cần FK value cho table Book
        //               List<Category> cates = categoryService.getAllCategories();
        model.addAttribute("cates", categoryService.getAllCategories());

        //GỬI THÊM EM PHẤT CỜ TRẠNG THÁI/BIẾN FLAG LƯU CÁI MODE/TRẠNG THÁI, CHẾ ĐỘ MỞ MÀN HÌNH
        model.addAttribute("formMode", "edit");
        //                     String fromMode = "edit"; gửi biến formMode sang màn hình book-form.html

        return "book-form";  //.html  VIEW
        //kèm cái thùng chứa data, nhờ Thymeleaf engine trộn, mix, merge, render, đưa cho Tomcat bản hoàn chỉnh thuần HTML
    }


    @GetMapping("/books/create")   //CONTROLLER
    public String create(Model model, HttpSession ss) {  //MODEL, thùng chứa info sẽ gửi cho trang trước khi render

        //TODO: CODE CÒN BAD SMELLS (ROBERT C. MARTIN -> SOLID, CLEAN CODE)
        //TODO: REFACTOR, TÁCH HÀM, TỐI ƯU CODE

        Account acc = (Account) ss.getAttribute("loggedInUser");
        if (acc == null) {
            //chưa login, vì tìm ko thấy info đã login nằm trong quảng trường, thùng dài lâu session
            return "redirect:/login";
        }

        //role = 2, 1, 3 => ENUM!!! Role.STAFF
        if (acc.getRole() == 2) { //staff mà bày đặt edit
            //đã login, nhưng coi chừng role staff gõ url trực tiếp là giết, login đi
            return "redirect:/books";
        }

        //TẠO MỚI VẪN PHẢI GỬI 1 SELECTED OBJECT CHÍNH LÀ 1 OBJ book BÊN TRONG DEFAULT, CHUỖI KO GÌ CẢ, SỐ LÀ 0, BOOLEAN LÀ SAI
        model.addAttribute("selectedOne", new Book());  //gửi ds book đọc từ table, vào thùng cho view dùng

        model.addAttribute("cates", categoryService.getAllCategories() );

        model.addAttribute("formMode", "new");
        //                     String fromMode = "edit"; gửi biến formMode sang màn hình book-form.html

        return "book-form";  //.html  VIEW
        //kèm cái thùng chứa data, nhờ Thymeleaf engine trộn, mix, merge, render, đưa cho Tomcat bản hoàn chỉnh thuần HTML
    }

    //link save
    @PostMapping("/books/save")   //CONTROLLER
    //PHẢI LẤY DATA TỪ DƯỚI MÀN HÌNH FORM GỬI LÊN: id, name, quantity, price, cate id => 2 CÁCH LẤY
    //CÁCH 1: TRÂU BÒ, DÙNG @RequestParam("id") String id,
    //                      @RequestParam("price") double price
    //                      ...
    //       chỉ dùng nếu ít field
    //CÁCH 2: OBJECT BINDING, TOÀN BỘ FORM THÀNH 1 OBJECT ĐẨY LÊN ĐÂY, TRÊN NÀY CHỈ 1 THAM SỐ book GOM...
    //               DÙNG @ModelAttribute("????") Book book
    //THAY VÌ CÁCH 1 GỬI LẺ TỪNG PHẦN CỦA OBJECT, CÁCH 2 GỬI SỈ, 1 OBJECT CHỨA CÁC THÀNH PHẦN
    //???? ĐI XUỐNG LÀ GÌ, ĐI LÊN LÀ ĐÓ - BIẾN SELECTED ONE NẰM Ở TAG <FORM>!!!

    //KĨ THUẬT BEAN VALIDATION, CHỈ ĐC SỬ DỤNG NẾU BẠN DÙNG CƠ CHẾ BINDING OBJECT TỪ DƯỚI FORM HTML LÊN CONTROLLER. NẾU BẠN DÙNG @RequestParam("price")... thì ko xài đc kĩ thuật validation này
    //CHẶN ĐẦU CHẶN ĐUÔI QUA TRÌNH BINDING DỮ LIỆU TỪ DƯỚI FORM LÊN OBJECT
    //CHẶN ĐẦU QUA @Valid ĐỂ KÍCH HOẠT VIỆC KIỂM SOÁT TỪNG FIELD ĐC GÁN GIÁ TRỊ CÓ BỊ LỖI HAY KO
    //NẾU PHÁT HIỆN CÓ LỖI, THÌ GHI BIÊN BẢN qua BindingResult
    //BIÊN BẢN VI PHẠM RESULT TỰ ĐC ADD VÀO THÙNG MODEL GỬI TRỞ LẠI FORM NẾU MÌNH QĐ CÓ LỖI NHẬP THÌ TRỞ LẠI FORM
    public String save(@Valid @ModelAttribute("selectedOne") Book book, BindingResult result, Model model, @RequestParam("formMode") String formMode) {
        //save xong trả về trang books, show danh sách có book mới, hoặc book đã đc cập nhật!!!

        //NẾU CÓ LỖI NHẬP TRONG QUÁ TRÌNH BINDING, THÌ VÒNG LẠI MÀN HÌNH NHẬP
        if (result.hasErrors()) {

            //gởi thêm cates khi ở màn hình show error
            model.addAttribute("cates", categoryService.getAllCategories() );

            //gửi lại formMode nhen
            model.addAttribute("formMode", formMode);
            //                                       "new", "edit" đc gửi khi nhấn [Save]

            return "book-form";  //đã gửi kèm biên bản result sang form
        }

        //nhờ Service save: key mới thì là insert, key cũ thì là update, tự Hibernate nó tính cho mình qua thằng Repo
        //TODO: KEY TRÙNG KHI TẠO MỚI...
        if (formMode.equals("new")) {
            //check key trùng...
            if (bookService.existsBook(book.getId())) {
                //trùng key rồi, ko save đc, phải chửi, vòng lại màn hình nhập
                //gởi thêm cates khi ở màn hình show error
                model.addAttribute("cates", categoryService.getAllCategories() );

                //gửi lại formMode nhen
                model.addAttribute("formMode", formMode);
                model.addAttribute("duplicated", "Duplicated Id. Input another one!");
                return "book-form";  //đã gửi kèm biên bản result sang form
            }
        }

        //ko trùng id thì save bình thường
        //và còn dùng lun cho edit
        bookService.saveBook(book);

        //return "books";  //bị url CŨ VẪN CÒN /save, F5 RESUBMISSION
        return "redirect:/books";  //GỌI LẠI HÀM SHOWLIST() Ở TRÊN
                                     //REDIRECT: BẮT TRÌNH DUYỆT GỌI URL KHÁC
                                    // /save bị thay bằng  /books, F5 KO SỢ
    }

    //link delete
    @GetMapping("/books/delete/{id}")   //CONTROLLER
    public String delete(@PathVariable("id") Long id, HttpSession ss) {

        //TODO: CODE CÒN BAD SMELLS (ROBERT C. MARTIN -> SOLID, CLEAN CODE)
        //TODO: REFACTOR, TÁCH HÀM, TỐI ƯU CODE
        Account acc = (Account) ss.getAttribute("loggedInUser");
        if (acc == null) {
            //chưa login, vì tìm ko thấy info đã login nằm trong quảng trường, thùng dài lâu session
            return "redirect:/login";
        }

        //role = 2, 1, 3 => ENUM!!! Role.STAFF
        if (acc.getRole() == 2) { //staff mà bày đặt edit
            //đã login, nhưng coi chừng role staff gõ url trực tiếp là giết, login đi
            return "redirect:/books";
        }

        bookService.deleteBook(id);

        return "redirect:/books";
    }

}
