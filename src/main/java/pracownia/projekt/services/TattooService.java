package pracownia.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pracownia.projekt.entities.Tattoo;
import pracownia.projekt.repositories.TattooRepository;
import java.util.Optional;


@Service
public class TattooService {

    @Autowired
    private TattooRepository tattooRepository;

    public Iterable<Tattoo> listAllTattoos() {
        return tattooRepository.findAll();
    }

    public Optional<Tattoo> getTattooById(Integer id) {
        return tattooRepository.findById(id);
    }

    public Tattoo saveTattoo(Tattoo tattoo) {
        return tattooRepository.save(tattoo);
    }

    public void deleteTattoo(Integer id) {
        tattooRepository.deleteById(id);
    }

    public void deleteAllTattoos() {
        tattooRepository.deleteAll();
    }

    public Boolean checkIfExist(Integer id) {
        return tattooRepository.existsById(id);
    }

    public Iterable<Tattoo> listAllTattoosPaging(Integer pageNr, Integer howManyOnPage) {
        return tattooRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }
}
