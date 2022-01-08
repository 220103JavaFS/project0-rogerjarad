package com.revature.AccountOptions;
//Roger Gaulke

import com.revature.People.Users;

public interface Options {
    public void createAccounts(Users users);
    public void deleteAccounts(Users users);
    public void viewAccounts(Users user);
    public void withdrawAccounts(Users users);
    public void depositAccounts(Users users);
}
