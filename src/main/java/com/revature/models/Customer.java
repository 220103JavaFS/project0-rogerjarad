package com.revature.models;
import java.util.ArrayList;
import java.util.Objects;

public class Customer extends People{


    ArrayList<Bank> banks;

    public Customer() {
        this.banks = new ArrayList<Bank>();
    }

    public Customer(int id, String firstName, String lastName, String email, String password, String bday, String roletype, ArrayList<Bank> banks) {
        super(id, firstName, lastName, email, password, bday, roletype);
        this.banks = banks;
    }
    public boolean addAccount(Bank newAccount){
        banks.add(newAccount);
        return true;
    }


}
