package pracownia.projekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pracownia.projekt.entities.Tattoo;


public interface TattooRepository extends CrudRepository<Tattoo, Integer>, PagingAndSortingRepository<Tattoo, Integer> {

}
