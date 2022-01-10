package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "Tattoos")
public class Tattoo {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    @NotNull
    private String size;

    @Column
    @NotNull
    private String color;

    @Column
    @NotNull
    private BigDecimal price;

    @OneToMany(mappedBy = "tattoo")
    private Set<Order> orders;

    public Tattoo(String name, String description, String size, String color, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Tattoo() {

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
