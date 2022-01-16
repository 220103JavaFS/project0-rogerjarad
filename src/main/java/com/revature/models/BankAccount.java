package com.revature.models;

import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private double Balance;


    public BankAccount() {
    }


    public BankAccount(int accountNumber, double Balance, ArrayList<PersonType> accountOwners) {
        this.accountNumber = accountNumber;
        this.deposit(Balance);

    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return Balance;
    }



    public boolean deposit(double money)
    {
        if(money > 0)
        {
            Balance += money;
            return true;
        }

        else
        {
            System.out.println("Error. Negative Deposit attempted.");
            return false;
        }

    }

    public boolean withdraw(double money)
    {
        if(money > 0)
        {
            if(money < Balance)
            {
                Balance -= money;
                return true;
            }

            else
            {
                System.out.println("Error. Withdraw amount is greater then account balance.");
                return false;
            }

        }
        else
        {
            System.out.println("Error. Negative Deposit attempted.");
            return false;
        }
    }
    public boolean addOwner(Customer newOwner)
    {
        newOwner.addAccount(this);
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + Balance +
                '}';
    }

    //This should never change so may need to be set to private, or just removed.
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
