package org.minhtriet.sb.service;

import org.minhtriet.sb.infra.ExcelGenerator;
import org.minhtriet.sb.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   //cần dependency rồi: chắc chắn là cần UserRepo
    //                  chắc có thể generate Excel
    //Chích tiêm 2 thằng này vào: 3 đường chích
    //@Autowired REFLECTION TECHNIQUE
    private UserRepo repo;
    //@Autowired
    private ExcelGenerator gen;

   // @Autowired // CHÍCH 2 NHÁC
    //mẶC ĐỊNH KHÔNG CẦN AUTOWIRED KHI CHỈ CÓ 1 CONSTRUCTOR
    public UserService(UserRepo repo, ExcelGenerator gen) {
        this.repo = repo;
        this.gen = gen;
    }
    //đúng chuẩn là phải nhận DTO, entity từ gui/Controller chuyển xuống
    //mock hoi
    public void createUser(){
        repo.save(); //có message được in ra
    }
}
