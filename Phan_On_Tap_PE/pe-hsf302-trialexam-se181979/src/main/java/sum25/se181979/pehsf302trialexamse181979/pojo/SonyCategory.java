package sum25.se181979.pehsf302trialexamse181979.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "SonyCategories")
public class SonyCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateID;

    @Column(length = 50, nullable = false)
    private String cateName;

    @Column(length = 10, nullable = false)
    private String status;

    // Getter, Setter, Constructor mặc định

    public SonyCategory() {
    }

    public SonyCategory(String cateName, String status) {
        this.cateName = cateName;
        this.status = status;
    }

    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
