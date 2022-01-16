package com.revature.services;

import com.revature.dao.CustomerDAOImpl;
import com.revature.models.Customer;
import com.revature.dao.CustomerDAO;

import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public List<Customer> findAllAccounts()
    {
        return customerDAO.findAll();
    }


}
