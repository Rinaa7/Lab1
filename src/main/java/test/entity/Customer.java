package test.entity;
//структура для таблицы пользователь

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="CUSTOMER",schema = "store")
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = IDENTITY)
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

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
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
}
