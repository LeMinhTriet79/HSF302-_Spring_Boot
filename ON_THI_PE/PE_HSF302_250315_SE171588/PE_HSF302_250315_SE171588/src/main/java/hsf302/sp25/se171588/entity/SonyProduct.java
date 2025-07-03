package hsf302.sp25.se171588.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "SonyProducts")
public class SonyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private String productName;
    private int price;
    private int stock;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cate_id")
    private SonyCategories sonyCategories;

    public SonyProduct() {
    }

    public SonyProduct(String productName, int price, int stock, Date createdAt, Date updatedAt, SonyCategories sonyCategories) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sonyCategories = sonyCategories;
    }

    public int getProductID() {
        return productID;
    }

//    public void setProductID(int productID) {
//        this.productID = productID;
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SonyCategories getSonyCategories() {
        return sonyCategories;
    }

    public void setSonyCategories(SonyCategories sonyCategories) {
        this.sonyCategories = sonyCategories;
    }

    @Override
    public String toString() {
        return "SonyProduct{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sonyCategories=" + sonyCategories +
                '}';
    }
}
