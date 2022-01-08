package com.revature.People;

public class Accounts {
    private int user;
    private int accounts;
    private int money;

    public Accounts(){
        super();
    }

    public Accounts(int user, int money){
        super();
        this.user = user;
        this.money = money;

    }
    public int getUser(){
        return user;
    }
    public void setUser(int user){
        this.user = user;

    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getAccounts(){
        return accounts;
    }
    public void setAccounts(int accounts){
        this.accounts = accounts;
    }

    public String toString(){
        return "Account is= "+ accounts + " This is the user= " + user +" amount of money= " + money;
    }
}
