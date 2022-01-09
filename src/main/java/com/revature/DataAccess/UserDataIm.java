package com.revature.DataAccess;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.People.User;
import util.JDBCConnection;

public class UserDataIm implements UserData{

    @Override
    public User createUsers(User user) {
        return null;
    }

    @Override
    public void createSuper(User user) {

    }

    @Override
    public User getUsers(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User upDateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
