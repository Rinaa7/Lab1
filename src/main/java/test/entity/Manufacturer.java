package test.entity;
//структура для таблицы производитель
import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="MANUFACTURER",schema = "store")
public class Manufacturer {

        @Id
        @Column(name = "MANUFACTURER_ID")
        @GeneratedValue(strategy = IDENTITY)
        private Integer id;

        @Column (name = "MANUFACTURER_NAME", length = 200)
        private String name;

        @Column (name = "MANUFACTURER_DESCRIPTION", length = 1000)
        private String description;

        @Column (name = "MANUFACTURER_QUANTITY", nullable = false)
        private Integer quantity;

        @OneToMany (mappedBy = "manufacturer")
        private Set<Product> productSet;

        public Set<Product> getProductSet() {
            return productSet;
        }

        public void setProductSet(Set<Product> productSet) {
            this.productSet = productSet;
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
}
