package com.revature.services;
import com.revature.dao.RegisterDAO;
import com.revature.dao.RegisterDAOImpl;
import com.revature.models.People;
import com.revature.MyExc.Except;


import java.sql.SQLException;

public class RegisterService {
    private RegisterDAO registerDAO = new RegisterDAOImpl();
    private LoginService loginService = new LoginService();

    public RegisterService() {
    }

    public boolean register(People people){
        try{
            Credentials.isCredName(people.getFirstName() + " " + people.getLastName());
            Credentials.isCredEmail(people.getEmail());
            Credentials.isCredRole(people.getRoletype());
            LoginService loginService = new LoginService();
            registerDAO.register(people);
            return true;




        }catch(Except e){
            System.out.println(e.getMessage());}
        return false;

    }
}
