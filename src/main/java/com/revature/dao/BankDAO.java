package com.revature.dao;
import com.revature.models.Account;
import com.revature.models.Bank;
import java.util.List;

public interface BankDAO {

    public Bank findByID(int id);
    public boolean change(Bank b);
    public boolean saveBank(Bank b);
}
