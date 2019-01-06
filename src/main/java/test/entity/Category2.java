package test.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="CATEGORY2", schema = "store")
public class Category2 {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id2;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "INPUT")
    private Date input;

    @Column(name = "USER_ID")
    private String userid;

    @Column(name = "READ")
    private boolean isRead;

    @Column(name = "CATEGORY_ID")
    private Integer id;

    @Column (name = "CATEGORY_NAME", length = 200)
    private String name;

    @Column (name = "CATEGORY_DESCRIPTION", length = 1000)
    private String description;

    @Column (name = "CATEGORY_QUANTITY", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "category")
    private Set<Product> productSet;

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getInput() {
        return input;
    }

    public void setInput(Date input) {
        this.input = input;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Category getCategory(){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setQuantity(quantity);
        return category;
    }
}
