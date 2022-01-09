package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Carts")
public class Cart {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private String nazwa;

    @OneToMany(mappedBy = "cart")
    private Set<Product> products;

    public Cart(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Cart() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
