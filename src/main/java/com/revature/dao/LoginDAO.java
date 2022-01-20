package com.revature.dao;

import com.revature.models.UserDTO;

public interface LoginDAO {
    public UserDTO Login(String username, String password);
}
