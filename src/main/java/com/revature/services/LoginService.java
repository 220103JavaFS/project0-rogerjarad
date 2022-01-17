package com.revature.services;

import com.revature.dao.LoginDAO;


public class LoginService {

    private LoginDAO loginDAO = new LoginDAO();

//    public Person getPersonByID(int id) {
//        return loginDAO.get
//    }

    public boolean login(String username, String password){
        System.out.println("password" + password);
        if(username.equals("agent") & password.equals("password"))
        {
            System.out.println("success");
            return true;
        }else {
            return false;
        }
    }
}
