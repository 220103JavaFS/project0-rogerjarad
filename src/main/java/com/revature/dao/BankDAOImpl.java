package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.revature.Connection.ConnectionUt;
import com.revature.models.Bank;

public class BankDAOImpl implements BankDAO {
    @Override
    public Bank findByID(int id) {
        try (Connection conn = ConnectionUt.getConnection()) {
            String sql = "SELECT * FROM bank_account WHERE account_number = " + id + ";";
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
}
