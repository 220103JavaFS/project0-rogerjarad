package com.revature.services;


import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Account;
import com.revature.dao.AccountDAOImpl;
import com.revature.models.UserDTO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();
    public UserDTO Login(String username, String password){
        return loginDAO.Login(username, password);
    }













//
//    public boolean login(String username, String password){
//        if(username.equals("agent")&&password.equals("password")){
//            return true;
//        }else{
//            return false;
//        }
//    }

}



