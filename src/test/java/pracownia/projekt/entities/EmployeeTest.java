package pracownia.projekt.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(5, "Robert", "Nic", 9, "natura", "123456789", "Warszawa", "Bystra 3");
    }

    @Test
    void createNull() {
        Employee employee2 = new Employee();
        assertNull(employee2.getName());
        assertNull(employee2.getSurname());
        assertNull(employee2.getPhone());
        assertNull(employee2.getSpecialization());
        assertNull(employee2.getCity());
        assertNull(employee2.getHomeAddress());
    }

    @Test
    void getId() {
        assertEquals(5, employee.getId());
    }

    @Test
    void getName() {
        assertEquals("Robert", employee.getName());
    }

    @Test
    void setName() {
        employee.setName(null);
        assertNull(employee.getName());
        employee.setName("Patryk");
        assertEquals("Patryk", employee.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Nic", employee.getSurname());
    }

    @Test
    void setSurname() {
        employee.setSurname("Trzy");
        assertEquals("Trzy", employee.getSurname());
    }

    @Test
    void getPhone() {
        assertEquals("123456789", employee.getPhone());
    }

    @Test
    void setPhone() {
        employee.setPhone("123123123");
        assertEquals("123123123", employee.getPhone());
    }

    @Test
    void getHomeAddress() {
        assertEquals("Bystra 3", employee.getHomeAddress());
    }

    @Test
    void setHomeAddress() {
        employee.setHomeAddress("Ludwika 12");
        assertNotEquals("Bystra 3", employee.getHomeAddress());
    }

    @Test
    void getExperienceYears() {
        assertEquals(9, employee.getExperienceYears());
    }

    @Test
    void setExperienceYears() {
        employee.setExperienceYears(0);
        assertEquals(0, employee.getExperienceYears());
    }

    @Test
    void getSpecialization() {
        assertEquals("natura", employee.getSpecialization());
    }

    @Test
    void setSpecialization() {
        employee.setSpecialization("martwa natura");
        assertNotEquals("natura", employee.getSpecialization());
    }

    @Test
    void getCity() {
        assertEquals("Warszawa", employee.getCity());
    }

    @Test
    void setCity() {
        employee.setCity("Bydgoszcz");
        assertNotEquals("Warszawa", employee.getCity());
    }
}
