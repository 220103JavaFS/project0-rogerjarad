package com.revature.models;

public class Bank {

    int accountNumber;
    double accountBalance;


    public Bank() {
    }

    public Bank(int accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public boolean deposit(double gold){
        if(gold > 0)
        {
            accountBalance += gold;
            return true;
        }

        else
        {
            System.out.println("cant add a negative here.");
            return false;
        }

    }

    public boolean withdraw(double gold){
        if(gold > 0)
        {
            if(gold < accountBalance)
            {
                accountBalance -= gold;
                return true;
            }

            else
            {
                System.out.println("cant withdraw that much.");
                return false;
            }

        }
        else
        {
            System.out.println("cant add a negative here.");
            return false;
        }

    }

    @Override
    public String toString() {
        return "Bank{" +
                "accountNumber=" + accountNumber +
                ", Balance=" + accountBalance +
                '}';
    }

}
