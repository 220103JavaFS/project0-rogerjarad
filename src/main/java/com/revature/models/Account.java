package com.revature.models;

import java.util.Objects;

public class Account {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountType;
    private String bday;


//    public enum AccountType {
//        CUSTOMER, EMPLOYEE, MANAGER, WRONG
//
//    }

    public Account() {}

    public Account(int id, String firstName, String lastName, String email, String password, String accountType, String bday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.bday = bday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getId() == account.getId() && Objects.equals(getFirstName(), account.getFirstName()) && Objects.equals(getLastName(), account.getLastName()) && Objects.equals(getEmail(), account.getEmail()) && Objects.equals(getPassword(), account.getPassword()) && getAccountType() == account.getAccountType() && Objects.equals(getBday(), account.getBday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getAccountType(), getBday());
    }
//    private AccountType stringToAccountType(String t) {
//        switch (t){
//            case "CUSTOMER":
//                return AccountType.CUSTOMER;
//            case "EMPLOYEE":
//                return AccountType.EMPLOYEE;
//            case "MANAGER":
//                return AccountType.MANAGER;
//            default:
//                return AccountType.WRONG;
//        }
//    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", bday='" + bday + '\'' +
                '}';
    }
}
