package pracownia.projekt.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pracownia.projekt.entities.Client;

import java.util.Map;


public interface ClientRepository extends CrudRepository<Client, Integer>, PagingAndSortingRepository<Client, Integer> {

    @Query(value = "SELECT o.date_time, o.done_by, o.body_part, o.tattoo, t.name, t.description, t.size, t.color, t.price FROM orders o INNER JOIN tattoos t on o.tattoo = t.id WHERE o.client = :clientId", nativeQuery = true)
    Iterable<Map<String, Object>> listTattoosByClient(@Param("clientId") int clientId);
}
