package org.example.customers;

public class Customers {
    private int CustomerID;
private String Name;

    public Customers(int customerID, String name, String email, String phone) {
        CustomerID = customerID;
        Name = name;
        Email = email;
        Phone = phone;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    private String Email;
private String Phone;
}
