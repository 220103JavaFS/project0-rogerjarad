package com.revature.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.revature.Connection.ConnectionUt;
import com.revature.models.Bank;
import com.revature.models.TradeDTO;

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
    public boolean update(Bank bank) {
        try(Connection conn = ConnectionUt.getConnection()) {
            String sql = "UPDATE bank_account SET account_balance = ? WHERE account_number = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 1;
            statement.setDouble(count++, bank.getAccountBalance());
            statement.setInt(count++, bank.getAccountNumber());


            statement.execute();
            return true;

        }catch(SQLException e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean trade(TradeDTO tradeDTO) {
        try(Connection conn = ConnectionUt.getConnection()) {
            String sql = "CALL trade(?);";



            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, tradeDTO.send);
            statement.setInt(2, tradeDTO.recieve);
            statement.setDouble(3, tradeDTO.amount);
            statement.execute();
            return true;

        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean withdraw(TradeDTO tradeDTO) {
        Bank bank = this.findByID(tradeDTO.getSendid());
        if(bank == null || bank.getAccountBalance()< tradeDTO.getAmount() || tradeDTO.getSend() != bank.getAccountNumber()){
            return false;
        }
        bank.setAccountBalance(bank.getAccountBalance()-tradeDTO.getAmount());
        return this.update(bank);

    }

    @Override
    public boolean deposit(TradeDTO tradeDTO) {
        Bank bank = this.findByID(tradeDTO.getSendid());
        if(bank== null || tradeDTO.getSend() != bank.getAccountNumber()){
            return false;
        }
        bank.setAccountBalance((bank.getAccountBalance()+tradeDTO.getAmount()));
        return this.update(bank);
    }
}




