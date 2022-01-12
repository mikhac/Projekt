package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pracownia.projekt.entities.Client;
import pracownia.projekt.entities.Employee;
import pracownia.projekt.entities.Order;
import pracownia.projekt.entities.Tattoo;
import pracownia.projekt.services.ClientService;
import pracownia.projekt.services.EmployeeService;
import pracownia.projekt.services.OrderService;
import pracownia.projekt.services.TattooService;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TattooService tattooService;


    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> list() {
        return orderService.listAllOrders();
    }

    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getById(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id).orElse(null);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getByParamId(@RequestParam("id") int id) {
        Order order = orderService.getOrderById(id).orElse(null);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "/orders/{bodyPart}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Map<String, Object>> getCountByBodyPart(@PathVariable("bodyPart") String bodyPart) {
        return orderService.countOrdersByBodyPart(bodyPart);
    }


    @PostMapping(value = "/order")
    public ResponseEntity<Order> createByParam(@RequestParam int id, @RequestParam int employeeId, @RequestParam int clientId,
                                               @RequestParam int tattooId, @RequestParam String bodyPart) {
        if (orderService.checkIfExist(id))
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        Employee employee = employeeService.getEmployeeById(employeeId).orElse(null);
        Client client = clientService.getClientById(clientId).orElse(null);
        Tattoo tattoo = tattooService.getTattooById(tattooId).orElse(null);
        if (employee == null || client == null || tattoo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Order order = new Order(id, employee, client, tattoo, bodyPart);
        orderService.saveOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/order")
    public ResponseEntity<Order> edit(@RequestBody @NonNull @Valid Order order) {
        orderService.saveOrder(order);
        if (orderService.checkIfExist(order.getId()))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Order> delete(@PathVariable int id) {
        Order order = orderService.getOrderById(id).orElse(null);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        orderService.deleteOrder(id);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/order")
    public ResponseEntity<Order> deleteByParamId(@RequestParam("id") int id) {
        Order order = orderService.getOrderById(id).orElse(null);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        orderService.deleteOrder(id);
        return ResponseEntity.ok(order);
    }
}
