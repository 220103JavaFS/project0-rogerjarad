package com.revature.services;
import com.revature.dao.BankDAO;
import com.revature.dao.BankDAOImpl;
import com.revature.models.Account;
import com.revature.models.Bank;

public class BankService {

    private BankDAO bankDAO = new BankDAOImpl();



//
//    public boolean changeBank(Bank bank) {
//        return BankDAO.change(bank);
//
//    }

    public Bank callId(int id) {
        return bankDAO.findByID(id);
    }
    public boolean addBank(Bank bank){
        return bankDAO.saveBank(bank);
    }
    public Bank bankDeposit(int account_balance) {
        return bankDAO.deposit(account_balance);
    }

    public Bank bankWithdraw(double account_balance){
        return bankDAO.withdraw(account_balance);
    }



}
