package controller;



import dao.DataAccessObject;
import model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CustomerController extends DataAccessObject<Customer> {


    private final CustomerService customerService;

    public CustomerController(JdbcTemplate jdbcTemplate, CustomerService customerService) {
        super(jdbcTemplate);
        this.customerService = customerService;
    }

    @Override
    public void create(Customer customer) {
        customerService.create(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerService.getById(id);
    }

    @Override
    public void update(Customer customer, int id) {
        customerService.update(customer, id);
    }

    @Override
    public void deleteById(int id) {
        customerService.deleteById(id);

    }
}
