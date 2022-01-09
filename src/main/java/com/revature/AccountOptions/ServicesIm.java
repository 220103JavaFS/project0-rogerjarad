package com.revature.AccountOptions;
//Roger Gaulke

import com.revature.DataAccess.UserData;

import java.util.ArrayList;
import java.util.Scanner;
import com.revature.People.User;
import com.revature.DataAccess.UserDataIm;


public class ServicesIm implements Services{

//    private static UserData e = new UserDataIm();




    @Override
    public User registerUsers(String username, String pw) {
        return null;
    }

    @Override
    public User registerSuper(String username, String pw, boolean superUser) {
        return null;
    }

    @Override
    public Boolean checkSuper() {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public void viewUser() {

    }

    @Override
    public void createUsers() {

    }

    @Override
    public void updateUsers() {

    }

    @Override
    public void deleteUsers() {

    }
}
