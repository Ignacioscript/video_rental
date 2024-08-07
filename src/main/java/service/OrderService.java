package service;

import dao.DataAccessObject;
import dao.OrderDAO;
import model.Order;

import java.util.List;

public class OrderService extends DataAccessObject<Order> {


    private  OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }


    @Override
    public void create(Order order) {
        try {
            orderDAO.update(order);
            logger.info("Creating order was success");
        }catch (Exception e){
            logger.error("Error creating order data: {}", e.getMessage());
            throw new RuntimeException("Failed creating order data: ", e);
        }

    }

    @Override
    public List<Order> getAll() {
        try {
            return orderDAO.getAll();

        }catch (Exception e){
            logger.error("Error retrieving order list data: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving order list data: ", e);
        }
    }

    @Override
    public Order getById(int id) {
        try {
            return orderDAO.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving Order by ID: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Order by ID: ", e);
        }
    }

    @Override
    public void update(Order order) {
        try {
            orderDAO.update(order);
            logger.info("Updating Order was success");
        }catch (Exception e){
            logger.error("Error updating Order data: {}", e.getMessage());
            throw new RuntimeException("Failed updating Order data: ", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            orderDAO.deleteById(id);
            logger.info("Deleting Order by ID was a success");
        }catch (Exception e){
            logger.error("Error deleting Order by ID: {}", e.getMessage());
            throw new RuntimeException("Failed deleting Order by ID: ", e);
        }
    }
}
