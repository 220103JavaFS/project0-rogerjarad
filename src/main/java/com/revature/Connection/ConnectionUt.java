package com.revature.Connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUt {

    private static ConnectionUt instance;
    private Connection connect;



    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(("org.postgresql.Driver"));
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //jdbc:postgresql://endpoint:port/databasename
        String url = "jdbc:postgresql://javafs220103.csabqxhvkoan.us-east-1.rds.amazonaws.com:5432/demos";
        String username = "postgres";  //it is possible and peferable to hide this infomration in environment variables
        String password = "Password";  // those are accessed by System.getenv("var-name");


        return DriverManager.getConnection(url, username, password);
    }
    public static ConnectionUt getInstance() {
        if (instance == null){
            instance = new ConnectionUt();
        }
        return instance;
    }

    public ResultSet executeQuery(String q) throws SQLException {
        ResultSet result = null;

        getConnection();
        try {

            Statement statement = connect.createStatement();
            result = statement.executeQuery(q);

        } catch (SQLException e) {
            System.out.println("Error at " + q);
        }

        closeConnection();

        return result;
    }

    private void closeConnection() {
    }



    public static void main(String[] args){
        try{
            getConnection();
            System.out.println("Connection successfull");
        }catch(SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
    public boolean executeUpdate(String r){
        try {
            getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate(r);


        }catch (SQLException e){
            System.out.println("Error: " + r);
            return false;
        }
        return true;
    }
    public ConnectionUt(){}
}

