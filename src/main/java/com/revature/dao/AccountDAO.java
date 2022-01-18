package com.revature.dao;
import com.revature.models.People;
import java.util.ArrayList;

public interface AccountDAO extends DAO<People> {

    People getByEmail(String email);

    @Override
    ArrayList<People> getAll();
    @Override
    People get(int id);
    @Override
    boolean save(People a);
    @Override
    boolean update(People o);
    @Override
    boolean delete(int id);


}
