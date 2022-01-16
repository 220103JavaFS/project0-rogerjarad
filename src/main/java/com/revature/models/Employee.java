package com.revature.models;

public class Employee extends PersonType{

    int employeeNumber;
    Customer employeeCustomer;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String email, int employeeNumber, Customer employeeCustomer) {
        super(id, firstName, lastName, email);
        this.employeeNumber = employeeNumber;
        this.employeeCustomer = employeeCustomer;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Customer getEmployeeCustomer() {
        return employeeCustomer;
    }

    public void setEmployeeCustomer(Customer employeeCustomer) {
        this.employeeCustomer = employeeCustomer;
    }
}
