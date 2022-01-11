package pracownia.projekt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(unique = true)
    @NotNull
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surname;

    @Column
    @NotNull
    private int experienceYears;

    @Column
    @NotNull
    private String specialization;

    @Column
    @NotNull
    private String phone;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String homeAddress;

//    @OneToMany(mappedBy = "employee")
//    private Set<Order> orders;

    public Employee(int id, String name, String surname, int experienceYears, String specialization, String phone, String city, String homeAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.experienceYears = experienceYears;
        this.specialization = specialization;
        this.phone = phone;
        this.city = city;
        this.homeAddress = homeAddress;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
}
