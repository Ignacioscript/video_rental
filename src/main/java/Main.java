import controller.CustomerController;
import controller.TitleController;
import model.Customer;
import model.Title;

public class Main {

    public static void main (String[] args){

        TitleController titleController = new TitleController();
      //TODO review this output: -> Cannot invoke "Object.toString()" because the return value of "java.sql.ResultSet.getBlob(String)" is null

        Title title = titleController.getById(4);
        System.out.println(title.toString());


        //TODO add rs.next() to the Result sets methods
        //TODO reiew the null pointException, consider removing the blop images to testing. DONE!


        CustomerController customerController = new CustomerController();
       Customer customer =  customerController.getById(2);

        System.out.println(customer.toString());

    }

}

