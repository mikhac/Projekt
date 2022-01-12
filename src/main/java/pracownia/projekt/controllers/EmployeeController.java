package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pracownia.projekt.entities.Employee;
import pracownia.projekt.services.EmployeeService;
import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> list() {
        return employeeService.listAllEmployees();
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        Employee result = employeeService.getEmployeeById(id).orElse(null);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getByParamId(@RequestParam("id") int id) {
        Employee result = employeeService.getEmployeeById(id).orElse(null);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/employee/experience", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> getByMinExperienceYears(@RequestParam("years") int years) {
        return employeeService.listByMinExperienceYears(years);
    }

    @GetMapping(value = "/employeesOrders/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Map<String, Object>> getEmployeesOrdersById(@RequestParam("employeeId") int employeeId) {
        return employeeService.listEmployeesOrders(employeeId);
    }


    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> create(@RequestBody @NonNull @Valid Employee employee) {
        if (employeeService.checkIfExist(employee.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employee);
    }


    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> edit(@RequestBody @NonNull @Valid Employee employee) {
        employeeService.saveEmployee(employee);
        if (employeeService.checkIfExist(employee.getId()))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> delete(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/employee")
    public ResponseEntity<Employee> deleteByParamId(@RequestParam("id") int id) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(employee);
    }
}
