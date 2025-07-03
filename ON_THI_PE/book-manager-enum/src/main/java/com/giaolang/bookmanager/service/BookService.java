package com.giaolang.bookmanager.service;

import com.giaolang.bookmanager.entity.Book;
import com.giaolang.bookmanager.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //CHỨA CÁC HÀM CRUD TABLE BOOK, CÁC HÀM NÀY ĐC GỌI TỪ BOOK-REPO
    //BOOK-REPO LÀ INTERFACE NHƯNG JPA SẼ LO TỰ IMPLEMENT 1 LOẠT HÀM CÓ SẴN CHO TABLE BOOK
    //TỰ INJECT REPO CHO MÌNH LUÔN
    @Autowired
    private BookRepo repo;  //ko cần new vì IOC Container sẽ implement, inject giúp

    //CRUD
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    //xoá sách
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    //tạo sách, update sách
    //lưu ý: bắt validation, mất 1 - 1.5 điểm
    //Tên: chiều dài >= 5 kí tự, chỉ chứa chữ, số, ko cho phép kí tự đặc biệt
    //     sau đó khi xuống DB thì phải chữ hoa từng đầu từ, cắt khoảng trắng giữa
    //ví dụ: gõ:  abc -> chửi < 5
    //            abc lorem# -> chửi vì kí tự đặc biệt
    //            abc lorem123 -> okie, xuống db thì phải thành: Abc Lorem123
    //hàm này nên làm trước, gõ câu này vào ChatGpt
    //prompt: hãy viết cho tôi đúng 1 hàm xử lý chuỗi trong Java, hàm nhận vào 1 chuỗi bất kì và trả về null nếu không hợp lệ, trả về chính chuỗi đó nếu hợp lệ, và chuỗi được đổi qua chữ hoa từng đầu từ. Chuỗi hợp lệ được định nghĩa như sau:
    //không có khoảng trắng dư, lớn hơn 5 kí tự, không chứa kí tự đặc biệt, mà chỉ chứa kí tự và kí số - digit (0, 1, 2...)

    //số: phải nằm trong khoảng/đoạn từ x...y, ví dụ giá tiền phải từ 50..100 đồng


    public Book save(Book obj) {
        //TODO: nên làm hàm check var riêng
        if (obj.getPrice() < 50 || obj.getPrice() > 100)
            throw new IllegalArgumentException("The price must be between 50...100");

        String title = obj.getTitle();
        title = processString(title); //title có nguy cơ là null nếu ko hợp lệ
        //hoặc đc format hợp lệ, cắt trắng dư, đổi hoa từng đầu từ!!!

        if(title == null)
            throw new IllegalArgumentException("Invalid title. It contains only characters and digits and length between 5 to 20 chars!!!");

        obj.setTitle(title); //set lại title sau khi check var

        return repo.save(obj);  //hàm trả về chính obj nếu thành công
    }             //api create /api/books/{id-book} vừa tạo kèm 201

    //hàm tìm 1 cuốn sách theo id
    //phục vụ cho tính năng edit 1 cuốn cụ thể nào đó
    public Book getBookById(long id) {
        return repo.findById(id).orElse(null); //lấy đc 1 cuốn hoặc trả null
    }

    //keyword lấy giá trị từ ô search ở màn hình books
    public List<Book> searchBooksByTitleOrAuthor(String keyword) {
        return repo.findAllByTitleContainingOrAuthorContaining(keyword, keyword);
        //1 ô search gõ vào, tìm cả 2 column của table
    }

    //hàm check var chuỗi
    private String processString(String input) {
        if (input == null) return null;

        // Xóa khoảng trắng dư thừa
        String trimmed = input.trim().replaceAll("\\s+", " ");

        // Kiểm tra độ dài
        if (trimmed.length() <= 5 || trimmed.length() >= 20) {
            return null;
        }

        // Kiểm tra chỉ chứa chữ cái (Unicode) hoặc số hoặc khoảng trắng
        // [\\p{L}] là tất cả các chữ cái trong Unicode (hỗ trợ tiếng Việt)
        // [\\p{N}] là chữ số
        if (!trimmed.matches("[\\p{L}\\p{N} ]+")) {
            return null;
        }

        // Viết hoa chữ cái đầu mỗi từ
        String[] words = trimmed.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = word.charAt(0);
                if (Character.isLetter(firstChar)) {
                    result.append(Character.toUpperCase(firstChar));
                    result.append(word.substring(1).toLowerCase());
                } else {
                    result.append(firstChar); // Giữ nguyên nếu là số
                    result.append(word.substring(1));
                }
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
