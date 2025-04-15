package dao;

import model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO extends DataAccessObject<Customer> {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);

    private final String INSERT = "Insert into Customers values (?,?,?,?);";
    private final String UPDATE = "UPDATE Customers SET CustomerName=?, CustomerAddress=?, CustomerPhone=? WHERE CustomerId=?;";
    private final String DELETE = "DELETE FROM Customers WHERE CustomerId=?;";
    private final String GET_ONE = "SELECT * FROM Customers WHERE CustomerId = ?;";
    private final String GET_ALL = "SELECT * FROM Customers LIMIT 20 OFFSET 0;";

    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    @Override
    public void create(Customer customer) {
        try {
            jdbcTemplate.update(
                    INSERT,
                    customer.getId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone()
            );
            logger.info("CREATE operation successful!");
        }catch (Exception e){
            logger.error("CREATE operation failed");
            throw new RuntimeException();
        }
    }

    @Override
    public List<Customer> getAll() {
        try{
            return jdbcTemplate.query(GET_ALL, customerRowMapper());
        }catch (Exception e){
            e.printStackTrace();
            logger.error("GET ALL operation failed");
            throw new RuntimeException();
        }
    }

    @Override
    public Customer getById(int id) {

        try{
            return jdbcTemplate.queryForObject(GET_ONE, new Object[]{}, customerRowMapper());
        }catch (Exception e){
            e.printStackTrace();
            logger.error("GetByID Operation failed");
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Customer customer, int id) {
        try{
            jdbcTemplate.update(
                    UPDATE,
                    customer.getId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone(),
                    id
            );
            logger.info("UPDATE Operation success!");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("UPDATE operation Failed ");
        }
    }

    @Override
    public void deleteById(int id) {
        try{
            jdbcTemplate.update(DELETE, id);
            logger.info("DELETE Operation success!");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DELETE Operation failed");
            throw  new RuntimeException();
        }

    }

    public RowMapper<Customer> customerRowMapper(){
        return (rs, rowNum)-> new Customer(
                rs.getInt("CustomerId"),
                rs.getString("CustomerName"),
                rs.getString("CustomerAddress"),
                rs.getString("CustomerPhone")

        );
    }
}
