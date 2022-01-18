package com.revature.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.Connection.ConnectionUt;
import com.revature.models.People;
import java.sql.*;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO{
    private final Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);


    @Override
    public People getByEmail(String email) {
        return null;
    }

    @Override
    public ArrayList<People> getAll() {
        return null;
    }

    @Override
    public People get(int id) {
        return null;
    }

    @Override
    public boolean save(People a) {
        return false;
    }

    @Override
    public boolean update(People o) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
