package com.revature.DataAccess;
//Roger Gaulke

import java.util.ArrayList;

import com.revature.People.Accounts;

public interface AccountsData {

    Accounts createAccounts(Accounts accounts);

    Accounts getAccounts(int accountId);
    ArrayList<Accounts> getUSerAccounts(int userI);

    Accounts updateAccount(Accounts accounts);

    boolean deleteAccounts(int accountID);


}
