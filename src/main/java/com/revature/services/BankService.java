package com.revature.services;
import com.revature.dao.BankDAO;
import com.revature.dao.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Bank;
import com.revature.models.TradeDTO;

public class BankService {

    private BankDAO bankDAO = new BankDAOImpl();





    public Bank callId(int id) {
        return bankDAO.findByID(id);
    }
    public boolean addBank(Bank bank){
        return bankDAO.saveBank(bank);
    }

    public boolean update(Bank bank){
        return bankDAO.update(bank);
    }

    public boolean trade(TradeDTO tradeDTO){
        return bankDAO.trade(tradeDTO);
    }

    public boolean withdraw(TradeDTO tradeDTO){
        return bankDAO.withdraw(tradeDTO);
    }
    public boolean deposit(TradeDTO tradeDTO){
        return bankDAO.trade(tradeDTO);
    }





}
