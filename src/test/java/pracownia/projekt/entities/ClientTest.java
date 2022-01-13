package pracownia.projekt.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client(1, "Anna", "Dwa", "123456789", "an.dw@gmail.com");
    }

    @Test
    void createNull() {
        Client client2 = new Client();
        assertNull(client2.getName());
        assertNull(client2.getSurname());
        assertNull(client2.getPhone());
        assertNull(client2.getEmail());
    }

    @Test
    void getId() {
        assertEquals(1, client.getId());
    }

    @Test
    void getName() {
        assertEquals("Anna", client.getName());
    }

    @Test
    void setName() {
        client.setName(null);
        assertNull(client.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Dwa", client.getSurname());
    }

    @Test
    void setSurname() {
        client.setSurname("Trzy");
        assertEquals("Trzy", client.getSurname());
    }

    @Test
    void getPhone() {
        assertEquals("123456789", client.getPhone());
    }

    @Test
    void setPhone() {
        client.setPhone("123123123");
        assertEquals("123123123", client.getPhone());
    }

    @Test
    void getEmail() {
        assertEquals("an.dw@gmail.com", client.getEmail());
    }

    @Test
    void setEmail() {
        client.setEmail("abc");
        assertNotEquals("an.dw@gmail.com", client.getEmail());
    }
}
