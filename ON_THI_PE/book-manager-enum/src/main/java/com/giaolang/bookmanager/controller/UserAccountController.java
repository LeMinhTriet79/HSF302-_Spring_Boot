package com.giaolang.bookmanager.controller;

import com.giaolang.bookmanager.entity.UserAccount;
import com.giaolang.bookmanager.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //có thể dùng @Service chạy đc nhưng ko hợp logic về ý nghĩa của class này. Chơi tổng quát thì là @Component
public class UserAccountController {

    //CONTROLLER/GUI --- SERVICE --- REPO -- ...
    //LOGIN CẦN SELECT TỪ TABLE USERACCOUNT CHO NÊN TA CẦN KHAI BÁO USERACCOUNTSERVICE
    @Autowired
    private AccountService service;

    //CLASS NÀY LO CÁC URL LIÊN QUAN ĐẾN MÀN HÌNH LOGIN, TRẢ VỀ TRANG LOGIN CHO CÚ GỌI URL ĐÀU TIÊN -> GET
    //HỨNG LỆNH LOGIN TỪ TRANG LOGIN GỬI LÊN -> POST, DƯỚI POST LÊN EMAIL VÀ PASS

    //ÍT NHẤT 2 METHOD!!!
    //1 METHOD TRẢ VỀ TRANG CHỦ/LOGIN CHO LẦN ĐẦU VÀO WEB
    //1 METHOD XỬ LÍ DATA LOGIN GỬI LÊN
    //NẾU GÕ TỪ TRÌNH DUYỆT LOCALHOST:6969/  HOẶC LOCALHOST:6969/login
    //ĐỀU QUY VỀ HÀM NÀY
    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login";  //return đúng tên trang html, ko có chữ html
                         //SpringBoot tự điền nốt html
    }

    @GetMapping({"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";  //bắt trình duyệt gọi lại url /login
    }

    //ở bên form khi nhấn nút Login thì sẽ gọi URL nào để phục vụ, thì url đó
    //phải map với hàm ở đây
    //HÀM NÀY ĐC GỌI CHỈ KHI NHẤN NÚT LOGIN, VÀ KHI NHẤN, HÀM NÀY ĐC GỌI, THI TOMCAT GỬI NGAY CHO MÌNH EMAIL VÀ PASS TỪ FORM GỬI LÊN (POST, ĐẨY INFO ĐI)
    //GỬI QUA THAM SỐ HÀM
    //HÀM CẦN HỨNG 2 THAM SỐ EMAIL, PASS
    @PostMapping("/do-login")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        //2 giá trị email và pass đã gửi lên, ta query database hoy
        //nhờ Service giúp
        UserAccount acc = service.findByEmail(email);
        if (acc != null && acc.getPassword().equals(password)) {
            //return "books";  //login thành công sang trang books, liệt kê danh sách các cuốn sách CRUD sách

            //return "tên-trang" thì url vẫn là url cũ, mặc dù trang mới, lí do vẫn đang trong logic xử lí của hàm post, url vẫn là post!!!!!!
            //bị hiện tượng re-submit form nếu F5 trình duyệt do url cũ!!! submit form cũ!!!!!!
            //NẾU TRONG SOURCE CODE CÓ RETURN "TÊN TRANG" THÌ KO CẦN CONTROLLER TƯƠNG CÓ HÀM
            //@GETMAPPING VÌ @GETMAPPING CHỈ DÀNH CHO GỌI TRANG TỪ URL
            //RETURN "TÊN TRANG" THÌ BỊ URL GIỮ NGUYÊN CỦA HÀM ĐANG RETURN
            //NẾU MÚN ĐỔI URL THÌ CODE PHẢI LÀ: REDIRECT "URL THẬT NHƯ LÚC GÕ Ở TRÌNH DUYỆT"
            //KHIẾN TRÌNH DUYỆT KHI NHẬN ĐC URL NÀY THÌ PHẢI LÀM 1 REQUEST MỚI THẬT SỰ
            //LÚC NÀY URL ĐỔI

            //CẤT ĐI TRẠNG THÁI LOGIN THÀNH CÔNG, CẤT VÀO BIẾN LÂU DÀI
            //BIẾN NÀY NÓ DÀI THỜI GIAN HƠN Biến Model model
            //Biến thược class HttpSession

            if (acc.getRole() == 1 || acc.getRole() == 2) {
                session.setAttribute("acc", acc);  //cất cái account login thành công vào vùng ram chung server!!! để nhiều page, nhiều hàm có thể truy xuất đc acc; NHƯNG CHỈ DÀNH CHO ĐÚNG CÁI USER ĐÃ LOGIN!!!
                //USER KHÁC LOGIN THÀNH CÔNG THÌ CÓ ACC KHÁC, ỨNG VỚI ACC LOGIN
                //5 USER CÙNG LOGIN, 5 SESSION KHÁC NHAU
                return "redirect:/books";  //khiến trình duyệt phải gọi lại
                //url mới
            }
            else {
                model.addAttribute("error", "Bạn ko có quyền. Chỉ ad và staff mới đc vào!");
                return "login";
            }


        }
        else {  //sai thì trở lại login, thông báo câu sai - gửi login 1 thông điệp
            model.addAttribute("error", "Sai email hoặc password!");
            return "login";
        }


    }

}
