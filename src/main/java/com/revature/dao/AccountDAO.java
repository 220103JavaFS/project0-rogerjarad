package com.revature.dao;
import com.revature.models.Account;


import java.util.List;

public interface AccountDAO{



    public List<Account> getAll();

    public Account get(int id);

    public boolean saveAccount(Account a);

    boolean update(Account a);

    Account getByEmail(String email);


}
