package com.revature.dao;
import com.revature.models.People;

public interface LoginDAO {
    People login(String username);
}
