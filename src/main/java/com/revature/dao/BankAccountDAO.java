package com.revature.dao;

import com.revature.models.BankAccount;

import java.util.List;

public interface BankAccountDAO {

    public List<BankAccount> findAll();
    public BankAccount findByID(int id);
    public boolean updateBankAccount(BankAccount bankAccount);
    public boolean addBankAccount(BankAccount bankAccount);


}
