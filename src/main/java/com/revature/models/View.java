package com.revature.models;

public class View extends BankAccount{

    private static String accountType = "Checking";

    public View(){

    }

    public View(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
    }

    public static String getAccountType() {
        return accountType;
    }

    public static void setAccountType(String accountType) {
        View.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account: " + accountType +
                "ID: " + this.getAccountNumber() +
                "Available funds: " + this.getBalance() ;
    }


}
