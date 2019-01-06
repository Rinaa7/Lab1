package test.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="PRODUCT2", schema = "store")
public class Product2 {
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

    @Column(name = "PRODUCT_ID")
    private Integer id;

    @Column (name = "PRODUCT_NAME", length = 200)
    private String name;

    @Column (name = "PRODUCT_DESCRIPTION", length = 1000)
    private String description;

    @Column (name = "PRODUCT_PRICE", nullable = false)
    private Double price;

    @Column (name = "PRODUCT_QUANTITY", nullable = false)
    private Integer quantity;

    @ManyToOne  (targetEntity = Category.class)
    @JoinColumn (name = "CATEGORY_ID", nullable = false)
    private Category category;

    @ManyToOne  (targetEntity = Manufacturer.class)
    @JoinColumn (name = "MANUFACTURER_ID", nullable = false)
    private Manufacturer manufacturer;

    @OneToMany (mappedBy = "product")
    private Set<Order> orderSet;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Product getProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
