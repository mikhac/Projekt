package pracownia.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pracownia.projekt.entities.Order;
import pracownia.projekt.repositories.OrderRepository;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    public Boolean checkIfExist(Integer id) {
        return orderRepository.existsById(id);
    }

    public Iterable<Order> listAllOrdersPaging(Integer pageNr, Integer howManyOnPage) {
        return orderRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }
}
