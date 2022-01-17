package com.revature.services;

import com.revature.dao.LoginDAO;
import com.revature.models.Login;
import org.eclipse.jetty.util.log.Log;

import java.sql.SQLException;
import java.util.ArrayList;


public class LoginService {

    private LoginDAO loginDAO = new LoginDAO();
    public Login getLoginById(int id) {
        return loginDAO.getAccountById(id);
    }

    public Login getLoginByEmail(String email){
        return loginDAO.getLoginByEmail(email);
    }

    public ArrayList<Login> getAllLogin() {
        return loginDAO.getAllLogin();
    }


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


    private boolean errorEmail(String r){
        String mail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return r.matches(mail);
    }


    //new account
    public Outputs saveLogin(Login a) throws SQLException {
        if (!errorEmail(a.getEmail())) {
            return Outputs.ERROR_EMAIL;
        }
        if(loginDAO.saveObject(a)) {
            return Outputs.SUCCESS;
        }

        return Outputs.ERROR;
    }





}
