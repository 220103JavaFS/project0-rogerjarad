package com.revature.People;

//Roger Gaulke

public class Accounts {
    private int userI;
    private int accountsID;
    private int money;

    public Accounts(){
        super();
    }

    public Accounts(int userI, int money){
        super();
        this.userI = userI;
        this.money = money;

    }
    public int getUserI(){
        return userI;
    }
    public void setUserI(int userI){
        this.userI = userI;

    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getAccountsID(){
        return accountsID;
    }
    public void setAccountsID(int accountsID){
        this.accountsID = accountsID;
    }

    public String toString(){
        return "Account is= "+ accountsID + " This is the user= " + userI +" amount of money= " + money;
    }
}
