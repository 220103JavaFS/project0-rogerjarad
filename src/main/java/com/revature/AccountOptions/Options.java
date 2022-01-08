package com.revature.AccountOptions;
//Roger Gaulke

import com.revature.People.User;

public interface Options {
    public void createAccounts(User user);
    public void deleteAccounts(User user);
    public void viewAccounts(User user);
    public void withdrawAccounts(User user);
    public void depositAccounts(User user);
}
