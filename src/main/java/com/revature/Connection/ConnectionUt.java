package com.revature.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUt {



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
}

