import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

   public  static Logger logger  = LoggerFactory.getLogger(Main.class);
    static Integer t = 32;
    static Integer oldT;

    public static void main(String[] args) {


      Main.setTemperature(55);


    }

    public static void setTemperature(Integer temperature){
        oldT = t;
        t = temperature;
        logger.atDebug().log("Temperature set to {}. Old value was {}.", t, oldT);
        if(temperature.intValue()>50){
            logger.info("Temperature has risen above 50 degrees.");
        }

    }
}
