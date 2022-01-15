package pracownia.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pracownia.projekt.entities.Employee;
import pracownia.projekt.repositories.EmployeeRepository;

import java.util.Map;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    public Boolean checkIfExist(Integer id) {
        return employeeRepository.existsById(id);
    }

    public Iterable<Employee> listByMinExperienceYears(int years) {
        return employeeRepository.findByMinExperience(years);
    }

    public Iterable<Map<String, Object>> listEmployeesOrders(int employeeId) {
        return employeeRepository.listEmployeesOrders(employeeId);
    }
}
