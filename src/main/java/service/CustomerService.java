package service;

import dao.CustomerDAO;
import dao.DataAccessObject;
import model.Customer;

import java.util.List;

public class CustomerService extends DataAccessObject<Customer> {


    private final CustomerDAO customerDAO;

   public CustomerService(){
       this.customerDAO = new CustomerDAO();
   }

    @Override
    public void create(Customer customer) {

       try {
           customerDAO.create(customer);
           logger.info("Customer created successfully");
       }catch (Exception e){
           logger.error("Error creating customer: {}", e.getMessage());
           throw new RuntimeException("Failed creating customer: ", e);
       }
    }

    @Override
    public List<Customer> getAll() {
       try {
           return customerDAO.getAll();
       }catch (Exception e){
           logger.error("Error retrieving list of customers: {}", e.getMessage());
           throw new RuntimeException("Failed retrieving list of customers: ", e);
       }
    }

    @Override
    public Customer getById(int id) {
       try {
           return customerDAO.getById(id);
       }catch (Exception e){
           logger.error("Error retrieving customer by ID: {}", e.getMessage());
           throw new RuntimeException("Failed retrieving customer by ID: ", e);
       }
    }

    @Override
    public void update(Customer customer) {
       try {
           customerDAO.update(customer);
           logger.info("Updating customer was success");
       }catch (Exception e){
           logger.error("Error updating customer data: {}", e.getMessage());
           throw new RuntimeException("Failed updating customer data: ", e);
       }
    }

    @Override
    public void deleteById(int id) {
      try {
          customerDAO.deleteById(id);
          logger.info("Deleting customer by ID was a success");
      }catch (Exception e){
          logger.error("Error deleting customer by ID: {}", e.getMessage());
          throw new RuntimeException("Failed deleting customer by ID: ", e);
      }
    }
}
