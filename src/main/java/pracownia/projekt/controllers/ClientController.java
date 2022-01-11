package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pracownia.projekt.entities.Client;
import pracownia.projekt.services.ClientService;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> list() {
        return clientService.listAllClients();
    }

    @GetMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getById(@PathVariable("id") int id) {
        Client result = clientService.getClientById(id).orElse(null);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getByParamId(@RequestParam("id") int id) {
        Client result = clientService.getClientById(id).orElse(null);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(result);
    }


    @PostMapping(value = "/client")
    public ResponseEntity<Client> create(@RequestBody @NonNull @Valid Client client) {
        if (clientService.checkIfExist(client.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        clientService.saveClient(client);
        return ResponseEntity.ok(client);
    }


    @PutMapping(value = "/client")
    public ResponseEntity<Client> edit(@RequestBody @NonNull @Valid Client client) {
        clientService.saveClient(client);
        if (clientService.checkIfExist(client.getId()))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/client/{id}")
    public ResponseEntity<Client> delete(@PathVariable int id) {
        Client client = clientService.getClientById(id).orElse(null);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        clientService.deleteClient(id);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping(value = "/client")
    public ResponseEntity<Client> deleteByParamId(@RequestParam("id") int id) {
        Client client = clientService.getClientById(id).orElse(null);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        clientService.deleteClient(id);
        return ResponseEntity.ok(client);
    }
}
