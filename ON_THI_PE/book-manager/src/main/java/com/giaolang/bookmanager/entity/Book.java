package com.giaolang.bookmanager.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Book")
public class Book {

    //key tự tăng (xem đề thi) thì phải là long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Title")
    @Nationalized //nvarchar
    private String title;

    @Column(name = "Author")
    @Nationalized //nvarchar
    private String author;

    @Column(name = "Price")
    private double price;       //validation trên các ô nhập
                                //giá: 50...100
                                //tên, tác giả: ít nhất  5 kí tự, ko kí tự đb...
                                //lúc save thì chữ hoa từng đầu từ...
                                //RegEx - mặt nạ nhập, nhập theo định dạng
    //mối quan hê N - 1 với Cate
    @ManyToOne
    @JoinColumn(name = "CateId") //cột khoá ngoại ở table Book
    private Category cate;

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    //constructor
    public Book() {
    }

    public Book(String title, String author, double price, Category cate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.cate = cate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
