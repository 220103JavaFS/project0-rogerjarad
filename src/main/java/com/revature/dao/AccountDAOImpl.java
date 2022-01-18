package com.revature.dao;

import com.revature.models.Account;
import com.revature.Connection.ConnectionUt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO{
    private final Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);


    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> list = new ArrayList<>();
        try (Connection conn = ConnectionUt.getConnection()) {
            StringBuffer sql = new StringBuffer("SELECT * FROM accounts ORDER BY id DASC");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql.toString());
            while (result.next()) {
                Account account = new Account();
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setEmail(result.getString("email"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("type"));
                account.setBday(result.getString("bday"));
                account.setId(result.getInt("id"));
            }
        }catch (SQLException e){
            log.warn("ERROR");
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Account get(int id) {
        try(Connection conn = ConnectionUt.getConnection()) {
            StringBuffer sql = new StringBuffer("SELECT * FROM accounts WHERE id = " + id);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql.toString());

            if(result.next()) {
                Account account = new Account();
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setEmail(result.getString("email"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("type"));
                account.setBday(result.getString("bday"));
                account.setId(result.getInt("id"));
                return account;
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean save(Account a) {
        try(Connection conn = ConnectionUt.getConnection()){
            StringBuffer sql = new StringBuffer("INSERT INTO  accounts (first_name, last_name, email, password," +
                    " bday, type) VALUES (?,?,?,?,?,?);");

            PreparedStatement statement = conn.prepareStatement(sql.toString());

            int count = 0;
            statement.setString(++count, a.getFirstName());
            statement.setString(++count, a.getLastName());
            statement.setString(++count, a.getEmail());
            statement.setString(++count, a.getPassword());
            statement.setString(++count, a.getBday());
            statement.setString(++count, "CUSTOMER");

            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Account a) {
        try(Connection conn = ConnectionUt.getConnection()){
            StringBuffer sql = new StringBuffer("UPDATE ACCOUNTS SET" +
                    " first_name = ?, last_name = ?, email = ?, password = ?," +
                    " type = ?, bday = ? WHERE id = ?;");

            PreparedStatement statement = conn.prepareStatement(sql.toString());

            int count = 0;
            statement.setString(++count, a.getFirstName());
            statement.setString(++count, a.getLastName());
            statement.setString(++count, a.getEmail());
            statement.setString(++count, a.getPassword());
            statement.setString(++count, a.getAccountType().name());
            statement.setInt(++count, a.getId());

            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getByEmail(String email) {
        try(Connection conn = ConnectionUt.getConnection()) {
            StringBuffer sql = new StringBuffer("SELECT * FROM accounts WHERE email = ?;");

            PreparedStatement statement = conn.prepareStatement(sql.toString());

            statement.setString(1, email);

            ResultSet result = statement.executeQuery();

            if(result.next()) {
                Account account = new Account();
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setEmail(result.getString("email"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("type"));
                account.setBday(result.getString("bday"));
                account.setId(result.getInt("id"));
                return account;
            }
            return null;

        } catch (SQLException e){
            log.warn("Error while getting account by email: " + email);
            log.error(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return null;

    }


}


