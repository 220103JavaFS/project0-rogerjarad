package com.revature.dao;
import com.revature.models.Bank;
import com.revature.models.TradeDTO;

public interface BankDAO {

    public Bank findByID(int id);
    public boolean change(Bank b);
    public boolean saveBank(Bank b);
    public boolean update(Bank bank);
    public boolean trade (TradeDTO tradeDTO);


}
