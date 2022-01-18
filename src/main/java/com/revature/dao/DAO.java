package com.revature.dao;
import java.util.ArrayList;

public interface DAO<R> {
    boolean saveAccount(R o);

    boolean update(R o);


    ArrayList<R> getAll();

    R get(int id);
}
