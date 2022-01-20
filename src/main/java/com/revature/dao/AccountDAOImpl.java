package com.revature.dao;


import com.revature.models.Account;
import com.revature.Connection.ConnectionUt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO{
    private final Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);


    @Override
    public List<Account> getAll() {
        try (Connection conn = ConnectionUt.getConnection()) {
            String sql = "SELECT * FROM accounts;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Account> list = new ArrayList<>();
            while (result.next()) {
                Account account = new Account();
                account.setId(result.getInt("id"));
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("account_Type"));
                account.setBday(result.getString("bday"));
                list.add(account);

            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Account>();
    }
    @Override
    public Account get(int id) {
        try(Connection conn = ConnectionUt.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE id = " + id+";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Account account = new Account();

            if(result.next()) {
                account.setId(result.getInt("id"));
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("account_Type"));
                account.setBday(result.getString("bday"));
                System.out.println(account);

            }
            return account;


        } catch (SQLException e){
            e.printStackTrace();
        }

        return new Account();
    }

    @Override
    public boolean saveAccount(Account a) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "INSERT INTO  accounts (first_name, last_name, username, password," +
                    " bday, account_Type) VALUES (?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, a.getFirstName());
            statement.setString(++count, a.getLastName());
            statement.setString(++count, a.getUsername());
            statement.setString(++count, a.getPassword());
            statement.setString(++count, a.getAccountType());
            statement.setString(++count, a.getBday());

            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Account account) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "UPDATE accounts SET first_name = ?, last_name = ?, username = ?, password = ?," +
                    " account_type = ?, bday = ? WHERE id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setInt(++count, account.getId());
            statement.setString(++count, account.getFirstName());
            statement.setString(++count, account.getLastName());
            statement.setString(++count, account.getUsername());
            statement.setString(++count, account.getPassword());
            statement.setString(++count, account.getAccountType());
            statement.setString(++count, account.getBday());


            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getByUsername(String username) {
        return null;
    }


    @Override
    public Account getAccountByFirstName(String First_name) {
        try(Connection conn = ConnectionUt.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE first_name = " + First_name+";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Account account = new Account();

            if(result.next()) {
                account.setId(result.getInt("id"));
                account.setFirstName(result.getString("first_name"));
                account.setLastName(result.getString("last_name"));
                account.setUsername(result.getString("username"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("account_Type"));
                account.setBday(result.getString("bday"));
                System.out.println(account);

            }
            return account;


        } catch (SQLException e){
            e.printStackTrace();
        }

        return new Account();
    }


        @Override
        public Account deleteAccount(int id) {
            try(Connection conn = ConnectionUt.getConnection()) {
                String sql = "DELETE * FROM accounts WHERE id = " + id+";";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                Account account = new Account();

                if(result.next()) {
                    account.setId(result.getInt("id"));
                    account.setFirstName(result.getString("first_name"));
                    account.setLastName(result.getString("last_name"));
                    account.setUsername(result.getString("username"));
                    account.setPassword(result.getString("password"));
                    account.setAccountType(result.getString("account_Type"));
                    account.setBday(result.getString("bday"));
                    System.out.println(account);

                }
                return account;


            } catch (SQLException e){
                e.printStackTrace();
            }

            return new Account();
        }


}


