package com.revature.models;


import java.util.ArrayList;

public class Customer extends Login {

    ArrayList<BankAccount> bankAccounts;

    public Customer() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public Customer(int id, String firstName, String lastName, String email, String password, LoginType loginType, ArrayList<BankAccount> bankAccounts) {
        super(id, firstName, lastName, email, password, loginType);
        this.bankAccounts = bankAccounts;
    }



    public boolean addAccount(BankAccount newAccount)
    {
        bankAccounts.add(newAccount);
        return true;
    }
}
