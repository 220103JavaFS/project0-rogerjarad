package com.revature.models;


import java.util.ArrayList;

public class Customer extends PersonType {

    ArrayList<BankAccount> bankAccounts;

    public Customer() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public Customer(int id, String firstName, String lastName, String email,  ArrayList<BankAccount> bankAccounts) {
        super(id, firstName, lastName, email);
        this.bankAccounts = bankAccounts;
    }

    public boolean addAccount(BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
        return true;
    }
}
