package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "done_by", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "tattoo", nullable = false)
    private Tattoo tattoo;

    @Column
    @NotNull
    private String bodyPart;

    @Column
    @NotNull
    private BigDecimal total;

    public Order(Employee employee, Client client, Tattoo tattoo, String bodyPart, BigDecimal total) {
        this.dateTime = LocalDateTime.now();
        this.employee = employee;
        this.client = client;
        this.tattoo = tattoo;
        this.bodyPart = bodyPart;
        this.total = total;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Client getClient() {
        return client;
    }

    public Tattoo getTattoo() {
        return tattoo;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
