package pracownia.projekt.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pracownia.projekt.entities.Employee;

import java.util.Map;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employees WHERE experience_years >= :years", nativeQuery = true)
    Iterable<Employee> findByMinExperience(@Param("years") int years);

    @Query(value = "SELECT e.name, e.surname, o.date_time, o.client, o.tattoo, o.body_part FROM employees e INNER JOIN orders o on e.id = o.done_by WHERE e.id = :employeeId", nativeQuery = true)
    Iterable<Map<String, Object>> listEmployeesOrders(@Param("employeeId") int employeeId);
}
