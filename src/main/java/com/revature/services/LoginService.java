package com.revature.services;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class LoginService {

    public boolean login(String username, String password){
        if(username.equals("agent")&&password.equals("password")){
            return true;
        }else{
            return false;
        }
    }

}
