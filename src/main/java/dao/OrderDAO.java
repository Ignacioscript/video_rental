package dao;

import model.Customer;
import model.Order;
import model.Tape;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO extends DataAccessObject<Order>{


    private final CustomerDAO customerDAO;
    private final TapeDAO tapeDAO;

    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);

    private final String INSERT = "INSERT INTO Orders(OrderNumber, CustomerID, TapeID, DueDate, Status) VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE Orders SET CustomerID=?, TapeID=?, DueDate=?, Status=? WHERE OrderNumber=?";
    private final String DELETE = "DELETE FROM Orders WHERE OrderNumber=?";
    private final String GET_ONE = "SELECT * FROM Orders WHERE OrderNumber=?";
    private final String GET_ALL = "SELECT * FROM Orders LIMIT 50 OFFSET 0";



    public OrderDAO(JdbcTemplate jdbcTemplate, CustomerDAO customerDAO, TapeDAO tapeDAO) {
        super(jdbcTemplate);
        this.customerDAO = customerDAO;
        this.tapeDAO = tapeDAO;
    }


    @Override
    public void create(Order order) {
        jdbcTemplate.update(INSERT,
                order.getId(),
                order.getCustomer().getId(),
                order.getTape().getId(),
                order.getDate(),
                order.getStatus()
                );

    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query(GET_ALL,  orderRowMapper());
    }

    @Override
    public Order getById(int id) {
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{id}, orderRowMapper());
    }

    @Override
    public void update(Order order, int id) {
        jdbcTemplate.update(UPDATE,
                order.getId(),
                order.getCustomer().getId(),
                order.getTape().getId(),
                order.getDate(),
                order.getStatus(),
                id
        );
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE, id);
    }

    public RowMapper<Order> orderRowMapper(){
        return (rs, rowNum) -> {
            Customer customer;
            Tape tape;
            try{
                customer = customerDAO.getById(rs.getInt("CustomerId"));
                tape = tapeDAO.getById(rs.getInt("TapeID"));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Error fetching Customer or Tape");
            }
            return new Order(
                    rs.getInt("OrderNumber"),
                    customer,
                    tape,
                    rs.getDate("DueDate").toLocalDate(),
                    rs.getString("Status").charAt(0)
            );
        };
    }
}
