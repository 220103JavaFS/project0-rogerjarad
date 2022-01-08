package com.revature.AccountOptions;
//Roger Gaulke

import com.revature.People.Users;

public interface Services {

    Users registerUsers(String username, String pw);
    Users registerSuper(String username, String pw, boolean superUser);
    Boolean checkSuper();
    Users login(String username, String password);
    void viewUser();
    void createUsers();
    void updateUsers();
    void deleteUsers();

}
