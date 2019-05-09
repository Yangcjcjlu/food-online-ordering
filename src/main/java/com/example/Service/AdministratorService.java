package com.example.Service;

import com.example.Dao.AdministratorDao;
import com.example.Dao.CustomerDao;
import com.example.Model.Administrator;
import com.example.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ThinkPad on 2019/1/7.
 */
@Service("AdministratorDao")
public class AdministratorService implements AdministratorDao{

    @Autowired
    private AdministratorDao administratorDao;


    @Override
    public void insert(Administrator administrator) {
        this.administratorDao.insert(administrator);
    }

    @Override
    public Administrator get(String name) {
        return this.administratorDao.get(name);
    }

    @Override
    public boolean isExist(String name) {
        Administrator administrator =administratorDao.get(name);
        if(administrator==null){
            return false;
        }
        return true;
    }
}
