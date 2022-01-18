package com.revature.dao;
import com.revature.models.People;
import com.revature.Connection.ConnectionUt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO{


    @Override
    public People login(String username) {
        try(Connection conn = ConnectionUt.getConnection()){
            //String sql = "SELECT * FROM users WHERE user_id = ? AND secret = crypt(?, secret);";
            StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE user_id = ?;");

            PreparedStatement statement = conn.prepareStatement(sql.toString());
            statement.setString(1,username);
            //statement.setString(2, secret);
            ResultSet result = statement.executeQuery();
            People people = new People();
            if(result.next()) {
                people.setId(result.getInt("id"));
                people.setFirstName(result.getString("firstname"));
                people.setLastName(result.getString("lastname"));
                people.setEmail(result.getString("email"));
                people.setPassword(result.getString("password"));
                people.setBday(result.getString("birthday"));
                people.setRoletype(result.getString("role"));


            }
            return people;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new People();
    }


    }

