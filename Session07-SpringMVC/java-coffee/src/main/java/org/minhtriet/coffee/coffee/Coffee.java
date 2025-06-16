package org.minhtriet.coffee.coffee;

public class Coffee {
    private String id;
    private String name;
    private double price;


    public Coffee(String id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Coffee(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
