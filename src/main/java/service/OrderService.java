package service;

import dao.DataAccessObject;
import dao.OrderDAO;
import model.Order;

import java.util.List;

public class OrderService extends DataAccessObject<Order> {


    private  OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
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
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Override
    public void deleteById(int id) {
        orderDAO.deleteById(id);
    }
}
