package pracownia.projekt.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class TattooTest {

    private Tattoo tattoo;

    @BeforeEach
    void setUp() {
        tattoo = new Tattoo(7, "klepsydra", null, "40x30 cm", "szary", new BigDecimal("66.20"));
    }

    @Test
    void createNull() {
        Tattoo tattoo2 = new Tattoo();
        assertNull(tattoo2.getName());
        assertNull(tattoo2.getDescription());
        assertNull(tattoo2.getSize());
        assertNull(tattoo2.getColor());
        assertNull(tattoo2.getPrice());
    }

    @Test
    void getId() {
        assertEquals(7, tattoo.getId());
    }

    @Test
    void getName() {
        assertEquals("klepsydra", tattoo.getName());
    }

    @Test
    void setName() {
        tattoo.setName(null);
        assertNull(tattoo.getName());
        tattoo.setName("smok");
        assertEquals("smok", tattoo.getName());
    }

    @Test
    void getDescription() {
        assertNull(tattoo.getDescription());
    }

    @Test
    void setDescription() {
        tattoo.setDescription("z metalu");
        assertEquals("z metalu", tattoo.getDescription());
    }

    @Test
    void getSize() {
        assertEquals("40x30 cm", tattoo.getSize());
    }

    @Test
    void setPhone() {
        tattoo.setSize("duzy");
        assertEquals("duzy", tattoo.getSize());
    }

    @Test
    void getColor() {
        assertEquals("szary", tattoo.getColor());
    }

    @Test
    void setColor() {
        tattoo.setColor("czarny");
        assertNotEquals("szary", tattoo.getColor());
    }

    @Test
    void getPrice() {
        assertEquals(new BigDecimal("66.20"), tattoo.getPrice());
    }

    @Test
    void setPrice() {
        tattoo.setPrice(BigDecimal.valueOf(0));
        assertEquals(new BigDecimal("0"), tattoo.getPrice());
    }
}
