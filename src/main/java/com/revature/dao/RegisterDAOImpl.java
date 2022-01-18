package com.revature.dao;
import com.revature.models.People;
import com.revature.Connection.ConnectionUt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAOImpl implements RegisterDAO{


    @Override
    public boolean register(People people) {
        try(Connection conn = ConnectionUt.getConnection()){
            StringBuilder sql = new StringBuilder("INSERT INTO people (firstname, lastname, email, phone_number, dob, user_id, secret, rolez) " +
                    "Values (?, ?, ?, ?, ?, ?, ?, ?);");
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            int count = 0;
            statement.setInt(++count,people.getId());
            statement.setString(++count,people.getFirstName());
            statement.setString(++count,people.getLastName());
            statement.setString(++count,people.getEmail());
            statement.setString(++count,people.getPassword());
            statement.setString(++count,people.getBday());
            statement.setString(++count,people.getRoletype());

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
