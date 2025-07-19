package com.giaolang.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id = 0L;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)  //DB SCOPE
    @NotBlank(message = "Name is required!")  //VALIDATION SCOPE - KIỂM TRA DATA TỪ FORM NHẬP CÓ HỢP LỆ HAY KO KHI BINDING
    @Size(min = 5, max = 50, message = "Name must be 5–50 characters!")
//    @Pattern(
//            regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
//            message = "Words must start with a capital letter, use only letters, and avoid numbers, special characters, or extra spaces!"
//    )
    private String name;

    @Column(name = "AuthorName", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Author name is required!")
    @Size(min = 5, max = 50, message = "Author name must be 5–50 characters!")
    private String authorName;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required!")
    @Min(value = 1, message = "Quantity must be between 1 and 100!")
    @Max(value = 100, message = "Quantity must be between 1 and 100!")
    private int quantity;

    @Column(name = "Price", nullable = false)
    @NotNull(message = "Price is required!")
    @Min(value = 1, message = "Price must be between 1 and 1M!")
    @Max(value = 1_000_000, message = "Price must be between 1 and 1M!")
    private double price;

    @Column(name = "CreatedAt", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;


    //MAPPING MỐI QUAN HỆ GIỮA CATEGORY ---<- BOOK
    //NHIỀU CUỐN SÁCH BOOK SẼ THUỘC VỀ HAY CÓ CÙNG 1 PHÂN LOẠI CATE
    @ManyToOne
    @JoinColumn(name = "CateId")  //FK: góc nhìn DB,
                                  // cột FK CateId này sẽ trỏ sang table Category (ứng với cột PK Id)
    private Category cate; //góc nhìn OOP: biến này link/trỏ sang object Category nào đó!!!

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public Book() {
    }

    public Book(String name, String authorName, int quantity, double price) {
        this.name = name;
        this.authorName = authorName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }





}
