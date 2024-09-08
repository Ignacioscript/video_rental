package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    Connection connection;

    @Test
    void getConnection() {
        try{
            connection = DBUtil.getConnection();
            assertNotNull(connection, "Conection should not be null");
        }catch (Exception e){
            fail("Exception occured while getting connection: " + e.getMessage() );
        }
    }

    @AfterEach
    void closeConnection(){
        if(connection!=null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}