package com.revature.dao;
import com.revature.models.Account;


import java.util.List;

public interface AccountDAO{



    public List<Account> getAll();

    public Account get(int id);

    public boolean saveAccount(Account a);

    public boolean update(Account account);

    Account getByEmail(String email);

    Account getAccountByFirstName(String First_name);




}
