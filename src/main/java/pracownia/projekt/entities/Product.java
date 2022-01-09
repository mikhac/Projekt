package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String productId;

    @Column
    private String name;

    @Column
    @Max(value = 6)
    private BigDecimal price;

    @Column(length = 1000)
    private LocalDateTime bestBeforeDate;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public Product(String productId, String name, BigDecimal price, LocalDateTime date, Cart cart) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.bestBeforeDate = date;
        this.cart = cart;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(LocalDateTime bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }
}
