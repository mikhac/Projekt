package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(unique = true)
    @NotNull
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

    public Order(int id, Employee employee, Client client, Tattoo tattoo, String bodyPart) {
        this.id = id;
        this.dateTime = LocalDateTime.now();
        this.employee = employee;
        this.client = client;
        this.tattoo = tattoo;
        this.bodyPart = bodyPart;
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
}
