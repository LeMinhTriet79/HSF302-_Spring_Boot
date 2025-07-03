package com.giaolang.bookmanager.controller;

import com.giaolang.bookmanager.entity.Book;
import com.giaolang.bookmanager.entity.Category;
import com.giaolang.bookmanager.entity.UserAccount;
import com.giaolang.bookmanager.service.BookService;
import com.giaolang.bookmanager.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private CategoryService cateService;  //giúp show list chọn Category từ màn hình tạo mới hoặc edit

    //    //@GetMapping dành cho 2 style gọi trang
                                //gọi trực tiếp từ trình duyệt
                                //gọi qua redirect:/books ở hàm nào đó ko biết
                                //đổi url, vì gọi url

    //khi trang books đc gọi (VIEW), ta (CONTROLLER) gửi kèm nó danh sách cuốn sách cần hiển thị - gửi MODEL, books.html lấy danh sách sách và render

    //HÀM VIẾT TRONG @REQUEST PARAM CÓ REQUIRED = FALSE NGHĨA LÀ
    //HÀM CÓ THỂ CHẠY MÀ KO CẦN KW (TÌNH HUỐNG ĐI TỪ LOGIN SANG)
    //CÒN TÌNH HUỐNG GỌI LẠI CHÍNH MÌNH QUA NHẤN NÚT [SEARCH] THÌ SURE CÓ GỬI KEYWORD
    @GetMapping("/books")
    public String showBooksPage(@RequestParam(name = "kw", required = false) String keyword, Model model, HttpSession session) {

        //CHECK COI ĐÃ LOGIN CHƯA THÌ MỚI SEARCH, HAY SHOW HẾT SÁCH
        //CHƯA LOGIN THÌ CHỬI, VÒNG VỀ LOGIN
        //ĐỀ PHÒNG CẢ TÌNH HUỐNG, VÀO TRÌNH DUYỆT GÕ TRỰC TIẾP URL CX ĐẾN ĐC ĐÂY, CHẶN CỬA BIẾN SESSION
        UserAccount loggedAcc = (UserAccount) session.getAttribute("acc");
        if (loggedAcc == null) {
            //bạn chưa thèm login, đi trực tiếp url, chửi, bắt login
            model.addAttribute("error", "Bạn chưa login!");
            return "login";
        }

        List<Book> books; //LIST BOOK NÀY CÓ THỂ FULL NẾU ĐI TỪ LOGIN
        //CÓ THỂ RỖNG, HOẶC ÍT HƠN NẾU ĐI QUA SEARCH
        //CHECK MODE HÀM NÀY, HÀM NÀY GỌI TỪ LOGIN HAY TỪ NÚT BẤM [SEARCH]
        //DÙNG VALUE CỦA KEYWORD ĐỂ BIẾT MODE
        if (keyword != null && !keyword.isEmpty()) {
            //có keyword rồi, search thôi
            books = service.searchBooksByTitleOrAuthor(keyword);
        }
        else {
            books = service.getAllBooks();  //ko có keyword, lấy full
        }

        model.addAttribute("books", books);  //gửi List books sang html
        //html có nhiệm vụ lặp qua books lôi từng cuon sách đưa vào html table

        //gửi thêm cho trang cái role trích ra từ user trích ra từ session
        model.addAttribute("role", loggedAcc.getRole());
        //role để disable nút bấm/link create, update, delete

        //model.addAttribute(key, value-danh-sách-sách);
        return "books";  //book.html
    }

    //hHÀM CŨ NÀY DÀNH CHO CHƯA CÓ TÍNH NĂNG SEARCH
    //HÀM CHƯA NHẬN KEYWORD TỪ Ô SEARCH ĐEM ĐẾN ĐÂY
//    @GetMapping("/books")
//    public String showBooksPage(Model model) {
//        List<Book> books = service.getAllBooks();
//        model.addAttribute("books", books);  //gửi List books sang html
//        //html có nhiệm vụ lặp qua books lôi từng cuon sách đưa vào html table
//
//        //model.addAttribute(key, value-danh-sách-sách);
//        return "books";  //book.html
//    }

    @GetMapping("/delete/{id}") //path param
    public String deleteBook(@PathVariable("id") long id) {
        service.deleteById(id);
        return "redirect:/books";
    }

    //2 method ứng với gọi màn hình create -> book-form, book-detail trống trơn
    //                 gọi màn hình edit   -> book-form đc fill info từ /edit/1  /edit/2...
    //2 method này đc gọi từ hyperlink bên màn hình chính -> GetMapping
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        //mở màn hình trắng, tức object Book chưa có id, title, price...
        Book emptyBook = new Book();
        model.addAttribute("book", emptyBook);

        List<Category> cates = cateService.getAllCates();
        //gửi luôn sang màn hình tạo mới 2 thứ, cuốn sách trắng trơn và list cate
        model.addAttribute("cates", cates);
        return "book-form";
    }

    @GetMapping("/edit/{id}") //path param
    public String editBook(@PathVariable("id") long id, Model model) {
        //mở màn hình trắng, tức object Book chưa có id, title, price...
        Book aBook = service.getBookById(id);
        model.addAttribute("book", aBook);
        List<Category> cates = cateService.getAllCates();

        //gửi luôn sang màn hình tạo mới 2 thứ, cuốn sách trắng trơn và list cate
        model.addAttribute("cates", cates);
        return "book-form";
    }

    @PostMapping("/save")
    public String doSave(@ModelAttribute("book") Book book, Model model) {

        try {
            service.save(book);
            return "redirect:/books"; //trở về trang trước books, gọi post sẽ giữ url cũ

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); //lấy message lỗi của exception, thảy về trang book-form, hiể thị lỗi trên trang vừa nhap

            //bị mất danh sách cate
            List<Category> cates = cateService.getAllCates();
            //gửi luôn sang màn hình tạo mới 2 thứ, cuốn sách trắng trơn và list cate
            model.addAttribute("cates", cates);

            return "book-form";
        }


    }
}
