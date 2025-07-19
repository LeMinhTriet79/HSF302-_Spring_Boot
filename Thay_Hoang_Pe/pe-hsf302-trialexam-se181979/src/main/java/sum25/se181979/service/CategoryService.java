package sum25.se181979.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se181979.pojo.Category;
import sum25.se181979.repository.CategoryRepository;

import java.util.List;

//@Component
@Service
public class CategoryService {

    //tiêm repo, có 3 cách
    @Autowired
    //có 1 đống hàm tự sinh cho CRUD Cate rồi nhen - xài hoy - query method trong biến cateRepo, chấm thoy, mặn mà luôn
    private CategoryRepository cateRepo;

    //tiêm qua constructor
    //ko cần @Autowire nếu class chỉ có 1 cst này!!! tiêm ngay lúc new, chỉ có 1 đường new
    public CategoryService(CategoryRepository cateRepo) {
        this.cateRepo = cateRepo;
    }

    //CRUD TRUYỀN THỐNG, GỌI HÀM DERIVED QUERY METHODS TỰ SINH CỦA THẰNG REPO ĐC TIÊM VÀO TỰ ĐỘNG ĐỘNG
    public void saveCategory(Category o) {
        cateRepo.save(o);  //hàm tự sinh
    }


    public List<Category> getAllCategories() {
        return cateRepo.findAll(); //hàm tự sinh, câu JPQL: SELECT c FROM CATEGORY c;  //ngầm sẽ là SELECT * FROM CATEGORY
    } //dùng cho combobox treo đầu dê...

    //CÁC HÀM KHÁC: SEND-NOTI(), VOUCHER()...
}

