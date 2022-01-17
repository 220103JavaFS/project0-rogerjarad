package com.revature.dao;

import com.revature.models.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends DAO<Login>{

    private final Logger log = LoggerFactory.getLogger(LoginDAO.class);

    public Login getLoginByEmail (String email){
        for (Login b : objects) {
            if(b.getEmail().equals(email)){
                return b;

            }
        }
        return null;
    }

    public Login getAccountById(int id) {
        for (Login b : objects) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }


    @Override
    boolean update() throws SQLException {
        ResultSet accounts_data = database.executeQuery("SELECT * FROM accounts");
        try {
            while(accounts_data.next()){
                objects.add(new Login(
                        accounts_data.getInt("id"),
                        accounts_data.getString("first_name"),
                        accounts_data.getString("last_name"),
                        accounts_data.getString("email"),
                        accounts_data.getString("password"),
                        accounts_data.getString("login_type")



                ));
            }
            accounts_data.close();
        }catch(SQLException e){
            return false;
        }

        return false;
    }

    @Override
    public boolean saveObject(Login o) throws SQLException {
        StringBuilder add_entry = new StringBuilder();
        add_entry.append("INSERT INTO accounts (first_name, last_name, email, password, login_type) VALUES(");
        add_entry.append("'"+ o.getFirstName() + "',");
        add_entry.append("'"+ o.getLastName() + "',");
        add_entry.append("'"+ o.getEmail() + "',");
        add_entry.append("'"+ o.getPassword() + "',");
        add_entry.append("'CUSTOMER');");

        if(database.executeUpdate(add_entry.toString())) {
            return update();
        }
        return false;
    }


}

