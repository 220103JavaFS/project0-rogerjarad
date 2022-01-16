package com.revature.dao;

import com.revature.models.View;

import java.util.ArrayList;

public class ViewDAO {

    private static ArrayList<View> viewAccounts;

    public ViewDAO(){

        viewAccounts = new ArrayList<View>();

        viewAccounts.add(new View(
                12.14
        ));
    }

    public ArrayList<View> getAllChecking(){
        return viewAccounts;
    }
}
