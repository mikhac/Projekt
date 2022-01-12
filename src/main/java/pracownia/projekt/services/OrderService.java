package pracownia.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pracownia.projekt.entities.Order;
import pracownia.projekt.repositories.OrderRepository;
import java.util.Map;
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

    public Optional<Map<String, Object>> countOrdersByBodyPart(String bodyPart) {
        return orderRepository.countOrdersByBodyPart(bodyPart);
    }
}
