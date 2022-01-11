package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pracownia.projekt.entities.Client;
import pracownia.projekt.services.ClientService;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> list() {
        return clientService.listAllClients();
    }
}
