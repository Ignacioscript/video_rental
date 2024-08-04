package dao;

import model.Order;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class OrderDAO extends DataAccessObject<Order>{

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);

    private final String INSERT = "";
    private final String UPDATE = "";
    private final String DELETE = "";
    private final String GET_ONE = "";
    private final String GET_ALL = "";

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
