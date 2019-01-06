package test.entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ORDER2",schema = "store")
public class Order2 {
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

    @Column(name = "ORDER_ID")
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

    public Order getOrder(){
        Order order = new Order();
        order.setId(id);
        order.setQuantity(quantity);
        order.setDeliverymethod(deliverymethod);
        order.setPaymentmethod(paymentmethod);
        order.setStatus(status);
        order.setComment(comment);
        return order;
    }
}
