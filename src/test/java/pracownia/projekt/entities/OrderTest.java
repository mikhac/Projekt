package pracownia.projekt.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        Employee employee = new Employee();
        Client client = new Client();
        Tattoo tattoo = new Tattoo();
        order = new Order(1, employee, client, tattoo, "plecy");
    }

    @Test
    void createNull() {
        Order order2 = new Order();
        assertNull(order2.getEmployee());
        assertNull(order2.getClient());
        assertNull(order2.getTattoo());
        assertNull(order2.getBodyPart());
    }

    @Test
    void getId() {
        assertEquals(1, order.getId());
    }

    @Test
    void getDateTime() {
        assertFalse(order.getDateTime().isAfter(LocalDateTime.now()));
    }

    @Test
    void getEmployee() {
        assertInstanceOf(Employee.class, order.getEmployee());
    }

    @Test
    void getClient() {
        assertInstanceOf(Client.class, order.getClient());
    }

    @Test
    void getTattoo() {
        assertInstanceOf(Tattoo.class, order.getTattoo());
    }

    @Test
    void getBodyPart() {
        assertEquals("plecy", order.getBodyPart());
    }
}
