import controller.CustomerController;
import controller.OrderController;
import controller.TapeController;
import controller.TitleController;
import dao.TapeDAO;
import model.Customer;
import model.Order;
import model.Tape;
import model.Title;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {



    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("1: Tape");
            System.out.println("2: Orders");
            System.out.println("3: Customers");
            System.out.println("4: Titles");
            System.out.println("5: Exit");

            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {

                case 1: tapeCRUD(); break;
                case 2: orderCRUD(); break;
                case 3: customerCRUD(); break;
                case 4: titleCRUD(); break;
                case 5: System.exit(0); break;
                default:
                    System.out.println("Opcion no valida intente nuevamente");

            }

        }

    }

    //CUSTOMER
    protected static void customerCRUD(){
        Scanner scanner = new Scanner(System.in);

        CustomerController customerController = new CustomerController();

        while(true){
            System.out.println("1: Create new Customer");
            System.out.println("2: List of Customers");
            System.out.println("3: Filter customer by ID");
            System.out.println("4: Edit  customer information");
            System.out.println("5: Delete customer information");
            System.out.println("6: Exit");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter customer ID");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter customer full name");
                    String customerName = scanner.nextLine();

                    System.out.println("Enter customer address");
                    String customerAddress = scanner.nextLine();

                    System.out.println("Enter customer phone");
                    String customerPhone = scanner.nextLine();

                    Customer customer = new Customer(id, customerName, customerAddress, customerPhone);
                    customerController.create(customer);
                    break;

                case 2:
                    customerController.getAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Enter Customer ID");
                    int getCustomerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println( customerController.getById(getCustomerId));
                    break;



                case 4:
                    System.out.println("Enter customer ID");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter customer full name");
                    String updateName = scanner.nextLine();

                    System.out.println("Enter customer address");
                    String updateAddress = scanner.nextLine();

                    System.out.println("Enter customer phone");
                    String updatePhone = scanner.nextLine();

                    Customer customerUpdated = new Customer(customerId, updateName, updateAddress, updatePhone);
                    customerController.update(customerUpdated);
                    break;

                case 5:
                    System.out.println( "Enter customer ID to delete ");
                    int deleteCustomerId = scanner.nextInt();
                    scanner.nextLine();
                    customerController.deleteById(deleteCustomerId);
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");

            }

        }

    }

    //TITLE
    protected  static void titleCRUD(){

        Scanner scanner = new Scanner(System.in);
        TitleController titleController = new TitleController();

        while(true){

            System.out.println("1: Create new Title");
            System.out.println("2: List of Titles");
            System.out.println("3: Filter Title by ID");
            System.out.println("4: Edit  Title information");
            System.out.println("5: Delete Title information");
            System.out.println("6: Exit");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1:
                    System.out.println("Enter Title ID");
                    int titleID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Title name");
                    String titleName = scanner.nextLine();
                    System.out.println("Enter Title Year");
                    int titleYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Title Price");
                    float titlePrice = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Insert Title URL");
                    String titleURL = scanner.nextLine();
                    Title title = new Title(titleID, titleName, titleYear, titlePrice, titleURL, "NO IMAGE");
                    titleController.create(title);
                    break;

                case 2:
                    titleController.getAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Insert Title ID");
                    int titleGetId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(titleController.getById(titleGetId));
                    break;

                case 4:
                    System.out.println("Enter Title ID");
                    int titleIDupdated = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Title name");
                    String titleNameUpdated = scanner.nextLine();
                    System.out.println("Enter Title Year");
                    int titleYearUpdated = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Title Price");
                    float titlePriceUpdated = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Insert Title URL");
                    String titleURLupdated= scanner.nextLine();
                    Title titleUpdated = new Title(titleIDupdated, titleNameUpdated, titleYearUpdated, titlePriceUpdated, titleURLupdated, "NO IMAGE");
                    titleController.update(titleUpdated);
                    break;

                case 5:
                    System.out.println("Insert title ID that you want to delete");
                    int titleGetIdToDelete = scanner.nextInt();
                    scanner.nextLine();
                    titleController.deleteById(titleGetIdToDelete);
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");


            }


        }


    }

    //ORDER
    protected  static void orderCRUD(){

         Scanner scanner = new Scanner(System.in);
         OrderController orderController = new OrderController();
         CustomerController customerController = new CustomerController();
         TapeController tapeController = new TapeController();

         while(true){
             System.out.println("1: Create new Order");
             System.out.println("2: List of Orders");
             System.out.println("3: Filter Orders by ID");
             System.out.println("4: Edit  Orders information");
             System.out.println("5: Delete Orders information");
             System.out.println("6: Exit");


             int choice = scanner.nextInt();
             scanner.nextLine();

             switch (choice){

                 case 1:
                     System.out.println("Create Order ID");
                     int orderID = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Type Customer's ID");
                     int customerID = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Type Tape's ID");
                     int tapeID = scanner.nextInt();;
                     scanner.nextLine();

                     System.out.println("Type Date  (yyyy-mm-dd) format");
                     String orderDateString = scanner.nextLine();
                     LocalDate orderDate = LocalDate.parse(orderDateString, DateTimeFormatter.ISO_LOCAL_DATE);

                     System.out.println("Type the status");
                     String orderStatusString = scanner.nextLine();
                     char orderStatus = orderStatusString.charAt(0);

                     Customer customer = customerController.getById(customerID);
                     Tape tape = tapeController.getById(tapeID);
                     Order order = new Order(orderID, customer, tape, orderDate, orderStatus);
                     orderController.create(order);
                     break;

                 case 2: break; //TODO
                 case 3: break; //TODO
                 case 4: break; //TODO
                 case 5: break; //TODO
                 case 6: break; //TODO
                 default:
             }
         }

    } //TODO create logic



    //TAPE
    protected static void tapeCRUD() {

        Scanner scanner = new Scanner(System.in);
        TapeController tapeController = new TapeController();
        TitleController titleController = new TitleController();

        while(true){
            System.out.println("1: Create new Tape");
            System.out.println("2: List of Tapes");
            System.out.println("3: Filter Tapes by ID");
            System.out.println("4: Edit  Tapes information");
            System.out.println("5: Delete Tape s information");
            System.out.println("6: Exit");


            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice){

                case 1:
                    System.out.println("Type tape ID");
                    int tapeID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("type Title ID");
                    int titleID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Insert Title Type");
                    String titleType = scanner.nextLine();

                    Title title = titleController.getById(titleID);
                    Tape newtape = new Tape(tapeID, title, titleType);
                    tapeController.create(newtape);
                    break;

                case 2:
                    tapeController.getAll().forEach(System.out::println); //TODO work on this to retrieve the id as int (error too many connections)
                    break;
                case 3:
                    System.out.println("Type Tape's ID");
                    int tapeGetID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(tapeController.getById(tapeGetID));
                    break;

                case 4:
                    System.out.println("Type tape ID");
                    int tapeIDtoUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("type Title ID");
                    int titleIDtoUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Insert Title Type");
                    String titleTypeToUpdate = scanner.nextLine();

                    Title titleToUpdate = titleController.getById(titleIDtoUpdate);
                    Tape tapeToUpdate = new Tape(tapeIDtoUpdate, titleToUpdate, titleTypeToUpdate);
                    tapeController.update(tapeToUpdate);

                case 5:
                    System.out.println("Type Tape's ID to delete");
                    int tapeToDeleteID = scanner.nextInt();
                    scanner.nextLine();

                    tapeController.deleteById(tapeToDeleteID);
                    break;
                case 6: System.exit(0);
                    break;

                default:     System.out.println("Invalid choice. Please try again");


            }

        }



    }

}

