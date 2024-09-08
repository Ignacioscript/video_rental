package dao;

import model.Customer;
import model.Order;
import model.Tape;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(INSERT)){
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getCustomer().getId());
            statement.setInt(3, order.getTape().getId());
            statement.setString(4, order.getDate().toString());
            statement.setString(5, String.valueOf(order.getStatus()));
            statement.executeUpdate();
            logger.info("Order created in database");
        }catch (SQLException e){
            logger.error("Failed to create order data in database");
            throw new RuntimeException();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList =new ArrayList<>();
        Order order;
        Customer customer;
        Tape tape;

        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ALL)){
            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                //retrieving db columns' int values
                int customerId = rs.getInt("CustomerID");
                int tapeId = rs.getInt("TapeID");

                // - creating objects and using method getById to initialize them
                // - - int values previous obtained from db
                customer = new CustomerDAO().getById(customerId);
                tape = new TapeDAO().getById(tapeId);
                char status = rs.getString("Status").charAt(0);

                //passing the argments to create a new Order Object
                order = new Order(
                        rs.getInt("OrderNumber"),
                        customer,
                        tape,
                        rs.getDate("DueDate").toLocalDate(),
                        status
                        );

                //Adding the new Order Object to a order list
                orderList.add(order);
            }
            logger.info("Retrieving order list was a success");

        }catch (SQLException e){
            logger.error("Error retrieving order list");
            throw new RuntimeException();
        }

        return orderList;
    }

    @Override
    public Order getById(int id) {
        Order order;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ONE)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);

            int customerId = rs.getInt("CustomerID");
            int tapeId = rs.getInt("TapeID");
            char status = rs.getString("Status").charAt(0);

            Customer customer = new CustomerDAO().getById(customerId);
            Tape tape = new TapeDAO().getById(tapeId);

            order = new Order(
                    rs.getInt("OrderNumber"),
                    customer,
                    tape,
                    rs.getDate("DueDate").toLocalDate(),
                    status
            );
            logger.info("Order retrieved successfully");

        }catch (SQLException e){
            logger.error("Retrieving Order by ID failed");
            throw new RuntimeException();
        }
        return order;
    }

    @Override
    public void update(Order order) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(UPDATE)){
            statement.setInt(1, order.getCustomer().getId());
            statement.setInt(2, order.getTape().getId());
            statement.setString(3, order.getDate().toString());
            statement.setString(4, String.valueOf(order.getStatus()));
            statement.setInt(5, order.getId());
            statement.executeUpdate();

            logger.info("Order data  was updated ");

        }catch (SQLException e){
            logger.error("Error on Updating Order data ");
        }
    }

    @Override
    public void deleteById(int id) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            statement.execute();
            logger.info("Order data deleted successfully");
        }catch (SQLException e){
            logger.error("Error Deleting order data");
            throw new RuntimeException();
        }
    }


}
