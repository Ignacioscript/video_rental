import controller.CustomerController;
import controller.OrderController;
import controller.TitleController;
import model.Customer;
import model.Order;
import model.Title;

public class Main {

    public static void main (String[] args){


//        OrderController orderController = new OrderController();
        //Order order = orderController.getById(1);
   //     orderController.deleteById(1);


        CustomerController customerController = new CustomerController();

        Customer customer = new Customer(
          400, "Alan Harper", "South Beach", "(443) 567698");

        customerController.create(customer);

    }

}

