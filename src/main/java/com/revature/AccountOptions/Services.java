package com.revature.AccountOptions;
//Roger Gaulke

import com.revature.People.User;

public interface Services {

    User registerUsers(String username, String pw);
    User registerSuper(String username, String pw, boolean superUser);
    Boolean checkSuper();
    User login(String username, String password);
    void viewUser();
    void createUsers();
    void updateUsers();
    void deleteUsers();

}
