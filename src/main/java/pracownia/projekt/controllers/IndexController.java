package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pracownia.projekt.entities.Client;
import pracownia.projekt.services.ClientService;


@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "")
    String index() {
        return "Welcome";
    }

    @PostMapping(value = "generate", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        clientService.deleteAllClients();

        Client client1 = new Client("Agata", "Nowak", "123456789", "a.nowak@gmail.com");
        Client client2 = new Client("Beata", "Pneumatyczna", "123123123", "beta.pn@interia.pl");
        Client client3 = new Client("Luis", "Bryza", "987654321", "luis.bryza@wp.pl");

        clientService.saveClient(client1);
        clientService.saveClient(client2);
        clientService.saveClient(client3);

        return "Model Generated";
    }
}
