package model;

import interfaces.DataTransferObject;

import java.time.LocalDate;
import java.util.Date;

public class Order implements DataTransferObject {

    private int orderNumber;
    private Customer customer;
    private Tape tape;
    private LocalDate date;
    private char status;

    public Order(int orderNumber, Customer customer, Tape tape, LocalDate date, char status) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.tape = tape;
        this.date = date;
        this.status = status;
    }

    public Order() {
    }



    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tape getTape() {
        return tape;
    }

    public void setTape(Tape tape) {
        this.tape = tape;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public int getId() {
        return this.orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customer=" + customer +
                ", tape=" + tape +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}

