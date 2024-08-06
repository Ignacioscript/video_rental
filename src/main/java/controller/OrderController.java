package controller;

import dao.DataAccessObject;
import model.Order;

import service.OrderService;

import java.util.List;

public class OrderController extends DataAccessObject<Order> {



    private final OrderService orderService;

    public OrderController(){
        this.orderService = new OrderService();
    }


    @Override
    public void create(Order order) {
        try{
            orderService.create(order);
            logger.info("Order was created successfully");
        }catch (Exception e){
            logger.error("Error creating Order: {}", e.getMessage());
            throw new RuntimeException("Failed creating new Order");
        }
    }

    @Override
    public List<Order> getAll() {
        try{
            return orderService.getAll();
        }catch (Exception e){
            logger.error("Error retrieving List Order {}: ", e.getMessage());
            throw new RuntimeException("Failed retrieving list order:", e);
        }
    }

    @Override
    public Order getById(int id) {
        try{
            return orderService.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving an Order: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving an Order ", e);
        }
    }

    @Override
    public void update(Order order) {
        try{
            orderService.update(order);
            logger.info("Order Updated");
        }catch (Exception e){
            logger.info("Error updating an Order: {}", e.getMessage());
            throw new RuntimeException("Failed updating an Order: {}", e);
        }

    }

    @Override
    public void deleteById(int id) {
        try{
            orderService.deleteById(id);
            logger.info("Data Order deleted succesfully");
        }catch (Exception e){
            logger.info("Error deleting an Order: {}", e.getMessage());
            throw new RuntimeException("Failed deleting and Order: ", e);
        }

    }
}
