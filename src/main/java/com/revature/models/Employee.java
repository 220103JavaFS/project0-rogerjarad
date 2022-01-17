package com.revature.models;

public class Employee extends Login {

    int employeeNumber;
    Customer employeeCustomer;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String email, String password, LoginType loginType, int employeeNumber, Customer employeeCustomer) {
        super(id, firstName, lastName, email, password, loginType);
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
