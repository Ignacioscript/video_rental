package dao;

import model.Order;

import java.util.List;

public class OrderDAO extends DataAccessObject<Order>{
    @Override
    public void create(Order order) {

    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void deleteById(int id) {

    }
}
