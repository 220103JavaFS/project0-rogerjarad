package com.revature.models;
import java.util.ArrayList;

public class Bank {

    int accountNumber;
    double Balance;


    public Bank() {
    }

    public Bank(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        Balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
    public boolean deposit(double gold){
        if(gold > 0)
        {
            Balance+= gold;
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
            if(gold < Balance)
            {
                Balance-= gold;
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
                ", Balance=" + Balance +
                '}';
    }

}
