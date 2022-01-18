package com.revature.models;

import java.util.Objects;

public class Account {



    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private AccountType accountType;
    private String bday;
    int id;

    public enum AccountType {
        CUSTOMER, EMPLOYEE, MANAGER, WRONG

    }

    public Account() {}

    public Account(String firstName, String lastName, String email, String password, String bday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bday = bday;
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public void setAccountType(String accountType) { this.accountType = stringToAccountType(accountType); }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPassword(), getAccountType(), getBday(), getId());
    }
    private AccountType stringToAccountType(String t) {
        switch (t){
            case "CUSTOMER":
                return AccountType.CUSTOMER;
            case "EMPLOYEE":
                return AccountType.EMPLOYEE;
            case "MANAGER":
                return AccountType.MANAGER;
            default:
                return AccountType.WRONG;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", bday='" + bday + '\'' +
                ", id=" + id +
                '}';
    }
}
