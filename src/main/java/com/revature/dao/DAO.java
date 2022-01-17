package com.revature.dao;
import com.revature.Connection.ConnectionUt;
import com.revature.models.Login;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<R>{

    ArrayList<R> objects = new ArrayList<>();
    ConnectionUt database = ConnectionUt.getInstance();
    abstract boolean update() throws SQLException;
    public abstract boolean saveObject(R o) throws SQLException;


}
