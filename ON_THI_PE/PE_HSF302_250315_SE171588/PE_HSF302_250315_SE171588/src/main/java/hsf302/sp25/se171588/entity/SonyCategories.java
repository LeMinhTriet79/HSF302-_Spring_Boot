package hsf302.sp25.se171588.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SonyCategories")
public class SonyCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cateID;
    private String cateName;
    private String cateURL;
    private String status;
    @OneToMany(mappedBy = "sonyCategories", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SonyProduct> productList= new ArrayList<SonyProduct>();

    public SonyCategories() {
    }

    public SonyCategories(String cateName, String cateURL, String status) {
        this.cateName = cateName;
        this.cateURL = cateURL;
        this.status = status;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateURL() {
        return cateURL;
    }

    public void setCateURL(String cateURL) {
        this.cateURL = cateURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SonyProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<SonyProduct> productList) {
        this.productList = productList;
    }

    public int getCateID() {
        return cateID;
    }

//    public void setCateID(int cateID) {
//        this.cateID = cateID;
//    }

    @Override
    public String toString() {
        return "SonyCategories{" +
                "cateID=" + cateID +
                ", cateName='" + cateName + '\'' +
                ", cateURL='" + cateURL + '\'' +
                ", status='" + status + '\'' +
                ", productList=" + productList +
                '}';
    }
}
