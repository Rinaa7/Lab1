package test.entity;

//структура для таблицы продукт
import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="PRODUCT", schema = "store")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = IDENTITY)
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

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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


}
