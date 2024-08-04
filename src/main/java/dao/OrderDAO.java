package dao;

import model.Order;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class OrderDAO extends DataAccessObject<Order>{

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);

    private final String INSERT = "INSERT INTO Orders VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE Orders SET CustomerID=?, TapeID=?, DueDate=?, Status=? WHERE OrderNumber=?";
    private final String DELETE = "DELETE FROM Orders WHERE OrderNumber=?";
    private final String GET_ONE = "SELECT * FROM Orders WHERE OrderNumber=?";
    private final String GET_ALL = "SELECT * FROM Orders";

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
