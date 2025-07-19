package com.giaolang.bookstore.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id; //key tự tăng phải là Long wrapper (long)

    @Column(name = "Name",columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;         //id và name dành cho drop-down, combo-box xổ xuống!!!

    @Column(name = "Description",columnDefinition = "NVARCHAR(100)")
    private String description; //gây nhiễu, ko cần show trong driop-down xổ xuống!!!

    //MAPPING MỐI QUAN HỆ 1 - N
    //1 CATE ---<- CÓ NHIỀU BOOK, CHỨA List<Book>
    @OneToMany(mappedBy = "cate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();

    //các hàm để bổ sung/thêm 1 cuốn sách vào cate đang đứng, hay loại bỏ sách ra khỏi cate này (this)
    //list cate này ban đầu là rỗng, chưa có cuốn sách nào, từ từ thêm bớt sách
    public void addBook(Book obj) {
        bookList.add(obj); //cate này (this.) chứa cuốn sách obj
        obj.setCate(this);   //vế ngược lại, cuốn sách obj cũng phải nói rằng hắn thuộc cate này (this)
    }

    public void removeBook(Book obj) {
        bookList.remove(obj);   //cate này (this.) ko còn chứa cuốn sách obj
        obj.setCate(null);      //ngược lại, cuốn sách obj cũng ly khai ko dính đến cate (this) này nữa
    }

    public Category() {
    }

    //key tự tăng phải loại thằng key ra khỏi constructor
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
