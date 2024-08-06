package controller;



import dao.DataAccessObject;
import model.Customer;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerController extends DataAccessObject<Customer> {



    private final CustomerService customerService;

    public CustomerController(){
        this.customerService = new CustomerService();
    }


    @Override
    public void create(Customer customer) {
        try {
            customerService.create(customer);
            logger.info("Customer created successfully");
        }catch (Exception e){
            logger.error("Error creating customer {}: ",  e.getMessage());
            throw new RuntimeException();
        }

    }

    @Override
    public List<Customer> getAll() {

        try {
            return customerService.getAll();
        }catch (Exception e){
            logger.error("Error retrieving customers: {}", e.getMessage());
                throw new RuntimeException("Failed to retrieve customers", e);
        }
    }

    @Override
    public Customer getById(int id) {
        try {
            return customerService.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving customer by ID: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve customer");
        }

    }

    @Override
    public void update(Customer customer) {
        try {
            customerService.update(customer);
            logger.info("Updating customer was a success");
        }catch (Exception e){
            logger.error("Error updating customer {}", e.getMessage());
            throw new RuntimeException("Failed to update customer", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            customerService.deleteById(id);
            logger.info("Customer deleted successfully");
        }catch (Exception e){
            logger.error("Error deleting a customer {}: ", e.getMessage());
            throw  new RuntimeException("Failed deleting a customer", e);
        }
    }
}
