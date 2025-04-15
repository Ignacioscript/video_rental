package service;

import dao.DataAccessObject;
import dao.OrderDAO;
import model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends DataAccessObject<Order> {

    private final OrderDAO orderDAO;

    public OrderService(JdbcTemplate jdbcTemplate, OrderDAO orderDAO) {
        super(jdbcTemplate);
        this.orderDAO = orderDAO;
    }

    @Override
    public void create(Order order) {
        orderDAO.create(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order getById(int id) {
        return orderDAO.getById(id);
    }

    @Override
    public void update(Order order, int id) {
        orderDAO.update(order, id);
    }

    @Override
    public void deleteById(int id) {
        orderDAO.deleteById(id);
    }
}
