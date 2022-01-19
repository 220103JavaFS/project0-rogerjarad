package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.revature.Connection.ConnectionUt;
import com.revature.models.Bank;

public class BankDAOImpl implements BankDAO {
    @Override
    public Bank findByID(int account_number) {
        try (Connection conn = ConnectionUt.getConnection()) {
            String sql = "SELECT * FROM bank_account WHERE account_number = " + account_number + ";";
            Statement statement = conn.createStatement();
            List<Bank> list = new ArrayList<>();

            ResultSet result = statement.executeQuery(sql);
            Bank bank = new Bank();
            if (result.next()) {
                bank.setAccountNumber(result.getInt("account_number"));
                bank.setAccountBalance(result.getDouble("account_balance"));
                list.add(bank);


            }
            return bank;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Bank();
    }


    public boolean change(Bank b) {
        try (Connection conn = ConnectionUt.getConnection()) {
            String sql = "INSERT INTO bank_account (account_number,account_balance) VALUES(" + b.getAccountNumber() + ", " + b.getAccountBalance() + ");";
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveBank(Bank b) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "INSERT INTO  bank_account (account_number, account_balance) VALUES (?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setInt(++count, b.getAccountNumber());
            statement.setDouble(++count, b.getAccountBalance());


            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }




    @Override
    public Bank deposit(int account_balance) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "SELECT * FROM bank_account WHERE account_balance = " + account_balance + ";";
            Statement statement = conn.createStatement();
            List<Bank> list = new ArrayList<>();
            ResultSet result = statement.executeQuery(sql);
            Bank bank = new Bank();
            if (result.next()) {
                bank.setAccountBalance(result.getDouble("account_balance"));
                list.add(bank);
            }return bank;



//            String sql2 = "UPDATE bank_account SET account_balance = ? WHERE account_balance = ?;";
//            PreparedStatement statements = conn.prepareStatement(sql2);
//            ResultSet results = statements.executeQuery();
//            Bank banks = new Bank();
//            if(result.next()){
//                bank.setAccountBalance(results.getDouble("account_balance"));
//            }
//
//            return banks;











        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Bank();
    }

    @Override
    public Bank withdraw(double account_balance) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "SELECT * FROM bank_account WHERE account_balance = " + account_balance + ";";
            Statement statement = conn.createStatement();
            List<Bank> list = new ArrayList<>();
            ResultSet result = statement.executeQuery(sql);
            Bank bank = new Bank();
            bank.setAccountBalance(result.getDouble("account_balance"));
            list.add(bank);





        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

