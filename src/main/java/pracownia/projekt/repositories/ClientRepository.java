package pracownia.projekt.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pracownia.projekt.entities.Client;


public interface ClientRepository extends CrudRepository<Client, Integer>, PagingAndSortingRepository<Client, Integer> {

//    @Query("select count(*) from Product p where p.id = ?1")
//    Integer checkIfExist(Integer id);
}
