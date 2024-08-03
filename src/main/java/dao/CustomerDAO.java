package dao;

import model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);

    private final String INSERT = "Insert into Customers values (?,?,?,?)";
    private final String UPDATE = "UPDATE Customers SET CustomerName=?, CustomerAddress=?, CustomerPhone=? WHERE CustomerId=?";
    private final String DELETE = "DELETE FROM Customers WHERE CustomerId=?";
    private final String GET_ONE = "SELECT * FROM Customers WHERE CustomerId = ?";
    private final String GET_ALL = "SELECT * FROM Customers";



    @Override
    public void create(Customer customer) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(INSERT)){
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerAddress());
            statement.setString(4, customer.getCustomerPhone());
            statement.execute();

            logger.info("Operarion Sucessfully ");

        }catch (SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed: ", e);
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;

        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ALL)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                customer = new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("CustomerName"),
                        rs.getString("CustomerAddress"),
                        rs.getString("CustomerPhone"));
                customerList.add(customer);
            }

        }catch (SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed: ", e);
        }


        return customerList.stream().toList();
    }

    @Override
    public Customer getById(int id) {
        Customer customer;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ONE)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            customer = new Customer(id, rs.getString("CustomerName"), rs.getString("CustomerAddress"), rs.getString("CustomerPhone"));
            logger.info("Getting one value-operarion Sucessfully ");

        }catch (SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed: ", e);
        }

        return customer;
    }

    @Override
    public void update(Customer customer) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(UPDATE)){
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerAddress());
            statement.setString(3, customer.getCustomerPhone());

            statement.setInt(4, customer.getId());
            logger.info("Updating a customer-Operarion Sucessfully ");

        }catch(SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed ", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            logger.info("Deleting a customer-Operarion Sucessfully ");

        }catch (SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed", e);
        }

    }
}
