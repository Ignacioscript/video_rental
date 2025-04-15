package service;

import dao.CustomerDAO;
import dao.DataAccessObject;
import model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends DataAccessObject<Customer> {

    private final CustomerDAO customerDAO;


    public CustomerService(JdbcTemplate jdbcTemplate, CustomerDAO customerDAO) {
        super(jdbcTemplate);
        this.customerDAO = customerDAO;
    }

    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }

    @Override
    public void update(Customer customer, int id) {
        customerDAO.update(customer, id);

    }

    @Override
    public void deleteById(int id) {
        customerDAO.deleteById(id);
    }
}
