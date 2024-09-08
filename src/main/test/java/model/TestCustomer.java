package model;

import model.resolvers.CustomeParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CustomeParameterResolver.class)
public class TestCustomer {



    @Test
    public void testGetId(Customer customer){
        assertEquals(1, customer.getId());

    }

    @Test
    public void testGetName(Customer customer){
        assertEquals("Alan Harper", customer.getCustomerName());

    }

    @Test
    public void testGetAddress(Customer customer){
        assertEquals("Orange County st 123", customer.getCustomerAddress());

    }

    @Test
    public void testGetPhone(Customer customer){
        assertEquals("4447890", customer.getCustomerPhone());

    }


 @Test
    public void testSetId(Customer customer){
        customer.setId(2);
        assertEquals(2, customer.getId());

    }

    @Test
    public void testSetName(Customer customer){
        customer.setCustomerName("Charlie Harper");
        assertEquals("Charlie Harper", customer.getCustomerName());

    }

    @Test
    public void testSetAddress(Customer customer){
        customer.setCustomerAddress("Av 1234");
        assertEquals("Av 1234", customer.getCustomerAddress());

    }

    @Test
    public void testSetPhone(Customer customer){
        customer.setCustomerPhone("111444333");
        assertEquals("111444333", customer.getCustomerPhone());

    }








}
