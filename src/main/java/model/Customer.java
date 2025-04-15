package model;

import interfaces.DataTransferObject;
import util.ConsoleColor;

public class Customer implements DataTransferObject {


    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone){
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }


    @Override
    public int getId() {
        return this.customerID;
    }

    public void setId(int id){
        this.customerID = id;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public void setCustomerName(String name){
        this.customerName = name;
    }

    public String getCustomerAddress(){
        return this.customerAddress;
    }

    public void setCustomerAddress(String address){
        this.customerAddress = address;
    }

    public String getCustomerPhone(){
        return this.customerPhone;
    }

    public void setCustomerPhone(String phone){
        this.customerPhone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.append("Customer-> ")
                .append(ConsoleColor.CYAN_BOLD_BRIGHT)
                .append("ID: ").append(getId())
                .append("NAME: ").append(getCustomerName())
                .append("ADDRESS: ").append(getCustomerAddress())
                .append("PHONE: ").append(getCustomerPhone()).toString();

    }
}
