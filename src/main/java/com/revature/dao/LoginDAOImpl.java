package com.revature.dao;

import com.revature.Connection.ConnectionUt;
import com.revature.models.Account;
import com.revature.models.UserDTO;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LoginDAOImpl implements LoginDAO{

    @Override
    public UserDTO Login(String username, String password) {
        try(Connection conn = ConnectionUt.getConnection()){
            String sql = "SELECT * FROM accounts WHERE username = " + username +";";
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            List<Account> list = new ArrayList<Account>();
            while(result.next())
            {
                if(result.getString("en_password").equals(password))
                {
                    UserDTO userDTO = new UserDTO();
                    userDTO.accountType = result.getString("account_Type");
                    return userDTO;
                }
                else
                {
                    UserDTO userDTO = new UserDTO();
                    return userDTO;
                }
            }
        }catch(PSQLException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UserDTO();
    }
}
