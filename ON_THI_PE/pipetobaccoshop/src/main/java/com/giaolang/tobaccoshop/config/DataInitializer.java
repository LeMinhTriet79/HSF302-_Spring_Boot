package com.giaolang.tobaccoshop.config;

import com.giaolang.tobaccoshop.entity.*;
import com.giaolang.tobaccoshop.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AccountRepo accountRepo;
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;
    // Đặt list categories là biến instance
    private List<Category> categories;

    public DataInitializer(AccountRepo accountRepo, CategoryRepo categoryRepo, ProductRepo productRepo) {
        this.accountRepo = accountRepo;
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (accountRepo.count() == 0) {
            accountRepo.save(new Account(null, "admin", "admin123", "ADMIN"));
            accountRepo.save(new Account(null, "user", "user123", "USER"));
        }
        if (categoryRepo.count() == 0) {
            categoryRepo.saveAll(Arrays.asList(
                    new Category(null, "Thuốc Anh"),
                    new Category(null, "Thuốc Mỹ"),
                    new Category(null, "Thuốc Đan Mạch"),
                    new Category(null, "Thuốc Đức"),
                    new Category(null, "Thuốc Pháp")
            ));
        }
        if (productRepo.count() == 0) {
            categories = categoryRepo.findAll();

            productRepo.saveAll(Arrays.asList(
                    new Product(null, "Samuel Gawith Full Virginia Flake", 350000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0147.jpg",
                            "Thuốc lá tẩu Anh, vị Virginia nguyên chất, cổ điển và sâu lắng.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Dunhill Nightcap", 370000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0171.jpg",
                            "Blend mạnh, hậu vị cay đậm, được yêu thích bởi người hút lâu năm.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Peterson Sherlock Holmes", 360000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0244.jpg",
                            "Hương vị đặc biệt, tinh tế, mùi thơm nhẹ nhàng.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Mac Baren HH Old Dark Fired", 330000,
                            "https://www.smokingpipes.com/images/products-hr/002-016-0207.jpg",
                            "Thuốc Đan Mạch, vị mạnh, hậu vị thịt xông khói đặc trưng.",
                            getCatByName("Thuốc Đan Mạch")),
                    new Product(null, "Erinmore Mixture", 300000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0038.jpg",
                            "Vị ngọt hoa quả, dễ hút, phù hợp người mới bắt đầu.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Capstan Blue", 340000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0021.jpg",
                            "Thuốc Anh huyền thoại, hương vị Virginia cổ điển.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Cornell & Diehl Autumn Evening", 390000,
                            "https://www.smokingpipes.com/images/products-hr/002-016-0012.jpg",
                            "Aromatic Mỹ, vị syrup phong đặc trưng, thơm ngọt ngào.",
                            getCatByName("Thuốc Mỹ")),
                    new Product(null, "Savinelli 145 Anniversary", 360000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0473.jpg",
                            "Thuốc Ý, pha trộn độc quyền kỷ niệm, vị cân bằng.",
                            getCatByName("Thuốc Anh")),
                    new Product(null, "Rattray's Marlin Flake", 355000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0088.jpg",
                            "Vị ngọt nhẹ, sâu, rất được ưa chuộng trên toàn cầu.",
                            getCatByName("Thuốc Đức")),
                    new Product(null, "Orlik Golden Sliced", 310000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0116.jpg",
                            "Thuốc Đan Mạch, nhẹ nhàng, phù hợp người mới bắt đầu.",
                            getCatByName("Thuốc Đan Mạch")),
                    new Product(null, "Davidoff Danish Mixture", 370000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0300.jpg",
                            "Pha trộn thơm tinh tế của hãng Davidoff danh tiếng.",
                            getCatByName("Thuốc Đức")),
                    new Product(null, "Escudo Navy De Luxe", 375000,
                            "https://www.smokingpipes.com/images/products-hr/001-003-0196.jpg",
                            "Thuốc tròn vị, blend Virginia và Perique, đậm và ngọt hậu.",
                            getCatByName("Thuốc Đan Mạch"))
            ));
        }
    }

    // HÀM HỖ TRỢ: lấy Category theo tên
    private Category getCatByName(String name) {
        if (categories == null || categories.isEmpty()) return null;
        for (Category c : categories) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        // Nếu không tìm thấy, trả về phần tử đầu tiên (hoặc null tuỳ bạn muốn)
        return categories.get(0);
    }

}