package pracownia.projekt.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pracownia.projekt.entities.Order;

import java.util.Map;
import java.util.Optional;


public interface OrderRepository extends CrudRepository<Order, Integer>, PagingAndSortingRepository<Order, Integer> {

    @Query(value = "SELECT COUNT(*) FROM orders WHERE body_part = :bodyPart", nativeQuery = true)
    Optional<Map<String, Object>> countOrdersByBodyPart(@Param("bodyPart") String bodyPart);
}
