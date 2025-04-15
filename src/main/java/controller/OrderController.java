package controller;

import dao.DataAccessObject;
import model.Order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import service.OrderService;

import java.util.List;

@Controller
public class OrderController extends DataAccessObject<Order> {

    private final OrderService orderService;

    public OrderController(JdbcTemplate jdbcTemplate, OrderService orderService) {
        super(jdbcTemplate);
        this.orderService = orderService;
    }

    @Override
    public void create(Order order) {
        orderService.create(order);
    }

    @Override
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @Override
    public Order getById(int id) {
        return orderService.getById(id);
    }

    @Override
    public void update(Order order, int id) {
        orderService.update(order, id);
    }

    @Override
    public void deleteById(int id) {
        orderService.deleteById(id);
    }
}
