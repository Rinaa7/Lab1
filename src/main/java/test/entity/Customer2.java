package test.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="CUSTOMER2",schema = "store")
public class Customer2 {
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

    @Column(name = "CUSTOMER_ID")
    private Integer id;

    @Column (name = "CUSTOMER_SURNAME", length = 200)
    private String surname;

    @Column (name = "CUSTOMER_CONTACTS", length = 100)
    private String contacts;

    @Column (name = "CUSTOMER_SALE",length = 10)
    private Integer sale;

    @Column (name = "CUSTOMER_GEOZONA",length = 5)
    private Integer geozona;

    @OneToMany (mappedBy = "customer")
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getGeozona() {
        return geozona;
    }

    public void setGeozona(Integer geozona) {
        this.geozona = geozona;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setSurname(surname);
        customer.setContacts(contacts);
        customer.setSale(sale);
        customer.setGeozona(geozona);
        return customer;
    }
}
