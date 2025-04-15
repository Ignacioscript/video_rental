import config.AppConfig;
import dao.TitleDAO;
import model.Title;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.ConsoleColor;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);




//        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        CustomerController customerController = context.getBean(CustomerController.class);
        TitleDAO titleDAO = context.getBean(TitleDAO.class);

        try{
//
           // Title title = new Title(105, "Harry Potter I", 1998, 45.2, "HarryPotterOne.com", null);
            System.out.println(titleDAO.getById(102).toString());
//            jdbcTemplate.execute("SELECT 1");


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("HirakiCP connection failed");
        }finally {
            context.close();
        }
    }

}
