package pracownia.projekt.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pracownia.projekt.controllers.IndexController;


@Disabled
class ClientServiceTest {

    private final ClientService clientService = new ClientService();

    @BeforeAll
    static void dataSetup() {
        IndexController indexController = new IndexController();
        indexController.generateModel();
    }

    @Test
    void listAllClients() {
    }

    @Test
    void getClientById() {
    }

    @Test
    void saveClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void deleteAllClients() {
    }

    @Test
    void checkIfExist() {
    }

    @Test
    void listAllClientsPaging() {
    }

    @Test
    void listClientsTattoos() {
    }
}