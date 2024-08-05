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
    public void update(Customer customer) {
       customerDAO.update(customer);

    }

    @Override
    public void deleteById(int id) {
       customerDAO.deleteById(id);

    }
}
