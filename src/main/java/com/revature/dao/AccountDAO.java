package com.revature.dao;
import com.revature.models.Account;


import java.util.ArrayList;

public interface AccountDAO extends DAO<Account> {


    @Override
    ArrayList<Account> getAll();
    @Override
    Account get(int id);
    @Override
    boolean save(Account a);
    @Override
    boolean update(Account a);

    Account getByEmail(String email);


}
