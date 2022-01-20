package com.revature.services;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.models.Account;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();




    public List<Account> getAllAccounts() {
        return accountDAO.getAll();
    }

    public boolean addAccount(Account account){
        return accountDAO.saveAccount(account);
    }
    public Account callId(int id) {
        return accountDAO.get(id);
    }

    public boolean updateAccount(Account account) {
        return accountDAO.update(account);

    }
    public Account getAccountByFirstName(String first_name){
        return accountDAO.getAccountByFirstName(first_name);
    }

    public Account getAccountByUsername(String username) {
        if (!username.isEmpty() && validateUsername(username)) {
            return accountDAO.getByUsername(username);
        }
        return null;
    }
    public Account deleteAccount(int id){
        return accountDAO.deleteAccount(id);

    }
    private boolean validateUsername(@NotNull String e) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return  e.matches(regex);
    }





}
