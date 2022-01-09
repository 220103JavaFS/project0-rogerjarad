package com.revature.DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCConnection;
import com.revature.People.Accounts;

public class AccountsDataIm implements AccountsData{


    @Override
    public Accounts createAccounts(Accounts accounts) {
        return null;
    }

    @Override
    public Accounts getAccounts(int accountId) {
        return null;
    }

    @Override
    public ArrayList<Accounts> getUSerAccounts(int userI) {
        return null;
    }

    @Override
    public Accounts updateAccount(Accounts accounts) {
        return null;
    }

    @Override
    public boolean deleteAccounts(int accountID) {
        return false;
    }
}
