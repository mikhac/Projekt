package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pracownia.projekt.entities.Client;
import pracownia.projekt.entities.Employee;
import pracownia.projekt.entities.Order;
import pracownia.projekt.entities.Tattoo;
import pracownia.projekt.services.ClientService;
import pracownia.projekt.services.EmployeeService;
import pracownia.projekt.services.OrderService;
import pracownia.projekt.services.TattooService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TattooService tattooService;

    @GetMapping(value = "")
    String index() {
        return "Witaj w salonie tatuażu";
    }

    @GetMapping(value = "export", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Iterable<?>> getDatabase() {
        Iterable<Employee> employees = employeeService.listAllEmployees();
        Iterable<Tattoo> tattoos = tattooService.listAllTattoos();
        Iterable<Client> clients = clientService.listAllClients();
        Iterable<Order> orders = orderService.listAllOrders();
        Map<String, Iterable<?>> database = new HashMap<>();
        database.put("Employees", employees);
        database.put("Tattoos", tattoos);
        database.put("Clients", clients);
        database.put("Orders", orders);
        return database;
    }


    @PostMapping(value = "generateData", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        orderService.deleteAllOrders();
        clientService.deleteAllClients();
        tattooService.deleteAllTattoos();
        employeeService.deleteAllEmployees();

        Employee employee1 = new Employee(1, "Jan", "Kowal", 12, "abstrakcja", "456098123", "Warszawa", "Polna 12");
        Employee employee2 = new Employee(2, "Jakub", "Muszla", 5, "rysunek", "634576623", "Otwock", "Ludwika 5");
        Employee employee3 = new Employee(3, "Juan", "Cruz", 7, "realizm", "236773334", "Kolobrzeg", "Mozgowa 20");
        Tattoo tattoo1 = new Tattoo(1, "Pajak", null, "sredni", "czarny", new BigDecimal("80.45"));
        Tattoo tattoo2 = new Tattoo(2, "Roza", "z cierniami", "duzy", "zielony, czerwony", new BigDecimal("50.70"));
        Tattoo tattoo3 = new Tattoo(3, "Gwiazda", null, "maly", "czarny", new BigDecimal("20.00"));
        Client client1 = new Client(1, "Agata", "Nowak", "123456789", "a.nowak@gmail.com");
        Client client2 = new Client(2, "Beata", "Pneumatyczna", "123123123", "beta.pn@interia.pl");
        Client client3 = new Client(3, "Luis", "Bryza", "987654321", "luis.bryza@wp.pl");
        Order order1 = new Order(1, employee1, client3, tattoo3, "reka");
        Order order2 = new Order(2, employee3, client2, tattoo1, "noga");
        Order order3 = new Order(3, employee2, client1, tattoo2, "plecy");

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        employeeService.saveEmployee(employee3);
        tattooService.saveTattoo(tattoo1);
        tattooService.saveTattoo(tattoo2);
        tattooService.saveTattoo(tattoo3);
        clientService.saveClient(client1);
        clientService.saveClient(client2);
        clientService.saveClient(client3);
        orderService.saveOrder(order1);
        orderService.saveOrder(order2);
        orderService.saveOrder(order3);

        return "Data generated";
    }
}
