package com.leminhtriet.coffe.entity;

public class Category {

    private Long id;//key tự tăng là Long Wrapper(long)

    private String name; //id và name dành cho Drop-down
    //combo-box xổ xuống!!!

    private String description; //gây nhiễu

    public Category(){

    }
    //key tự tăng phải loại Id ra


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
}
