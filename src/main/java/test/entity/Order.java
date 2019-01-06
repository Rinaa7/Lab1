package test.entity;
//структура для таблицы заказ
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ORDER",schema = "store")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column (name = "ORDER_QUANTITY", nullable = false)
    private Integer quantity;

    @Column (name = "ORDER_DELIVERYMETHOD", length = 100)
    private String deliverymethod;

    @Column (name = "ORDER_PAYMENTMETHOD", length = 100)
    private String paymentmethod;

    @Column (name = "ORDER_STATUS", length = 30)
    private String status;

    @Column (name = "ORDER_COMMENT", length = 1000)
    private String comment;

    @ManyToOne  (targetEntity = Product.class)
    @JoinColumn (name = "PRODUCT_ID", nullable = false)
    private Product product;

    @ManyToOne  (targetEntity = Customer.class)
    @JoinColumn (name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDeliverymethod() {
        return deliverymethod;
    }

    public void setDeliverymethod(String deliverymethod) {
        this.deliverymethod = deliverymethod;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
