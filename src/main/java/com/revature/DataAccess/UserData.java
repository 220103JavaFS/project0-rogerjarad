package com.revature.DataAccess;
//Roger Gaulke

import java.util.List;

import com.revature.People.User;

public interface UserData {

    User createUsers(User user);
    void createSuper(User user);

    User getUsers(int id);
    List<User> getAllUsers();

    User upDateUser(User user);

    boolean deleteUser(int id);

}
