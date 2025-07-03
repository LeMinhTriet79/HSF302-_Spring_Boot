package com.giaolang.bookmanager.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.*;

@Entity
@Table(name = "Category")
public class Category {

    //key tự tăng (xem đề thi) thì phải là long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Name")
    @Nationalized //nvarchar
    private String name;

    @Column(name = "Description")
    @Nationalized //nvarchar
    private String description;

    //danh sách các cuốn sách thược về cate này this!!!!
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cate")
    private List<Book> books = new ArrayList<Book>();

    public Category() {
    }

    //constructor ko có id do tự tăng
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //getter/setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Book> getBooks() {
        return books;
    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    //2 hàm quan trọng, thêm và xoá 1 cuốn sách nào đó ở danh sách Sách
    //choi moi quan hệ 2 chiều
    public void addBook(Book obj) {
        books.add(obj);  //tơớ chứa danh sách cau
        obj.setCate(this);  //cau phai nhan ho hang voi to
    }

    public void removeBook(Book obj) {
        books.remove(obj);
        obj.setCate(null);
    }
}
