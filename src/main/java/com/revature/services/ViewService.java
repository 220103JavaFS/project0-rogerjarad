package com.revature.services;

import com.revature.models.View;
import com.revature.dao.ViewDAO;

import java.util.ArrayList;

public class ViewService {

    public ViewDAO viewDAO = new ViewDAO();


    public ArrayList<View> listCheckingAccount() {
        return viewDAO.getAllChecking();
    }
}
