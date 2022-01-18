package com.revature.services;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.models.Account;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();
    public Account getAccountById(int id) {
        return accountDAO.get(id);
    }



    public ArrayList<Account> getAllAccounts() { return accountDAO.getAll(); }

    public Replay saveAccount(Account a) {
        if (a.getFirstName().isEmpty() || a.getLastName().isEmpty()){
            return Replay.TRY_AGAIN;
        }
        if (getAccountByEmail(a.getEmail()) != null){
            return Replay.TRY_AGAIN;
        }

        if (accountDAO.save(a)) {
            return Replay.SUCCESS;
        }
        return Replay.TRY_AGAIN;
    }

    public Replay updateAccount(@NotNull Account a) {
        // Checks if first and last names are set
        if (a.getFirstName().isEmpty() || a.getLastName().isEmpty()){
            return Replay.TRY_AGAIN;
        }

        if (accountDAO.update(a)) {
            return Replay.SUCCESS.SUCCESS;
        }
        return Replay.TRY_AGAIN;
    }

    public Account getAccountByEmail(String email) {
        if (!email.isEmpty() && validateEmail(email)) {
            return accountDAO.getByEmail(email);
        }
        return null;
    }
    private boolean validateEmail(@NotNull String e) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return  e.matches(regex);
    }





}
