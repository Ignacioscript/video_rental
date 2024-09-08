package model;

import model.resolvers.CustomeParameterResolver;
import model.resolvers.OrderParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@ExtendWith(OrderParameterResolver.class)
//@ExtendWith(CustomeParameterResolver.class)
class OrderTest   {



    @Test
    void setOrderNumber(Order order) {
        assertEquals(1, order.getId());
    }

    @Test
    void getCustomer(Order order) {
        assertEquals(1, order.getCustomer().getId());
    }

    @Test
    void setCustomer(Order order) {

    }

    @Test
    void getTape(Order order) {
        assertEquals(1, order.getTape().getId());
    }

    @Test
    void setTape(Order order) {
    }

    @Test
    void getDate(Order order) {
        assertEquals(LocalDate.of(1985, 1, 18), order.getDate());
    }

    @Test
    void setDate(Order order) {
        order.setDate(LocalDate.of(1986, 1, 19));
        assertEquals(LocalDate.of(1986, 1, 19), order.getDate());
    }

    @Test
    void getStatus(Order order) {
        assertEquals('S', order.getStatus());
    }

    @Test
    void setStatus(Order order) {
        order.setStatus('A');
        assertEquals('A', order.getStatus());
    }

    @Test
    void getId(Order order) {
        assertEquals(1, order.getId());
    }

}