package pracownia.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pracownia.projekt.entities.Client;
import pracownia.projekt.repositories.ClientRepository;

import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    public Boolean checkIfExist(Integer id) {
        return clientRepository.existsById(id);
    }

    public Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage) {
        return clientRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }
}
